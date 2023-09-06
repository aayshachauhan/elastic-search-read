package com.zshop.sso.user.elastic.read.dao.impl;

import java.io.IOException;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zshop.sso.user.elastic.read.api.request.TextImageSearchRequest;
import com.zshop.sso.user.elastic.read.constants.Constants;
import com.zshop.sso.user.elastic.read.dao.TextImageReadDao;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TextImageReadDaoImpl implements TextImageReadDao {

	@Autowired
	private RestHighLevelClient client;

	@Override
	public SearchHits fetchDataFromElk(TextImageSearchRequest request) throws IOException {
		BoolQueryBuilder boolQueryBuilder = imageSearchQuery(request);
		SearchRequest searchRequest = new SearchRequest().indices(Constants.Index.TEXT_TO_IMAGE)
				.source(new SearchSourceBuilder().query(boolQueryBuilder)
						.from((request.getPageNo() - 1) * request.getPageSize()).size(request.getPageSize())
						.sort(Constants.TextImageConstants.CREATED_DATE, SortOrder.DESC));
		return client.search(searchRequest, RequestOptions.DEFAULT).getHits();
	}

	private BoolQueryBuilder imageSearchQuery(TextImageSearchRequest request) {
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

		if (ObjectUtils.isNotEmpty(request) && request.getUserId() != null)
			boolQueryBuilder.must(QueryBuilders.termQuery(Constants.TextImageConstants.USERID, request.getUserId()));

		if (StringUtils.isNotEmpty(request.getQ()))
			boolQueryBuilder.must(QueryBuilders.matchQuery(Constants.TextImageConstants.TEXTPROMPT, request.getQ()).operator(Operator.OR));

		return boolQueryBuilder;
	}

}
