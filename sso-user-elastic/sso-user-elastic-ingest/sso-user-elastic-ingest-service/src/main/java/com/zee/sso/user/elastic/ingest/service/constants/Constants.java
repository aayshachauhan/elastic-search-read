package com.zee.sso.user.elastic.ingest.service.constants;

public class Constants {
    public interface Filter {
        Integer PAGE_SIZE = 10;
        Integer PAGE_NO = 0;
    }

    public interface UserInfoConstants {
        //String[] USER_FIELDS = new String[]{"userId","mobileNo","emailId"};
        String USER_LOGIN_ID = "userLoginId";
        String MOBILE_NO = "mobileNo";
        String EMAIL_ID= "emailId";

        String USER_LOGIN_ID_KEYWORD = "userLoginId.keyword";
        String OTP_KEYWORD = "otp.keyword";

    }

    public interface Index{
        String USER_BASIC_INFO= "user_basic_info";
        String TEXT_TO_IMAGE = "text_to_image";
    }


    public interface Errors {
        String ELASTIC_DATA_SYNC_ERR = "ELASTIC_DATA_SYNC_ERR";
        String ELASTIC_DATA_GET_ERR = "ELASTIC_DATA_GET_ERR";
        String ELASTIC_DATA_SEARCH_ERR = "ELASTIC_DATA_SEARCH_ERR";
        String ELASTIC_DATA_DELETE_ERR = "ELASTIC_DATA_DELETE_ERR";
    }
}
