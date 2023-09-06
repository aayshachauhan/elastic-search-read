package com.zee.sso.user.elastic.ingest.service.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zee.sso.user.elastic.ingest.api.request.TextGeneratedImagesInfo;
import com.zee.sso.user.elastic.ingest.service.TextToImageElasticIngestService;
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
public class TextImageElasticController {

	@Autowired
	private TextToImageElasticIngestService textToImageElasticIngestService;

	@ApiOperation(value = "Api to ingest text to image data to elastic.")
	@PostMapping("/v2/texttoimage/ingest")
	public ResponseEntity<BaseResponse> saveTextImage(@RequestBody TextGeneratedImagesInfo request)
			throws BusinessException, IOException, DaoException, ServiceException {

		log.info("saveTextImage :: {}", request);
		textToImageElasticIngestService.ingestTextImageInfo(request);
		BaseResponse buildSellerDetailsResponse = new BaseResponseBuilder()
				.setBaseResponseWithStatusAndCode(HttpStatus.OK.name(), StatusCodeEnum.SUCCESS_CODE.getCode());
		return new ResponseEntity<>(buildSellerDetailsResponse,
				HttpStatus.valueOf(buildSellerDetailsResponse.getStatus()));
	}

}
