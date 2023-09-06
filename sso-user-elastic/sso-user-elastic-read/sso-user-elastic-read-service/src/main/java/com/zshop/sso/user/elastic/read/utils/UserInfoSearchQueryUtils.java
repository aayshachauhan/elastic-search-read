package com.zshop.sso.user.elastic.read.utils;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Component;

import com.zshop.sso.user.elastic.read.api.request.UserReportRequest;
import com.zshop.sso.user.elastic.read.api.request.UserSearchRequest;
import com.zshop.sso.user.elastic.read.constants.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserInfoSearchQueryUtils {

	public BoolQueryBuilder userProfileSearchQuery(UserSearchRequest request) {
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

		if (request != null && !StringUtils.isEmpty(request.getUserId())) {
			boolQueryBuilder.should(QueryBuilders.multiMatchQuery(request.getUserId())
					.field(Constants.UserInfoConstants.USER_LOGIN_ID, 3).field(Constants.UserInfoConstants.EMAIL_ID, 2)
					.field(Constants.UserInfoConstants.MOBILE_NO).type(MultiMatchQueryBuilder.Type.PHRASE));
		}

		if (!ObjectUtils.isEmpty(request) && !StringUtils.isEmpty(request.getClientSpecificUserId())) {
			boolQueryBuilder.must(QueryBuilders.termQuery(Constants.UserInfoConstants.CLIENT_SPECIFIC_USER_ID,
					request.getClientSpecificUserId()));
		}

		if (!ObjectUtils.isEmpty(request) && !StringUtils.isEmpty(request.getSsoDbUserId())) {
			boolQueryBuilder
					.must(QueryBuilders.termQuery(Constants.UserInfoConstants.USER_ID, request.getSsoDbUserId()));
		}

		if (!ObjectUtils.isEmpty(request) && !StringUtils.isEmpty(request.getOwnerUserId())) {
			boolQueryBuilder
					.must(QueryBuilders.termQuery(Constants.UserInfoConstants.OWNER_USER_ID, request.getOwnerUserId()));
		}

		if (!ObjectUtils.isEmpty(request) && request.getFromDate() != null) {
			boolQueryBuilder
					.must(QueryBuilders.rangeQuery(Constants.UserInfoConstants.CREATED_DATE).gte(request.getFromDate())
							.lte(request.getToDate()))
					.must(QueryBuilders.boolQuery()
							.must(QueryBuilders.existsQuery(Constants.UserInfoConstants.OWNER_USER_ID)));
		}
		return boolQueryBuilder;
	}

	public BoolQueryBuilder userReportSearchQuery(UserReportRequest request) {
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

		if (!ObjectUtils.isEmpty(request) && !StringUtils.isEmpty(request.getUserId())) {
			boolQueryBuilder.must(QueryBuilders.termQuery(Constants.UserInfoConstants.USER_ID, request.getUserId()));
		}

		if (!ObjectUtils.isEmpty(request) && !StringUtils.isEmpty(request.getLoginId())) {
			boolQueryBuilder
					.must(QueryBuilders.termQuery(Constants.UserInfoConstants.USER_LOGIN_ID, request.getLoginId()));
		}

		if (!ObjectUtils.isEmpty(request) && !StringUtils.isEmpty(request.getClientId())) {
			boolQueryBuilder
					.must(QueryBuilders.termQuery(Constants.UserInfoConstants.CLIENT_ID, request.getClientId()));
		}

		if (!ObjectUtils.isEmpty(request) && !StringUtils.isEmpty(request.getDomainId())) {
			boolQueryBuilder
					.must(QueryBuilders.termQuery(Constants.UserInfoConstants.DOMAIN_ID, request.getDomainId()));
		}

		if (!ObjectUtils.isEmpty(request) && !StringUtils.isEmpty(request.getVisitorId())) {
			boolQueryBuilder
					.must(QueryBuilders.termQuery(Constants.UserInfoConstants.VISITOR_ID, request.getVisitorId()));
		}

		if (!ObjectUtils.isEmpty(request) && !StringUtils.isEmpty(request.getGaid())) {
			boolQueryBuilder.must(QueryBuilders.termQuery(Constants.UserInfoConstants.GAID, request.getGaid()));
		}
		if (!ObjectUtils.isEmpty(request) && request.getFromDate() != null) {
			boolQueryBuilder
					.must(QueryBuilders.rangeQuery(Constants.UserInfoConstants.CREATED_DATE).gte(request.getFromDate())
							.lte(request.getToDate()))
					.must(QueryBuilders.boolQuery()
							.must(QueryBuilders.existsQuery(Constants.UserInfoConstants.CLIENT_ID)));
		}

		log.info("Total hits fetched from elk {}", boolQueryBuilder);
		return boolQueryBuilder;
	}

}
