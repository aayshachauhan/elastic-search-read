package com.zshop.sso.user.elastic.read.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonSyntaxException;
import com.zshop.commons.exception.business.BusinessException;
import com.zshop.helper.utils.GsonUtils;
import com.zshop.helper.utils.StatusCodeEnum;
import com.zshop.sso.user.elastic.read.api.request.UserReportRequest;
import com.zshop.sso.user.elastic.read.api.response.UserReportInfo;
import com.zshop.sso.user.elastic.read.api.response.UserReportResponse;
import com.zshop.sso.user.elastic.read.dao.UserInfoReadDao;
import com.zshop.sso.user.elastic.read.service.UserReportReadService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserReportReadServiceImpl implements UserReportReadService {

	@Autowired
	UserInfoReadDao userInfoReadDao;

	@Override
	public UserReportResponse getUserDataFromElk(UserReportRequest request)
			throws IOException, BusinessException, ParseException {
		SearchHits searchHits = userInfoReadDao.fetchDataFromElastic(request);
		long totalHits = searchHits.getTotalHits().value; // Get the total hits count
		log.info("Total hits fetched from elk {}", totalHits);

		List<UserReportInfo> userInfoList = new ArrayList<>();

		if (ObjectUtils.isNotEmpty(request.getClientId())) {

			if (request.getFromDate() == null || request.getToDate() == null
	                || request.getFromDate().compareTo(request.getToDate()) <= 0) {

			
				for (SearchHit hit : searchHits) {

					UserReportInfo userReportInfo = GsonUtils.registerGsonBuilder().fromJson(hit.getSourceAsString(),
							UserReportInfo.class);
					userInfoList.add(userReportInfo);
				}
			} else {
				throw new BusinessException(StatusCodeEnum.BAD_CREDENTIALS.getCode(), "Please provide correct date",
						userInfoList);
			}
		} else {
			throw new BusinessException(StatusCodeEnum.BAD_CREDENTIALS.getCode(), "Please provide clientId",
					userInfoList);
		}

		return UserReportResponse.builder().totalHits(totalHits).userInfoList(userInfoList).build();

	}

}
