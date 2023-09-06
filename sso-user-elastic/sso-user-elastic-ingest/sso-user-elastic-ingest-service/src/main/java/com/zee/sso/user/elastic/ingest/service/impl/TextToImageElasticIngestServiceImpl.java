package com.zee.sso.user.elastic.ingest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zee.sso.user.elastic.ingest.api.request.TextGeneratedImagesInfo;
import com.zee.sso.user.elastic.ingest.service.TextToImageElasticIngestService;
import com.zee.sso.user.elastic.ingest.service.constants.Constants;
import com.zshop.commons.exception.dao.DaoException;
import com.zshop.helper.utils.ConversionUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TextToImageElasticIngestServiceImpl implements TextToImageElasticIngestService {

	@Autowired
	private RestHighLevelClient client;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void ingestTextImageInfo(TextGeneratedImagesInfo request) {
		try {
			List<TextGeneratedImagesInfo> textImages = new ArrayList<>();
			textImages.add(request);
			bulkUpdate(textImages);

		} catch (Exception e) {
			log.error("Some exception occured when trying to sync text images info in elastic");
		}

	}

	private void bulkUpdate(List<TextGeneratedImagesInfo> textImages) throws DaoException {
		try {
			log.info("Syncing text images data to elastic");
			if (CollectionUtils.isNotEmpty(textImages)) {
				log.info("Total images in requests recieved to be sync in elk: {}", textImages.size());
				BulkRequest bulkRequest = new BulkRequest();
				bulkRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);

				textImages.stream().forEach(image -> addBulkRequestsForUserProfileUpdate(bulkRequest, image));

				if (CollectionUtils.isNotEmpty(bulkRequest.requests())) {
					log.info("Total requests sent to be synced in elastic: {}", bulkRequest.requests().size());
					BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
					log.info("Response received from syncing to elastic:{}", bulkResponse);
					if (bulkResponse.hasFailures()) {
						throw new DaoException(Constants.Errors.ELASTIC_DATA_SYNC_ERR,
								bulkResponse.buildFailureMessage(), new Throwable());
					}
				}
			} else {
				log.info("No data found for text images Info {}", textImages);
			}
		} catch (Exception ex) {
			throw new DaoException(Constants.Errors.ELASTIC_DATA_SYNC_ERR, ex.getMessage(), ex.getCause());
		}
	}

	private void addBulkRequestsForUserProfileUpdate(BulkRequest bulkRequest, TextGeneratedImagesInfo textImageInfo) {
		log.info("TextImageInfo {}", textImageInfo);
		IndexRequest upsertRequest;
		UpdateRequest updateRequest = null;

		try {
			upsertRequest = new IndexRequest(Constants.Index.TEXT_TO_IMAGE).opType(DocWriteRequest.OpType.INDEX)
					.id(String.valueOf(textImageInfo.getImageId()))
					.source(objectMapper.writeValueAsString(textImageInfo), XContentType.JSON);
			updateRequest = new UpdateRequest(Constants.Index.TEXT_TO_IMAGE,
					ConversionUtils.getSafeString(textImageInfo.getImageId()))
					.doc(objectMapper.writeValueAsString(textImageInfo), XContentType.JSON).upsert(upsertRequest);
		} catch (JsonProcessingException e) {
			log.error("Exception occured while trying to parse news json {}", e);
		}

		if (updateRequest != null) {
			bulkRequest.add(updateRequest);
		}

	}

}
