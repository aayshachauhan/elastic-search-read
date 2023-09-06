package com.zee.sso.user.elastic.ingest.service;

import java.util.List;

import com.zee.sso.user.elastic.ingest.api.request.SsoIngestRequest;
import com.zee.sso.user.elastic.ingest.service.entity.FilteredUserInfo;
import com.zee.sso.user.elastic.ingest.service.entity.UserBasicInfo;
import com.zshop.commons.exception.dao.DaoException;

public interface SsoIngestElasticService {

    void ingestSSO(SsoIngestRequest request);

    void syncUserInfo(List<UserBasicInfo> userBasicInfoEntities) throws DaoException;
}

