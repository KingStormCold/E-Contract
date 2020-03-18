package vn.easycredit.internalapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import vn.easycredit.config.setting.EcontractConfigSetting;
import vn.easycredit.config.setting.SmsApiInfo;
import vn.easycredit.internalapi.request.SendMessageRequest;
import vn.easycredit.utilities.HttpsUtilities;

@Getter
@Setter
@Component
@Slf4j
public class SMSApi {
	
	@Autowired
	private EcontractConfigSetting econtractConfigSetting;
	
	@Autowired
	private HttpsUtilities httpsUtilities;
	
	@Autowired
	private AccessToken token;

	public String sendMessage(SendMessageRequest request) {
		log.info("[START] Send SMS");
		try {
			SmsApiInfo smsApiInfo = econtractConfigSetting.getInternalApiInfo().getSmsApiInfo();
			String accessToken = token.getAccessToken(smsApiInfo.getClientId(),
					smsApiInfo.getClientSecret(),
					smsApiInfo.getAccessTokenUrl(),
					smsApiInfo.getGrantType());
			if (StringUtils.isEmpty(accessToken)) {
				log.info("SmsApi->sendMessage: cannot get access token");
				return null;
			}
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Object> httpEntity = new HttpEntity<>(request, token.getHttpHeaders(accessToken));
			ResponseEntity<String> responseEntity = restTemplate.exchange(smsApiInfo.getSendSmsUrl(), HttpMethod.POST, httpEntity, String.class);
			log.info("[END] Send SMS");
			if(responseEntity == null){
				return null;
			}
			log.info("REsult " + responseEntity.getBody());
			return responseEntity.getBody();	
		} catch (HttpStatusCodeException e){
			log.info("sendMessage->HttpStatusCodeException: " + e.getResponseBodyAsString(), e);
			return null;
		} catch (Exception e) {
			log.info("sendMessage->Exception: " + e.toString(), e);
			return null;
		}
	}
}
