package vn.easycredit.internalapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import vn.easycredit.config.setting.DocApiInfo;
import vn.easycredit.config.setting.EcontractConfigSetting;
import vn.easycredit.internalapi.request.DocApiRequest;
import vn.easycredit.internalapi.response.DocApiResponse;
import vn.easycredit.utilities.HttpsUtilities;

@Getter
@Setter
@Component
@Slf4j
public class DocApi {
	
	private static final int MILISECOND = 1000;
	
	@Autowired
	private EcontractConfigSetting econtractConfigSetting;
	
	@Autowired
	private HttpsUtilities httpsUtilities;
	
	@Autowired
	private AccessToken token;

	public DocApiResponse getInfoDoc(DocApiRequest request) {
		log.info("[START] Call API Doc");
		try {
			DocApiInfo docApiInfo = econtractConfigSetting.getInternalApiInfo().getDocApiInfo();
			String accessToken = token.getAccessToken(docApiInfo.getClientId(),
					docApiInfo.getClientSecret(),
					docApiInfo.getAccessTokenUrl(),
					docApiInfo.getGrantType());
			if (StringUtils.isEmpty(accessToken)) {
				log.info("DocApi->call doc: cannot get access token");
				return null;
			}
			SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
			factory.setConnectTimeout(Integer.valueOf(docApiInfo.getTimeOut()) * MILISECOND);
			factory.setReadTimeout(Integer.valueOf(docApiInfo.getTimeOut()) * MILISECOND);
			RestTemplate restTemplate = new RestTemplate(factory);
			HttpEntity<Object> httpEntity = new HttpEntity<>(request, token.getHttpHeaders(accessToken));
			ResponseEntity<DocApiResponse> responseEntity = restTemplate.exchange(docApiInfo.getDocApiUrl(),
					HttpMethod.POST, httpEntity, DocApiResponse.class);
			log.info("[END]");
			if(responseEntity == null){
				return null;
			}
			log.info("REsult " + responseEntity.getBody());
			return responseEntity.getBody();
		} catch (HttpStatusCodeException e){
			log.info("DocApi->HttpStatusCodeException: " + e.getResponseBodyAsString(), e);
			return null;
		} catch (Exception e) {
			log.info("DocApi->Exception: " + e.toString(), e);
			return null;
		}
	}
}
