package com.zshop.sso.user.elastic.read.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String clientSpecificUserId;

    private String ssoDbUserId;

    private String ownerUserId;

    private Date fromDate;

    private Date toDate;

    @Builder.Default
    private Integer pageNo = 0;

    @Builder.Default
    private Integer pageSize = 10;

}
