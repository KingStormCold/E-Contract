package vn.easycredit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import vn.easycredit.constant.CommonError;
import vn.easycredit.constant.HttpStatusCode;
import vn.easycredit.internalapi.DocApi;
import vn.easycredit.internalapi.request.DocApiRequest;
import vn.easycredit.internalapi.response.DocApiResponse;
import vn.easycredit.request.LoginRequest;
import vn.easycredit.request.RedirectPage;
import vn.easycredit.response.RedirectResponse;

@Service
public class ESignWebService {
	
	@Autowired
	private DocApi docApi;

	public RedirectResponse login(final LoginRequest request) {
		DocApiRequest docApiRequest = DocApiRequest.of(request);
		DocApiResponse response = docApi.getInfoDoc(docApiRequest);
		if (StringUtils.isEmpty(response)) {
			return new RedirectResponse(HttpStatusCode._200.getCode(), HttpStatusCode._200.getValue(), CommonError.ERROR_NOT_FOUND_CONTRACT.getValue(), RedirectPage.LOGIN.getCode());
		}
		return new RedirectResponse(HttpStatusCode._200.getCode(), HttpStatusCode._200.getValue(), RedirectPage.QUESTION_LIST.getValue(), RedirectPage.QUESTION_LIST.getCode());
	}
}
