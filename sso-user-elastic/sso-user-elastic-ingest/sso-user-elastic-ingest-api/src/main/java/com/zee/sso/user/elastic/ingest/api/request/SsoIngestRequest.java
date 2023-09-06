package com.zee.sso.user.elastic.ingest.api.request;


import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SsoIngestRequest  implements Serializable {


    private static final long serialVersionUID = 1L;
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
    
    private String userMobileVerified;

    private String userEmailVerified;

    private String registrationType;

    private String isBlocked;

	private Long zshopUserId;

    private UserClientDomainInfo userClientDomainInfo;
    
    private String ownerUserId;
}
