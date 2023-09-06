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

import com.zee.sso.user.elastic.ingest.api.request.SsoIngestRequest;
import com.zee.sso.user.elastic.ingest.service.SsoIngestElasticService;
import com.zee.sso.user.elastic.ingest.service.constants.Constants;
import com.zee.sso.user.elastic.ingest.service.entity.UserBasicInfo;
import com.zee.sso.user.elastic.ingest.service.mapper.UserSsoElasticMapper;
import com.zshop.commons.exception.dao.DaoException;
import com.zshop.helper.utils.GsonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SsoIngestElasticServiceImpl implements SsoIngestElasticService {

	@Autowired
	private UserSsoElasticMapper userSsoElasticMapper;

	@Autowired
	private RestHighLevelClient client;

	@Override
	public void ingestSSO(SsoIngestRequest request) {
		try {
			UserBasicInfo userBasicInfo = userSsoElasticMapper.mapSsoIngestRequestToElasticEntity(request);
			List<UserBasicInfo> userBasicInfos = new ArrayList<>();
			userBasicInfos.add(userBasicInfo);
			bulkUpdate(userBasicInfos);

		} catch (Exception e) {
			log.error("Some exception occured when trying to sync user info in elastic");
		}
	}

	@Override
	public void syncUserInfo(List<UserBasicInfo> userBasicInfoEntities) throws DaoException {
		try {
			bulkUpdate(userBasicInfoEntities);
		} catch (DaoException e) {
			throw new DaoException(Constants.Errors.ELASTIC_DATA_SYNC_ERR, e.getMessage(), e.getCause());
		}

	}

	/**
	 * Code to Create Request for Elastic Index
	 * 
	 * @param bulkRequest
	 * @paramUserBasicInfo
	 */
	private void addBulkRequestsForUserProfileUpdate(BulkRequest bulkRequest, UserBasicInfo userBasicInfo) {
		log.info("userBasicInfo {}", userBasicInfo);
		IndexRequest upsertRequest = new IndexRequest(Constants.Index.USER_BASIC_INFO)
				.opType(DocWriteRequest.OpType.INDEX).id(String.valueOf(userBasicInfo.getLoginId()))
				.source(GsonUtils.registerGsonBuilderZoneDateFormat().toJson(userBasicInfo), XContentType.JSON);
		UpdateRequest updateRequest = new UpdateRequest(Constants.Index.USER_BASIC_INFO,
				userBasicInfo.getLoginId()).doc(GsonUtils.getJson(userBasicInfo), XContentType.JSON)
						.upsert(upsertRequest);
		if (updateRequest != null) {
			bulkRequest.add(updateRequest);
		}

	}

	private void bulkUpdate(List<UserBasicInfo> userBasicInfos) throws DaoException {
		try {
			log.info("Syncing userBasicInfos data to elastic");
			if (CollectionUtils.isNotEmpty(userBasicInfos)) {
				log.info("Total users in requests recieved to be sync in elk: {}", userBasicInfos.size());
				BulkRequest bulkRequest = new BulkRequest();
				bulkRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);

				userBasicInfos.stream().forEach(user -> addBulkRequestsForUserProfileUpdate(bulkRequest, user));
				if (CollectionUtils.isNotEmpty(bulkRequest.requests())) {
					log.info("Total requests sent to be synced in elastic: {}", bulkRequest.requests().size());
					BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
					log.info("Response received from syncing searchable words data to elastic:{}", bulkResponse);
					if (bulkResponse.hasFailures()) {
						throw new DaoException(Constants.Errors.ELASTIC_DATA_SYNC_ERR,
								bulkResponse.buildFailureMessage(), new Throwable());
					}
				}
			} else {
				log.info("No data found for User Info {}", userBasicInfos);
			}
		} catch (Exception ex) {
			throw new DaoException(Constants.Errors.ELASTIC_DATA_SYNC_ERR, ex.getMessage(), ex.getCause());
		}
	}

}
