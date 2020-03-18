package vn.easycredit.internalapi;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import vn.easycredit.internalapi.response.AccessTokenResponse;
import vn.easycredit.utilities.HttpsUtilities;

@Getter
@Setter
@Component
@Slf4j
public class AccessToken {
	
	@Autowired
	private HttpsUtilities httpsUtilities;

	public HttpHeaders getHttpHeaders(String accessToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.add("Authorization", "Bearer " + accessToken);
		return headers;
	}

	public String getAccessToken(String clientId, String clientSecret, String accessTokenUrl, String grantTypeToken){
		log.info("InternalApi getAccessToken");
		if (StringUtils.isEmpty(accessTokenUrl)) {
			log.info("InternalApi getAccessToken : token url missing from config");
			return null;
		}
		String grantType = "grant_type=" + grantTypeToken;
		try {
			HttpEntity<Object> httpEntity = new HttpEntity<>(grantType, getHttpHeadersAccessToken(clientId, clientSecret));

			ResponseEntity<AccessTokenResponse> responseEntity = httpsUtilities.getResponseEntity(accessTokenUrl, httpEntity, AccessTokenResponse.class, HttpMethod.POST, HttpsUtilities.DEFAULT_TIMEOUT);

			if (StringUtils.isEmpty(responseEntity) || responseEntity.getStatusCode() != HttpStatus.OK) {
				return null;
			}

			if (responseEntity.getBody() != null) {
				return responseEntity.getBody().getAccessToken();
			} else {
				return null;
			}
			
		} catch (Exception e) {
			log.info("InternalApi->getAccessToken Error: " + e.toString(), e);
			return null;
		}
	}
	
	private HttpHeaders getHttpHeadersAccessToken(String clientId, String clientSecret) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/x-www-form-urlencoded");
		headers.add("Authorization", "Basic " + encodedClientInfo(clientId, clientSecret));
		return headers;
	}
	
	private String encodedClientInfo(String clientId, String clientSecret){
		String clientInfo = clientId + ":" + clientSecret;
		final byte[] encodedClientInfo = Base64.encodeBase64(clientInfo.getBytes());
		return new String(encodedClientInfo);
	}
}
