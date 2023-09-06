package com.zshop.sso.user.elastic.read.constants;

public class Constants {
    public interface Filter {
        Integer PAGE_SIZE = 10;
        Integer PAGE_NO = 0;
    }

    public interface UserInfoConstants {

        String MOBILE_NO = "mobileNo";
        String EMAIL_ID = "emailId";

        String USER_LOGIN_ID = "loginId";
        String OTP = "otp.keyword";

        String CLIENT_SPECIFIC_USER_ID = "zshopUserId";
        String USER_ID = "userId";
        String OWNER_USER_ID = "ownerUserId";
        String CREATED_DATE = "createdDate";
        
        String CLIENT_ID = "userClientDomainInfo.clientName.keyword";
        String DOMAIN_ID ="userClientDomainInfo.domainName.keyword";
        String  VISITOR_ID ="userClientVisitorInfo.visitorId";
        String GAID ="userClientVisitorInfo.gaid";

    }

    public interface Index {
        String USER_BASIC_INFO = "user_basic_info";
        String TEXT_TO_IMAGE = "text_to_image";
    }

    public interface TextImageConstants {

        String USERID = "userId";
        String USERNAME = "userName";
        String IMAGEID = "imageId";
        String IMAGENAME = "imageName";
        String TEXTPROMPT = "textPrompt";
        String CREATED_DATE = "createDate";

    }

}
