package com.zshop.sso.user.elastic.read.controller;

import com.zshop.commons.exception.business.BusinessException;
import com.zshop.commons.exception.dao.DaoException;
import com.zshop.helper.utils.BaseResponse;
import com.zshop.helper.utils.BaseResponseBuilder;
import com.zshop.helper.utils.StatusCodeEnum;
import com.zshop.sso.user.elastic.read.api.request.UserSearchRequest;
import com.zshop.sso.user.elastic.read.api.response.UserBasicInfo;
import com.zshop.sso.user.elastic.read.service.UserInfoReadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Slf4j
@RestController
public class UserInfoReadController {

    @Autowired
    UserInfoReadService userInfoReadService;

    @PostMapping("/v2/sso/userinfo/search")
    public ResponseEntity<BaseResponse> userInfoSearch(@Valid @NotNull @RequestBody UserSearchRequest request)
            throws BusinessException, DaoException, IOException,ParseException {
        log.info("In UserInfoReadController, searching data for user request : {}",request);

        List<UserBasicInfo> response = userInfoReadService.getUserProfileDataFromElk(request);
        log.info("Response: {}", response);

        BaseResponse baseResponse = new BaseResponseBuilder().setBaseResponseWithStatusAndCodeAndData(
                HttpStatus.OK.name(), StatusCodeEnum.SUCCESS_CODE.getCode(), response);
        return new ResponseEntity<>(baseResponse,
                HttpStatus.valueOf(baseResponse.getStatus()));
    }


}
