//package vn.easycredit.domain;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Type;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import vn.easycredit.constant.Constant;
//
//
//@Entity
//@Table(name = "exception_handler_monitoring")
//public class ExceptionHandlerMonitoring implements Serializable{
//
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
//	@JsonProperty("id")
//	@Column(name = "id")
//	private String id;
//	
//	@Type(type = "text")
//	@Column(name = "exception_request")
//	@JsonProperty("exception_request")
//	private String exceptionRequest;
//	
//	@Type(type = "text")
//	@Column(name = "exception_response")
//	@JsonProperty("exception_response")
//	private String exceptionResponse;
//	
//	@Column(name = "path")
//	@JsonProperty("path")
//	private String path;
//	
//	@Column(name = "is_sent")
//	@JsonProperty("is_sent")
//	private boolean isSent;	
//	
//	@Column(name = "service_name")
//	@JsonProperty("service_name")
//	private String serviceName;
//	
//	@Column(name = "service_id")
//	@JsonProperty("service_id")
//	private String serviceId;
//	
//	@Column(name = "inflow_api")
//	@JsonProperty("inflow_api")
//	private String inflowApi;
//	
//	@Column(name = "http_status")
//	@JsonProperty("http_status")
//	private Integer httpStatus;
//	
//	@Column(name = "created_date")
//	@JsonProperty("created_date")
//	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone = Utilities.MY_TIME_ZONE)
//	private Date createdDate;
//	
//	@Column(name = "sent_date")
//	@JsonProperty("sent_date")
//	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone = Utilities.MY_TIME_ZONE)
//	private Date sentDate;
//	
//	@Column(name = "from_ip")
//	@JsonProperty("from_ip")
//	private String fromIp;
//	
//	@Column(name = "remote_user")
//	@JsonProperty("remote_user")
//	private String remoteUser;
//	
//	public ExceptionHandlerMonitoring() {
//		super();
//	}
//	
//	public ExceptionHandlerMonitoring(String exceptionRequest, String exceptionResponse, String inflowApi, String path,
//			boolean isSent, Integer httpStatus, Date createdDate, String fromIp, String remoteUser) {
//		super();
//		this.exceptionRequest = exceptionRequest;
//		this.exceptionResponse = exceptionResponse;
//		this.inflowApi = inflowApi;
//		this.path = path;
//		this.isSent = isSent;
//		this.serviceName = Constant.SERVICE_NAME;
//		this.serviceId = Constant.SERVICE_ID;
//		this.httpStatus = httpStatus;
//		this.createdDate = createdDate;
//		this.fromIp = fromIp;
//		this.remoteUser = remoteUser;
//	}
//	
//	
//	public ExceptionHandlerMonitoring(String exceptionResponse, String inflowApi, String path,
//			boolean isSent, Integer httpStatus, Date createdDate, String fromIp, String remoteUser) {
//		super();
//		this.exceptionResponse = exceptionResponse;
//		this.inflowApi = inflowApi;
//		this.path = path;
//		this.isSent = isSent;
//		this.serviceName = Constant.SERVICE_NAME;
//		this.serviceId = Constant.SERVICE_ID;
//		this.httpStatus = httpStatus;
//		this.createdDate = createdDate;
//		this.fromIp = fromIp;
//		this.remoteUser = remoteUser;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getExceptionRequest() {
//		return exceptionRequest;
//	}
//
//	public void setExceptionRequest(String exceptionRequest) {
//		this.exceptionRequest = exceptionRequest;
//	}
//
//	public String getExceptionResponse() {
//		return exceptionResponse;
//	}
//
//	public void setExceptionResponse(String exceptionResponse) {
//		this.exceptionResponse = exceptionResponse;
//	}
//
//	public String getPath() {
//		return path;
//	}
//
//	public void setPath(String path) {
//		this.path = path;
//	}
//
//	public boolean getIsSent() {
//		return isSent;
//	}
//
//	public void setIsSent(boolean isSent) {
//		this.isSent = isSent;
//	}
//
//	public String getServiceName() {
//		return serviceName;
//	}
//
//	public void setServiceName(String serviceName) {
//		this.serviceName = serviceName;
//	}
//
//	public Integer getHttpStatus() {
//		return httpStatus;
//	}
//
//	public void setHttpStatus(Integer httpStatus) {
//		this.httpStatus = httpStatus;
//	}
//
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	public Date getSentDate() {
//		return sentDate;
//	}
//
//	public void setSentDate(Date sentDate) {
//		this.sentDate = sentDate;
//	}
//
//	public String getServiceId() {
//		return serviceId;
//	}
//
//	public void setServiceId(String serviceId) {
//		this.serviceId = serviceId;
//	}
//
//	public String getFromIp() {
//		return fromIp;
//	}
//
//	public void setFromIp(String fromIp) {
//		this.fromIp = fromIp;
//	}
//
//	public String getRemoteUser() {
//		return remoteUser;
//	}
//
//	public void setRemoteUser(String remoteUser) {
//		this.remoteUser = remoteUser;
//	}
//	
//	public String getInflowApi() {
//		return inflowApi;
//	}
//
//	public void setInflowApi(String inflowApi) {
//		this.inflowApi = inflowApi;
//	}
//}
