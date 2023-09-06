package com.zee.sso.user.elastic.ingest.api.request;

import java.time.LocalDateTime;

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
	
    private LocalDateTime createDate;
	
}
