package com.zee.sso.user.elastic.ingest.service;

import com.zee.sso.user.elastic.ingest.api.request.TextGeneratedImagesInfo;

public interface TextToImageElasticIngestService {

	void ingestTextImageInfo(TextGeneratedImagesInfo request);
}

