package com.zshop.sso.user.elastic.read.service.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.zshop.commons.exception.business.BusinessException;
import com.zshop.helper.utils.GsonUtils;
import com.zshop.sso.user.elastic.read.api.request.UserSearchRequest;
import com.zshop.sso.user.elastic.read.api.response.UserBasicInfo;
import com.zshop.sso.user.elastic.read.dao.UserInfoReadDao;
import com.zshop.sso.user.elastic.read.service.UserInfoReadService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserInfoReadServiceImpl implements UserInfoReadService {
    @Autowired
    UserInfoReadDao userInfoReadDao;

    @Override
    public List<UserBasicInfo> getUserProfileDataFromElk(UserSearchRequest request)
            throws IOException, BusinessException, ParseException {
        SearchHits searchHits = userInfoReadDao.fetchDataFromElk(request);
        log.info("Total hits fetched from elk {}", searchHits.getTotalHits());
        List<UserBasicInfo> userInfoList = new ArrayList<>();

        for (SearchHit hit : searchHits) {
            UserBasicInfo userBasicInfo = GsonUtils.registerGsonBuilder().fromJson(hit.getSourceAsString(),
                    UserBasicInfo.class);

            userBasicInfo.setOtpExpiryTime(dateParse(userBasicInfo.getOtpExpiryTime()));
            userBasicInfo.setCreatedDate(dateParse(userBasicInfo.getCreatedDate()));
            userBasicInfo.setModified_date(dateParse(userBasicInfo.getModified_date()));
            userBasicInfo.setUbiLastLoginDate(dateParse(userBasicInfo.getUbiLastLoginDate()));
            userInfoList.add(userBasicInfo);
        }
        if (!CollectionUtils.isEmpty(userInfoList)) {
            if (request.getFromDate() != null)
                return userInfoList;
            return Arrays.asList(userInfoList.get(0));
        }
        return userInfoList;

    }

    private String dateParse(String requestDate) throws ParseException {

        String finalString = "";
        if (!StringUtils.isEmpty(requestDate)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            Date date = (Date) formatter.parse(requestDate);
            finalString = simpleDateFormat.format(date);

        }
        return finalString;
    }

}
