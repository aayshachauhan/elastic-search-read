package com.zshop.sso.user.elastic.read.dao.impl;

import java.io.IOException;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zshop.sso.user.elastic.read.api.request.UserReportRequest;
import com.zshop.sso.user.elastic.read.api.request.UserSearchRequest;
import com.zshop.sso.user.elastic.read.constants.Constants;
import com.zshop.sso.user.elastic.read.dao.UserInfoReadDao;
import com.zshop.sso.user.elastic.read.utils.UserInfoSearchQueryUtils;

@Component
public class UserInfoReadDaoImpl implements UserInfoReadDao {

    @Autowired
    UserInfoSearchQueryUtils userInfoSearchQueryUtils;

    @Autowired
    private RestHighLevelClient client;

    @Override
    public SearchHits fetchDataFromElk(UserSearchRequest request) throws IOException {
        BoolQueryBuilder boolQueryBuilder = userInfoSearchQueryUtils.userProfileSearchQuery(request);
        SearchRequest searchRequest = new SearchRequest().indices(Constants.Index.USER_BASIC_INFO)
                .source(new SearchSourceBuilder().query(boolQueryBuilder)
                        .from(request.getPageNo() * 10).size(request.getPageSize())
                        .sort(Constants.UserInfoConstants.CREATED_DATE));
        return client.search(searchRequest, RequestOptions.DEFAULT).getHits();

    }

	@Override
	public SearchHits fetchDataFromElastic(UserReportRequest request) throws IOException {
		 BoolQueryBuilder boolQueryBuilder = userInfoSearchQueryUtils.userReportSearchQuery(request);
	        SearchRequest searchRequest = new SearchRequest().indices(Constants.Index.USER_BASIC_INFO)
	                .source(new SearchSourceBuilder().query(boolQueryBuilder)
	                        .from(request.getPageNo() * 10).size(request.getPageSize())
	                        .sort(Constants.UserInfoConstants.CREATED_DATE));
	       
	        return client.search(searchRequest, RequestOptions.DEFAULT).getHits();
	}

}
