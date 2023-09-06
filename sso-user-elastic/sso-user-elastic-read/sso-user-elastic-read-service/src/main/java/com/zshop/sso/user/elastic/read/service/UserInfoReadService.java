package com.zshop.sso.user.elastic.read.service;

import com.zshop.commons.exception.business.BusinessException;
import com.zshop.sso.user.elastic.read.api.request.UserSearchRequest;
import com.zshop.sso.user.elastic.read.api.response.UserBasicInfo;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface UserInfoReadService {

    List<UserBasicInfo> getUserProfileDataFromElk(UserSearchRequest request) throws IOException, BusinessException, ParseException;

}
