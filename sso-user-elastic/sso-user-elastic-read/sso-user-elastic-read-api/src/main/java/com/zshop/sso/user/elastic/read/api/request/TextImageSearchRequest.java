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
public class TextImageSearchRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long imageId;

    private String q;

    private Date createDate;

    @Builder.Default
    private Integer pageNo = 1;

    @Builder.Default
    private Integer pageSize = 10;

}
