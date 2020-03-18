package vn.easycredit.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author HienNT
 */
@Slf4j
@Component("authenticationRequestInfo")
public class AuthenticationRequestInfo {
	
	private String clientId;

	private String userName;

	private long dateTimeRequest;

	private RequestInfo requestInfo;

	private String status;
	
	public AuthenticationRequestInfo(String clientId, String userName, long dateTimeRequest, RequestInfo requestInfo,
			String status) {
		super();
		this.clientId = clientId;
		this.userName = userName;
		this.dateTimeRequest = dateTimeRequest;
		this.requestInfo = requestInfo;
		this.status = status;
	}

	public AuthenticationRequestInfo() {
		super();
	}

	private static class Instance {
		static final AuthenticationRequestInfo instanceAuthenticationRequestInfo = new AuthenticationRequestInfo();

		private Instance() {
			super();
		}
	}

	public static AuthenticationRequestInfo getInstance() {
		return Instance.instanceAuthenticationRequestInfo;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		this.userName = auth.getName();
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getDateTimeRequest() {
		return dateTimeRequest;
	}

	public void setDateTimeRequest(long dateTimeRequest) {
		this.dateTimeRequest = dateTimeRequest;
	}

	public RequestInfo getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// public AuthenticationRequestInfo(OAuth2Authentication auth) {
	// // final OAuth2AuthenticationDetails details =
	// // (OAuth2AuthenticationDetails) auth.getDetails();
	// // this.accessToken = details.getTokenValue();
	//// this.clientId = auth.getOAuth2Request().getClientId();
	//// this.userName = auth.getUserAuthentication().getName();
	//// this.dateTimeRequest = new Date();
	//// Iterator<GrantedAuthority> list = auth.getAuthorities().iterator();
	//// listPerm = new ArrayList<PermissionInfo>();
	//// while (list.hasNext()) {
	//// PermissionInfo perm = new PermissionInfo(list.next().getAuthority());
	//// this.listPerm.add(perm);
	//// }
	// }

	// Class RequestInfo start
	public static class RequestInfo {
		private String url;
		private String method;

		public RequestInfo(String url, String method) {
			super();
			this.url = url;
			this.method = method;
		}

		public RequestInfo() {
			super();
		}
		
		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}
		
	}
	// Class RequestInfo end

	@Override
	public String toString() {
		try {
			return convertObjectToJsonLog(this);
		} catch (Exception e) {
			log.info("AuthenticationRequestInfo: Error:" + e.toString(), e);
			return "AuthenticationRequestInfo: Error:" + e.toString();
		}
	}

	public boolean printLog(String permission) {
		log.info("AuthenticationRequestInfo.printLog: " + AuthenticationRequestInfo.getInstance().getRequestInfo(permission));
		return true;
	}

	public String getRequestInfo(String permission) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		// final OAuth2AuthenticationDetails details =
		// (OAuth2AuthenticationDetails) auth.getDetails();
		// this.accessToken = details.getTokenValue();
		this.clientId = ((OAuth2Authentication) auth).getOAuth2Request().getClientId();
		this.userName = auth.getName();

		long timeMillis = System.currentTimeMillis();
		long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
		this.dateTimeRequest = timeSeconds;

		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		this.requestInfo = new RequestInfo(url, method);

		List<String> listPerm = new ArrayList<>();
		Iterator<GrantedAuthority> listAuth = ((OAuth2Authentication) auth).getAuthorities().iterator();
		while (listAuth.hasNext()) {
			String perm = listAuth.next().getAuthority();
			listPerm.add(perm);
		}
		this.status = listPerm.contains(permission) ? "SUCCESS" : "ACCESS DENIED";
		return this.toString();
	}

	public <T> String convertObjectToJsonLog(T object) {
		Gson builder = new GsonBuilder().registerTypeAdapter(Date.class, new CustomDateJsonSerializer()).create();
		return builder.toJson(object);
	}

}
