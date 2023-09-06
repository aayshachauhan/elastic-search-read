package com.zshop.sso.user.elastic.read.api.response;

import lombok.Data;

@Data
public class UserClientDomainInfo {


    public Long domainID;
    public String domainName;
    public Long clientId;
    public String clientName;
    public String clientDescription;
    private String isActive;
    private String deleted;
}
