package com.zshop.sso.user.elastic.read.service;

import java.io.IOException;
import java.util.List;

import com.zshop.sso.user.elastic.read.api.dto.TextGeneratedImagesInfo;
import com.zshop.sso.user.elastic.read.api.request.TextImageSearchRequest;

public interface TextImageReadService {

	List<TextGeneratedImagesInfo> getImages(TextImageSearchRequest request) throws IOException;

}
