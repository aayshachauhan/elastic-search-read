package com.zshop.sso.user.elastic.read.dao;

import java.io.IOException;

import org.elasticsearch.search.SearchHits;

import com.zshop.sso.user.elastic.read.api.request.TextImageSearchRequest;

public interface TextImageReadDao {

	public SearchHits fetchDataFromElk(TextImageSearchRequest request) throws IOException;

}
