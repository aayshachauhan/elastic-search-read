package com.zshop.sso.user.elastic.read.api.response;

import lombok.Data;

@Data
public class UserClientVisitorInfo {

	public Long clientId;
	public String clientName;
	public String clientDesc;
	
	public Long domainID;
	public String domainName;
	
	public Long userId;
	
	public String visitorId;
	public String gaid;
	
	private String isActive;
	private String deleted;
}
