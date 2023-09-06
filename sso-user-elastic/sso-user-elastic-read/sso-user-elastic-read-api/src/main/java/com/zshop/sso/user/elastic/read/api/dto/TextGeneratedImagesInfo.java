package com.zshop.sso.user.elastic.read.api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class TextGeneratedImagesInfo {
	
	private Long imageId;
	private String imageUrl;
	
	private String userName;
	private String userId;

	private String textPrompt;
	private String imageName;

	private String imageUniqueIdentifier;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", locale = "en_IN", timezone = "Asia/Calcutta")
    private Date createDate;
	
}
