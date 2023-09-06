package com.zshop.sso.user.elastic.read.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zshop.commons.exception.business.BusinessException;
import com.zshop.commons.exception.dao.DaoException;
import com.zshop.helper.utils.BaseResponse;
import com.zshop.helper.utils.BaseResponseBuilder;
import com.zshop.helper.utils.StatusCodeEnum;
import com.zshop.sso.user.elastic.read.api.dto.TextGeneratedImagesInfo;
import com.zshop.sso.user.elastic.read.api.request.TextImageSearchRequest;
import com.zshop.sso.user.elastic.read.service.TextImageReadService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TextImageReadController {

    @Autowired
    TextImageReadService textImageReadService;

    @PostMapping("/v2/texttoimage/read/search")
    @CrossOrigin
    public ResponseEntity<BaseResponse> userInfoSearch(@Valid @NotNull @RequestBody TextImageSearchRequest request)
            throws BusinessException, DaoException, IOException,ParseException {
        log.info("In TextImageReadController, searching data for text generated images request : {}",request);	

        List<TextGeneratedImagesInfo> response = textImageReadService.getImages(request);

        BaseResponse baseResponse = new BaseResponseBuilder().setBaseResponseWithStatusAndCodeAndData(
                HttpStatus.OK.name(), StatusCodeEnum.SUCCESS_CODE.getCode(), response);
        return new ResponseEntity<>(baseResponse,
                HttpStatus.valueOf(baseResponse.getStatus()));
    }


}
