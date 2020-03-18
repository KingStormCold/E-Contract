package vn.easycredit.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.google.common.collect.ImmutableList;

import lombok.extern.slf4j.Slf4j;
import vn.easycredit.constant.Constant;
import vn.easycredit.constant.NormalError;
//import vn.easycredit.domain.AuthenticationRequestInfo;
import vn.easycredit.domain.ErrorInfo;
import vn.easycredit.domain.ErrorInfo.InvalidParameter;
//import vn.easycredit.domain.cashdisbursement.DisbursementInfoResponse;
import vn.easycredit.domain.ErrorResponse;
//import vn.easycredit.domain.ExceptionHandlerMonitoring;
import vn.easycredit.domain.Utilities;
import vn.easycredit.exception.NotFoundException;
import vn.easycredit.exception.RequestException;
//import vn.easycredit.repository.ExceptionHandlerMonitoringRepository;
import vn.easycredit.response.ErrorExceptionMessage;

/**
 * Global exception handler annotation registration for API
 * 
 * @author HienNT
 */
@Slf4j
@RestControllerAdvice
@Transactional
public class GlobalExceptionHandler {

//	@Autowired
//	ExceptionHandlerMonitoringRepository exceptionHandlerMonitoringRepository;
	
	@Autowired
	HttpServletRequest request;


	/**
	 * HienNT handle HttpMessageNotReadableException, include of jackson mapping
	 * request body exception.
	 * 
	 * TODO HttpMessageNotWritableException
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(RequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorExceptionMessage> handleException(RequestException e, WebRequest webRequest) {
		log.error("Request exception", e);
		Throwable cause = e.getCause() == null ? e : e.getCause();
		String exceptionMessage = e.getMessage() == null ? cause.toString() : e.getMessage();
		String oginalException1 = e.getMessage() == null ? cause.toString() : e.getMessage();
		
		String oginalException = e.getErrCode() + " " + oginalException1;

		/*Object fullInfoResponse = Utilities.convertJSONStringToObject(exceptionMessage, DisbursementInfoResponse.class);
		if (fullInfoResponse != null && fullInfoResponse instanceof DisbursementInfoResponse) {
			exceptionMessage = ((DisbursementInfoResponse) fullInfoResponse).getBody().getResponseMessage().toString();
			
			String responeMessage = ((DisbursementInfoResponse) fullInfoResponse).getBody().getResponseMessage()
					.toString();
			String responeCode = ((DisbursementInfoResponse) fullInfoResponse).getBody().getResponseCode()
					.toString();
			exceptionMessage = String.format("%s %s", responeCode, responeMessage);
		}
*/
		String uri = StringUtils.replace(webRequest.getDescription(false), "uri=", Constant.EMPTY_VALUE);
		String inflowApi = Utilities.getInflowApiByUri(uri);
		
		//Save to Exception Handle Monitoring table to serve for monitoring 
		/*ExceptionHandlerMonitoring exceptionHandlerMonitoring = new ExceptionHandlerMonitoring	(
				Utilities.convertObjectToJsonLog(e.getRequest()).toString(), exceptionMessage,
				inflowApi, uri, false, HttpStatus.BAD_REQUEST.value(), new Date(), this.getIp(), AuthenticationRequestInfo.getInstance().getUserName());
		exceptionHandlerMonitoringRepository.save(exceptionHandlerMonitoring);*/

		//Set Reponse Dto
		/*ErrorExceptionMessage errorObj = new ErrorExceptionMessage(new Date(), HttpStatus.BAD_REQUEST.value(),
				oginalException, HttpStatus.BAD_REQUEST.getReasonPhrase(), uri);*/
		ErrorExceptionMessage errorObj = new ErrorExceptionMessage(new Date(), HttpStatus.BAD_REQUEST.value(),
				oginalException, e.getErrCode(), uri);
		return new ResponseEntity<>(errorObj, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorExceptionMessage> handleException(NotFoundException e, WebRequest webRequest) {
		
		log.error("NotFoundException", e);
		Throwable cause = e.getCause() == null ? e : e.getCause();
		String exceptionMessage = e.getMessage() == null ? cause.toString() : e.getMessage();

		String uri = StringUtils.replace(webRequest.getDescription(false), "uri=", Constant.EMPTY_VALUE);
		String inflowApi = Utilities.getInflowApiByUri(uri);
		
		//Save to Exception Handle Monitoring table to serve for monitoring 
		/*ExceptionHandlerMonitoring exceptionHandlerMonitoring = new ExceptionHandlerMonitoring(
				Utilities.convertObjectToJsonLog(e.getRequest()).toString(), exceptionMessage,
				inflowApi, uri, false, HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), this.getIp(), AuthenticationRequestInfo.getInstance().getUserName());
		exceptionHandlerMonitoringRepository.save(exceptionHandlerMonitoring);*/

		//Set Reponse Dto
		ErrorExceptionMessage errorObj = new ErrorExceptionMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), uri);
		return new ResponseEntity<>(errorObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorExceptionMessage> handleException(RuntimeException e, WebRequest webRequest) {
		log.error("Runtime Exception exception", e);
		Throwable cause = e.getCause() == null ? e : e.getCause();
		String exceptionMessage = e.getMessage() == null ? cause.toString() : e.getMessage();
		
		String uri = StringUtils.replace(webRequest.getDescription(false), "uri=", Constant.EMPTY_VALUE);
		String inflowApi = Utilities.getInflowApiByUri(uri);
		
		//Save to Exception Handle Monitoring table to serve for monitoring 
//		ExceptionHandlerMonitoring exceptionHandlerMonitoring = new ExceptionHandlerMonitoring(exceptionMessage,
//				inflowApi, uri, false, HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), this.getIp(), AuthenticationRequestInfo.getInstance().getUserName());
//		exceptionHandlerMonitoringRepository.save(exceptionHandlerMonitoring);
		
		//Set Reponse Dto
		ErrorExceptionMessage errorObj = new ErrorExceptionMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), uri);

		return new ResponseEntity<>(errorObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorExceptionMessage> handleException(MissingServletRequestParameterException e,
			WebRequest webRequest) {
		log.error("MissingServletRequestParameterException", e);
		String uri = StringUtils.replace(webRequest.getDescription(false), "uri=", Constant.EMPTY_VALUE);
		String inflowApi = Utilities.getInflowApiByUri(uri);
		
		//Save to Exception Handle Monitoring table to serve for monitoring 
//		ExceptionHandlerMonitoring exceptionHandlerMonitoring = new ExceptionHandlerMonitoring(e.getMessage(),
//				inflowApi, uri, false, HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), this.getIp(), AuthenticationRequestInfo.getInstance().getUserName());
		
		//Set reponse Dto
		ErrorExceptionMessage errorObj = new ErrorExceptionMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), uri);
		
//		exceptionHandlerMonitoringRepository.save(exceptionHandlerMonitoring);

		return new ResponseEntity<>(errorObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorExceptionMessage> handleException(MethodArgumentNotValidException e,
			WebRequest webRequest) {
		log.error("Request parameter validation failed", e);
		String uri = StringUtils.replace(webRequest.getDescription(false), "uri=", Constant.EMPTY_VALUE);
		String inflowApi = Utilities.getInflowApiByUri(uri);

		ImmutableList.Builder<InvalidParameter> errors = ImmutableList.builder();
		e.getBindingResult().getFieldErrors()
				.forEach(fe -> errors.add(new InvalidParameter(fe.getField(), fe.getDefaultMessage())));
		e.getBindingResult().getGlobalErrors().stream()
				.forEach(ge -> errors.add(new InvalidParameter(ge.getObjectName(), ge.getDefaultMessage())));

		
		//Save to Exception Handle Monitoring table to serve for monitoring 
//		ExceptionHandlerMonitoring exceptionHandlerMonitoring = new ExceptionHandlerMonitoring(e.getMessage(),
//				inflowApi, uri, false, HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), this.getIp(), AuthenticationRequestInfo.getInstance().getUserName());
//		exceptionHandlerMonitoringRepository.save(exceptionHandlerMonitoring);
		
		//Set reponse Dto
		ErrorExceptionMessage errorObj = new ErrorExceptionMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), uri);

		return new ResponseEntity<>(errorObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorExceptionMessage> handleException(HttpMessageNotReadableException e,
			WebRequest webRequest) {
		log.error("HttpMessageNotReadableException", e);

		Throwable cause = e.getCause() == null ? e : e.getCause();
		String exceptionMessage = e.getMessage() == null ? cause.getCause().toString() : e.getMessage();
		
		String uri = StringUtils.replace(webRequest.getDescription(false), "uri=", Constant.EMPTY_VALUE);
		String inflowApi = Utilities.getInflowApiByUri(uri);

		//Save to Exception Handle Monitoring table to serve for monitoring 
//		ExceptionHandlerMonitoring exceptionHandlerMonitoring = new ExceptionHandlerMonitoring(exceptionMessage,
//				inflowApi, uri, false, HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), this.getIp(), AuthenticationRequestInfo.getInstance().getUserName());
//		exceptionHandlerMonitoringRepository.save(exceptionHandlerMonitoring);
		
		//Set Reponse Dto
		ErrorExceptionMessage errorObj = new ErrorExceptionMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), uri);

		return new ResponseEntity<>(errorObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorExceptionMessage> handleException(Exception e,
			WebRequest webRequest) {
		log.error("Exception", e);

		Throwable cause = e.getCause() == null ? e : e.getCause();
//		String exceptionMessage = e.getMessage() == null ? cause.getCause().toString() : e.getMessage();
		
		String uri = StringUtils.replace(webRequest.getDescription(false), "uri=", Constant.EMPTY_VALUE);
//		String inflowApi = Utilities.getInflowApiByUri(uri);
		//Save to Exception Handle Monitoring table to serve for monitoring 
//		ExceptionHandlerMonitoring exceptionHandlerMonitoring = new ExceptionHandlerMonitoring(exceptionMessage,
//				inflowApi, uri, false, HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), this.getIp(), AuthenticationRequestInfo.getInstance().getUserName());
		
		//Set reponse Dto
		ErrorExceptionMessage errorObj = new ErrorExceptionMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), uri);
//		
//		exceptionHandlerMonitoringRepository.save(exceptionHandlerMonitoring);

		return new ResponseEntity<>(errorObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Create DTO Error Response
	 * 
	 * @param errorInfo
	 * @param request
	 * @return
	 */
	protected ErrorResponse createErrorResponse(HttpStatus status, NormalError normalError, String detailMessage,
			ErrorInfo.Type errorType) {
		return createErrorResponse(status, normalError, detailMessage, errorType, Optional.empty());
	}

	/**
	 * Fully parameters creating DTO Error Response
	 * 
	 * @param error
	 * @param detailMessage
	 * @param clazz
	 * @param invalidParameters
	 * @return
	 */
	protected ErrorResponse createErrorResponse(HttpStatus status, NormalError normalError, String detailMessage,
			ErrorInfo.Type errorType, Optional<List<InvalidParameter>> invalidParameters) {
		ErrorInfo errorInfo = new ErrorInfo(normalError.getErrorCode(), normalError.getErrorMessage(), errorType,
				detailMessage, invalidParameters);
		return new ErrorResponse(status.value(), errorInfo);
	}
	
	public String getIp() {
		String ip;
		ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}