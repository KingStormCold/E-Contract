package vn.easycredit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import vn.easycredit.constant.HttpStatusCode;
import vn.easycredit.request.ConfirmOtpRequest;
import vn.easycredit.request.LoginRequest;
import vn.easycredit.request.NotReceiveOtpRequest;
import vn.easycredit.request.QuestionListRequest;
import vn.easycredit.request.ReSendOtpRequest;
import vn.easycredit.request.RedirectPage;
import vn.easycredit.request.ReviewContractRequest;
import vn.easycredit.request.SendMailRequest;
import vn.easycredit.response.RedirectResponse;
import vn.easycredit.service.ESignCloudService;
import vn.easycredit.service.ESignWebService;
import vn.easycredit.service.LogUtilities;

/**
 * Controller
 * 
 * @author HienNT
 */

@Slf4j
@RestController
public class ESigningController {
	
	@Autowired
	ESignCloudService esignCloudService;
	
	@Autowired
	private LogUtilities logUtilities;
	
	@Autowired
	private ESignWebService eSignWebService;
	
	// api test connection disbursement
	@RequestMapping(value = "/v1/ping", method = RequestMethod.GET)
	public String ping() {
		esignCloudService.customerRegisterEsigning();
		return "pong_deploy 8PM 25-02-2020";
	}
	
//	@ApiOperation(value = "Checking Disbursement Info Request From Bank", notes = "Checking Disbursement Info Request From Bank.")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = Constant.SUCCESS_MESSAGE, response = String.class),
//			@ApiResponse(code = 400, message = Constant.BADREQUEST_MESSAGE, response = ErrorResponse.class),
//			@ApiResponse(code = 500, message = Constant.INTERNALERROR_MESSAGE, response = ErrorResponse.class) })
//	@PreAuthorize("@authenticationRequestInfo.printLog('disbursement_info') AND #oauth2.hasScope('disbursement_info')")
//	@RequestMapping(value = "/v1/cash/checkContractInfo", method = RequestMethod.POST , consumes = MediaType.TEXT_PLAIN)
//	@Produces({"text/pain", "application/json"})
//	public String checkContractInfo(@Valid @RequestBody String req) throws Exception {
//		log.info("disbursement_check_contract_info: " +" Validate Check Contract info request....");
//		
//		try {
//			return disbursementService.handleCheckContractInfo(req);
//		} catch (RequestException e){
//			log.error("", e);
//			throw new RequestException(e.getErrCode(), e.getMessage());
//		} catch (Exception e){
//			log.error("", e);
//			throw new RequestException(InvalidError.BAD_REQUEST_EXCEPTION.getErrorCode(), InvalidError.INTERNAL_SERVER_ERROR.getErrorMessage());
//		}
//	}
	
	@PreAuthorize("#oauth2.hasScope('e-signing-web')")
	@PostMapping(value = "/v1/e-signing/login")
	public RedirectResponse login(@RequestBody final LoginRequest request) {
		String json = logUtilities.convertObjectToJsonLog(request);
		log.info("login..." + json);
		if (StringUtils.isEmpty(request.validate())) {
			return eSignWebService.login(request);
		}
		return request.validate();
	}
	
	@PreAuthorize("#oauth2.hasScope('e-signing-web')")
	@PostMapping(value = "/v1/e-signing/quest-list")
	public RedirectResponse questionList(@RequestBody final QuestionListRequest request) {
		String json = logUtilities.convertObjectToJsonLog(request);
		log.info("quest-list..." + json);
		if (StringUtils.isEmpty(request.validate())) {
			return new RedirectResponse(HttpStatusCode._200.getCode(), HttpStatusCode._200.getValue(), RedirectPage.SHOW_CONTRACT.getValue(), RedirectPage.SHOW_CONTRACT.getCode());
		}
		return request.validate();
	}
	
	@PreAuthorize("#oauth2.hasScope('e-signing-web')")
	@PostMapping(value = "/v1/e-signing/customer-register")
	public RedirectResponse customerRegister(@RequestBody final ReviewContractRequest request) {
		String json = logUtilities.convertObjectToJsonLog(request);
		log.info("review-contract..." + json);
		if (StringUtils.isEmpty(request.validate())) {
			return new RedirectResponse(HttpStatusCode._200.getCode(), HttpStatusCode._200.getValue(), RedirectPage.OTP.getValue(), RedirectPage.OTP.getCode());
		}
		return request.validate();
	}
	
	//xac nhan OTP
	@PreAuthorize("#oauth2.hasScope('e-signing-web')")
	@PostMapping(value = "/v1/e-signing/confirm-otp")
	public RedirectResponse confirmOtp (@RequestBody final ConfirmOtpRequest request) {
		String json = logUtilities.convertObjectToJsonLog(request);
		log.info("confirm-otp..." + json);
		if (StringUtils.isEmpty(request.validate())) {
			return new RedirectResponse(HttpStatusCode._200.getCode(), HttpStatusCode._200.getValue(), RedirectPage.SEND_MAIL.getValue(), RedirectPage.SEND_MAIL.getCode());
		}
		return request.validate();
	}
	
	//chua nhan dc OTP
	@PreAuthorize("#oauth2.hasScope('e-signing-web')")
	@PostMapping(value = "/v1/e-signing/not-receive-otp")
	public RedirectResponse notReceiveOtp(@RequestBody final NotReceiveOtpRequest request) {
		String json = logUtilities.convertObjectToJsonLog(request);
		log.info("not-receive-otp..." + json);
		if (StringUtils.isEmpty(request.validate())) {
			return new RedirectResponse(HttpStatusCode._200.getCode(), HttpStatusCode._200.getValue(), RedirectPage.OTP.getValue(), RedirectPage.OTP.getCode());
		}
		return request.validate();
	}
	
	//gui lai OTP
	@PreAuthorize("#oauth2.hasScope('e-signing-web')")
	@PostMapping(value = "/v1/e-signing/re-send-otp")
	public RedirectResponse resendOtp(@RequestBody final ReSendOtpRequest request) {
		String json = logUtilities.convertObjectToJsonLog(request);
		log.info("re-send-otp..." + json);
		if (StringUtils.isEmpty(request.validate())) {
			return new RedirectResponse(HttpStatusCode._200.getCode(), HttpStatusCode._200.getValue(), RedirectPage.OTP.getValue(), RedirectPage.OTP.getCode());
		}
		return request.validate();
	}
	
	//gui lai OTP
	@PreAuthorize("#oauth2.hasScope('e-signing-web')")
	@PostMapping(value = "/v1/e-signing/send-mail")
		public RedirectResponse sendMail(@RequestBody final SendMailRequest request) {
		String json = logUtilities.convertObjectToJsonLog(request);
		log.info("send-mail..." + json);
			if (StringUtils.isEmpty(request.validate())) {
				return new RedirectResponse(HttpStatusCode._200.getCode(), HttpStatusCode._200.getValue(), RedirectPage.LOGIN.getValue(), RedirectPage.LOGIN.getCode());
			}
			return request.validate();
		}
}
