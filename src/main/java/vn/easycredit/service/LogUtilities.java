package vn.easycredit.service;

import java.net.SocketException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;
import vn.easycredit.constant.Constant;
import vn.easycredit.domain.CustomDateJsonSerializer;
import vn.easycredit.domain.LogsRequest;

/**
 * 
 * @author HienNT
 *
 */

@Slf4j
@Service
public class LogUtilities {

	@Value("${queue-log}")
	public String queueLog;
	
//	@Value("${queue-log-db}")
//	public String queueLogPortal;

	private RabbitTemplate rabbitTemplate;

	static String uuidInfo;

	@Autowired
	private HttpServletRequest request;

	public LogUtilities(RabbitTemplate rabbitTemplate, HttpServletRequest request) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		this.request = request;
	}

	public RabbitTemplate getRabbitTemplate() {
		return rabbitTemplate;
	}

	/**
	 * convert Request object to string Json(for write Log)
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public <T> String convertObjectToJsonLog(T object) {
		Gson builder = new GsonBuilder().registerTypeAdapter(Date.class, new CustomDateJsonSerializer())
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		return builder.toJson(object);
	}

	/**
	 * prepare param for send message logs request to rabbitMQ
	 * 
	 * @param logsRequest
	 * @throws SocketException 
	 * @throws Exception
	 */
	public void insertLog(String uuid, String logInfo, String inflow, String status, String logStatus, String logError, String response) throws SocketException{
		Map<String, String> requestHeader;
		String body = logInfo;
		String fromIp;
		String toIp;
		if (inflow.equals(Constant.DISBURSEMENT_CHECK_STATUS_VIETTELPAY_INFLOW) || inflow.equals(Constant.DISBURSEMENT_FUND_TRANSFER_RESULT_INFLOW)){
			requestHeader = null;
			fromIp = null;
			toIp = null;
		} else {
			requestHeader = getHeaders();
			fromIp = getIp();
			toIp = getURL();
		}
		
		LogsRequest logsInfoRequest = new LogsRequest(uuid, inflow, requestHeader, body, fromIp, toIp, status, logError, logStatus, response);

		Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy hh:mm:ss").create();
		String jsonIntoString = gson.toJson(logsInfoRequest);

		// send message
		run(jsonIntoString);
	}
	
	
	/**
	 * prepare param for send message logs request to rabbitMQ
	 * 
	 * @param logsRequest
	 * @throws SocketException 
	 * @throws Exception
	 */
		
//	public DisbursementRequestInfo insertLogPortal(String uuid, String requestID, String createBy, String inflow, String requestBody, 
//			String contractNumber, String amount, String status, String processing, String logError, String reponseBody,
//			String partnerCode, String identityCard, String customerName, String responseCode, String responseMessage, String channelDisburse, String logStatus,
//			String accountNumber, String bankCode, String branchCode, String description, String imxPaymentRef, String requestTime, String requestIdSAC,
//			String respcode, String transactionId) throws SocketException{
//		
//		String fromIp = getIp();
//		String toIp = getURL();
//		
//		DisbursementRequestInfo disburseInfo = new DisbursementRequestInfo();
//    	disburseInfo.setId(uuid);
//    	disburseInfo.setRequestID(requestID);
//    	disburseInfo.setFromIp(fromIp);
//    	disburseInfo.setCreatedBy(createBy);
//    	disburseInfo.setInflowApi(inflow);
//    	disburseInfo.setRequestBody(requestBody);
//    	disburseInfo.setContractNumber(contractNumber);
//    	disburseInfo.setAmount(amount);
//    	disburseInfo.setToIp(toIp);
//    	disburseInfo.setStatus(status);
//    	disburseInfo.setLogError(logError);
//    	disburseInfo.setResponseBody(reponseBody);
//    	disburseInfo.setCreatedOn(new Date());
//    	disburseInfo.setPartnerCode(partnerCode);
//    	disburseInfo.setIdentityCard(identityCard);
//    	disburseInfo.setCustomerName(customerName);
//    	disburseInfo.setResponseCode(responseCode);
//    	disburseInfo.setResponseMessage(responseMessage);
//    	disburseInfo.setChannelDisburse(channelDisburse);
//    	disburseInfo.setRespCode(respcode);
//    	disburseInfo.setTransactionId(transactionId);
//    	disburseInfo.setAccountNumber(accountNumber);
//    	disburseInfo.setBankCode(bankCode);
//    	disburseInfo.setBranchCode(branchCode);
//    	disburseInfo.setDescription(description);
//    	disburseInfo.setImxPaymentRef(imxPaymentRef);
//    	disburseInfo.setRequestDateTime(requestTime);
//    	disburseInfo.setRequestIdSac(requestIdSAC);
//    	
//		return disburseInfo;
//	}

	/**
	 * send message logs request to rabbitMQ
	 * 
	 * @param logsRequest
	 * @throws Exception
	 */
	public void run(String logsInfoRequest) {
		try {
			rabbitTemplate.convertAndSend(queueLog, logsInfoRequest);
		} catch (Exception e) {
			log.error("Rabbit MQ write log error", e);
		}
	}

	/*
	 * get all param from request header
	 */
	private Map<String, String> getHeaders() {
		Map<String, String> map = new HashMap<>();
		@SuppressWarnings("rawtypes")
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}

	/*
	 * get IP
	 */
	private String getIp() throws SocketException {
		String ip;
		ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/*
	 * get URL
	 */
	private String getURL() {
		return request.getRequestURL().toString();
	}
}
	
	

