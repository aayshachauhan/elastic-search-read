package com.zee.sso.user.elastic.ingest.service.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zee.sso.user.elastic.ingest.api.request.SsoIngestRequest;
import com.zee.sso.user.elastic.ingest.service.SsoIngestElasticService;
import com.zee.sso.user.elastic.ingest.service.entity.UserBasicInfo;
import com.zshop.commons.exception.business.BusinessException;
import com.zshop.commons.exception.dao.DaoException;
import com.zshop.commons.exception.server.ServiceException;
import com.zshop.helper.utils.BaseResponse;
import com.zshop.helper.utils.BaseResponseBuilder;
import com.zshop.helper.utils.StatusCodeEnum;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SsoElasticController {

	@Autowired
	private SsoIngestElasticService ssoIngestElasticService;

	@ApiOperation(value = "Api to ingest SSO.")
	@PostMapping("/v2/sso/userinfo/ingest")
	public ResponseEntity<BaseResponse> saveSSO(@RequestBody SsoIngestRequest request)
			throws BusinessException, IOException, DaoException, ServiceException {

		log.info("saveSSO :: {}", request);
		ssoIngestElasticService.ingestSSO(request);
		BaseResponse buildSellerDetailsResponse = new BaseResponseBuilder()
				.setBaseResponseWithStatusAndCode(HttpStatus.OK.name(), StatusCodeEnum.SUCCESS_CODE.getCode());
		return new ResponseEntity<>(buildSellerDetailsResponse,
				HttpStatus.valueOf(buildSellerDetailsResponse.getStatus()));
	}

	@ApiOperation(value = "Api to sync user info to elastic.")
	@PostMapping("/v2/sso/userinfo/sync")
	public ResponseEntity<BaseResponse> syncUserInfo(@RequestBody List<UserBasicInfo> userBasicInfoDtos)
			throws BusinessException, IOException, DaoException, ServiceException {

		log.info("sync request :: {}", userBasicInfoDtos.size());
		ssoIngestElasticService.syncUserInfo(userBasicInfoDtos);
		BaseResponse buildSellerDetailsResponse = new BaseResponseBuilder()
				.setBaseResponseWithStatusAndCode(HttpStatus.OK.name(), StatusCodeEnum.SUCCESS_CODE.getCode());
		return new ResponseEntity<>(buildSellerDetailsResponse,
				HttpStatus.valueOf(buildSellerDetailsResponse.getStatus()));
	}
}
