package com.zshop.sso.user.elastic.read.dao;

import com.zshop.sso.user.elastic.read.api.request.UserReportRequest;
import com.zshop.sso.user.elastic.read.api.request.UserSearchRequest;
import org.elasticsearch.search.SearchHits;

import java.io.IOException;

public interface UserInfoReadDao {

    public SearchHits fetchDataFromElk(UserSearchRequest request) throws IOException;
    
    public SearchHits fetchDataFromElastic(UserReportRequest request) throws IOException;



}
