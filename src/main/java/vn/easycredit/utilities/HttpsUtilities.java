package vn.easycredit.utilities;

import java.io.Serializable;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HttpsUtilities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	@Value("${by_pass_ssl_imx}")
	private String isByPassSsl;

	private static final int MILISECOND = 1000;

	public static final int DEFAULT_TIMEOUT = 60;
	
	public <T> ResponseEntity<T> getResponseEntity(String url, HttpEntity<Object> httpEntity,
			Class<T> variableType, HttpMethod httpMethod, int timeout) throws HttpStatusCodeException, Exception {
		ResponseEntity<T> responseEntity = null;
		log.info("getResponseEntity url: " + url);
		try {
			if (this.isByPassSsl.equals("1")) {
				TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
				SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
						.loadTrustMaterial(null, acceptingTrustStrategy).build();
				SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext,
						NoopHostnameVerifier.INSTANCE);
				CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();

				HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
				requestFactory.setHttpClient(httpClient);
				requestFactory.setReadTimeout(timeout * MILISECOND);
				requestFactory.setConnectTimeout(timeout * MILISECOND);
				RestTemplate restTemplate = new RestTemplate(requestFactory);

				responseEntity = restTemplate.exchange(url, httpMethod, httpEntity, variableType);
			} else {
//				int timeout = 50;
				SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
				factory.setReadTimeout(timeout * MILISECOND);
				factory.setConnectTimeout(timeout * MILISECOND);
				RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(factory));

				responseEntity = restTemplate.exchange(url, httpMethod, httpEntity, variableType);
			}
			return responseEntity;
		} catch (KeyManagementException e) {
			log.info("getResponseEntity KeyManagementException: " + e.toString(), e);
			throw new KeyManagementException();
		} catch (NoSuchAlgorithmException e) {
			log.info("getResponseEntity NoSuchAlgorithmException: " + e.toString(), e);
			throw new NoSuchAlgorithmException();
		} catch (KeyStoreException e) {
			log.info("getResponseEntity KeyStoreException: " + e.toString(), e);
			throw new KeyStoreException();
		}
	}
}
