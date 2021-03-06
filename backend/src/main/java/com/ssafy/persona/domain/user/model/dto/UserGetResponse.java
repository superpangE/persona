package com.ssafy.persona.domain.user.model.dto;

import com.ssafy.persona.domain.user.model.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class UserGetResponse {
	private int userSeq;
	private String userId;
	private String userEmail;
	private String userBirth;
	private int userCreatableCount;
	
	public UserGetResponse(User user) {
		this.userSeq = user.getUserSeq();
		this.userId =  user.getUserId();
		this.userEmail = user.getUserEmail();
		this.userBirth = user.getUserBirth();
		this.userCreatableCount = user.getUserCreatableCount();
	}
}
