package com.zshop.sso.user.elastic.read.service;

import java.io.IOException;
import java.text.ParseException;

import com.zshop.commons.exception.business.BusinessException;
import com.zshop.sso.user.elastic.read.api.request.UserReportRequest;
import com.zshop.sso.user.elastic.read.api.response.UserReportResponse;

public interface UserReportReadService {
	UserReportResponse getUserDataFromElk(UserReportRequest request) throws IOException, BusinessException, ParseException;

}
