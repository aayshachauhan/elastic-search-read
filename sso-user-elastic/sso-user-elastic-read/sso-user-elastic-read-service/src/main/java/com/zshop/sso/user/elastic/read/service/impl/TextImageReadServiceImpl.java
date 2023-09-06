package com.zshop.sso.user.elastic.read.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zshop.helper.utils.GsonUtils;
import com.zshop.sso.user.elastic.read.api.dto.TextGeneratedImagesInfo;
import com.zshop.sso.user.elastic.read.api.request.TextImageSearchRequest;
import com.zshop.sso.user.elastic.read.dao.TextImageReadDao;
import com.zshop.sso.user.elastic.read.service.TextImageReadService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TextImageReadServiceImpl implements TextImageReadService {

	@Autowired
	TextImageReadDao textImageReadDao;

	@Override
	public List<TextGeneratedImagesInfo> getImages(TextImageSearchRequest request) throws IOException {

		SearchHits searchHits = textImageReadDao.fetchDataFromElk(request);

		log.info("Total hits fetched from elk {}", searchHits.getTotalHits());
		List<TextGeneratedImagesInfo> textImages = new ArrayList<>();

		for (SearchHit hit : searchHits) {
			TextGeneratedImagesInfo textImage = GsonUtils
					.registerGsonBuilderSpecificDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
					.fromJson(hit.getSourceAsString(), TextGeneratedImagesInfo.class);
			textImages.add(textImage);
		}

		return textImages;
	}

}
