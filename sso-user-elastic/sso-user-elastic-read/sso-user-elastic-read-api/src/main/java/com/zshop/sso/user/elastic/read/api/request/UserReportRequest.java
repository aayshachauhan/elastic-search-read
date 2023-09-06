package com.zshop.sso.user.elastic.read.api.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReportRequest {

	private String userId;

	private String loginId;

	private String clientId;

	private String domainId;

	private String visitorId;

	private String gaid;

	private Date fromDate;

	private Date toDate;

	@Builder.Default
	private Integer pageNo = 0;

	@Builder.Default
	private Integer pageSize = 10;
}
