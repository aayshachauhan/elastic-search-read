package com.zshop.sso.user.elastic.read.api.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserReportInfo {

	private Long userId;

	private String loginId;

	private String firstName;

	private String middleName;

	private String lastName;

	private String mobileNo;

	private String altMobileNo;

	private String emailId;

	private String createdDate;

	private String gender;

	private String birthDate;

	private UserClientDomainInfo userClientDomainInfo;

	private String ownerUserId;
	
    private List<UserClientVisitorInfo> userClientVisitorInfo;

}
