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

    private String ubiLastLoginDate;

    private String isRegisteredViaSocialMedia;

    private String userHashcode;

    private String otp;

    private String otpExpiryTime;

    private String isActive;

    private String deleted;

    private String createdDate;

    private String modified_date;

    private String userMobileVerified;

    private String userEmailVerified;

    private String gender;

	private String birthDate;
	
	private Long zshopUserId;

    private UserClientDomainInfo userClientDomainInfo;

    private String ownerUserId;
    
    private List<UserClientVisitorInfo> userClientVisitorInfo;
}
