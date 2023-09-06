package com.zee.sso.user.elastic.ingest.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBasicInfoEntity {


	private Long userId;


	private String loginId;

	private String password;

	private String firstName;


	private String middleName;

	private String lastName;

	private String mobileNo;

	private String altMobileNo;

	private String emailId;

	private String ubiLastLoginDate;

	private String isRegisteredViaSocialMedia;

	private String userHashcode;

	private String otp;

	private String otpExpiryTime;

	private String deleted;

	private String createdDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", locale = "en_IN", timezone = "Asia/Calcutta")
	private Date modified_date;

	private String isActive;

	private String registrationType;

	private String userMobileVerified;

	private String userEmailVerified;

	private String isBlocked;

	private UserClientDomainInfo userClientDomainInfo;


}
