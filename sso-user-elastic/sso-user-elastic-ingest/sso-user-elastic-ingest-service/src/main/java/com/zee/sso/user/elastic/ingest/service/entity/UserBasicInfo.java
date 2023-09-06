package com.zee.sso.user.elastic.ingest.service.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.zee.sso.user.elastic.ingest.api.request.UserClientDomainInfo;
import com.zee.sso.user.elastic.ingest.api.request.UserClientVisitorInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserBasicInfo {


    private Long userId;

    private String loginId;

    private String password;

    private String firstName;

    private String middleName;

    private String lastName;

    private String mobileNo;

    private String altMobileNo;

    private String emailId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", locale = "en_IN", timezone = "Asia/Calcutta")
    private Date ubiLastLoginDate;

    private String isRegisteredViaSocialMedia;

    private String userHashcode;

    private String otp;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", locale = "en_IN", timezone = "Asia/Calcutta")
    private Date otpExpiryTime;

    private String isActive;

    private String deleted;
    
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", locale = "en_IN", timezone = "Asia/Calcutta")
    private Date createdDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", locale = "en_IN", timezone = "Asia/Calcutta")
	private Date modified_date;
    
    private String registrationType;

	private Long zshopUserId;
    
    private String userMobileVerified;

    private String userEmailVerified;

    private UserClientDomainInfo userClientDomainInfo;

    private String ownerUserId;
    
    private List<UserClientVisitorInfo> userClientVisitorInfo;
}
