package com.zee.sso.user.elastic.ingest.service.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilteredUserInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<UserBasicInfo> userBasicInfoEntities;

    private String status;

}
