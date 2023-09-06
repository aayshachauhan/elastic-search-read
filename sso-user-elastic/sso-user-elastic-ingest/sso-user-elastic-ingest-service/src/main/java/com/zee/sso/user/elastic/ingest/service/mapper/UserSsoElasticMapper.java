package com.zee.sso.user.elastic.ingest.service.mapper;


import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import com.zee.sso.user.elastic.ingest.api.request.SsoIngestRequest;
import com.zee.sso.user.elastic.ingest.api.request.UserBasicInfoEntity;
import com.zee.sso.user.elastic.ingest.service.entity.UserBasicInfo;

@Mapper(componentModel = "spring")
@Service
public interface UserSsoElasticMapper {



UserBasicInfo mapSsoIngestRequestToElasticEntity(SsoIngestRequest ssoIngestRequest);
List<UserBasicInfo> mapSsoIngestRequestToListOfUserInfo(List<UserBasicInfoEntity> userBasicInfoEntityList);


}
