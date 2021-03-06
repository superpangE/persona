package com.ssafy.persona.domain.user.service;

import com.ssafy.persona.domain.user.mapper.UserMapper;
import com.ssafy.persona.domain.user.model.dto.UserGetResponse;
import com.ssafy.persona.domain.user.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    UserMapper userMapper;

	@Override
	public UserGetResponse getUser(String userId) {
		// user가 없다면
		if(userMapper.seqIsValid(userId) < 1)
			return (null);
		// 해당 user 있음
		return (userMapper.getUser(userId));
	}

	@Override
	public boolean userValid(String userId) {
		if(userMapper.userValid(userId) > 0) return (true);
		return (false);
	}

	@Override
	@Transactional
	public int userSignup(User user) {
		
		// userId 중복검사
		if (userMapper.userValid(user.getUserId()) > 0) {
			return (0);
		}
		// userEmail 중복검사 해야할듯
		if (userMapper.checkEmail(user.getUserEmail())>0)
			return (0);
		return (userMapper.userSignup(user));
	}

	@Override
	public int checkPw(User user) {
		return (userMapper.checkPw(user));
	}

	@Override
	public int checkEmail(String userEmail) {
		return (userMapper.checkEmail(userEmail));
	}

	@Override
	public int changePw(User user) {
		return (userMapper.changePw(user));
	}

	@Override
	public int changeBirth(User user) {
		return (userMapper.changeBirth(user));
	}

	@Override
	public String getUserId(String userEmail) {
		return (userMapper.getUserId(userEmail));
	}

	@Override
	public int userActive(String userEmail) {
		return (userMapper.userActive(userEmail));
	}

	@Override
	public int userLogin(User user) {
		return (userMapper.userLogin(user));
	}

	@Override
	public int getUserSeq(String userId) {
		Integer tmp = userMapper.getUserSeq(userId);
		if(tmp == null) return (0);
		return (tmp);
	}

	@Override
	public int emailIsValid(String userId) {
		return (userMapper.emailIsValid(userId));
	}

	@Override
	public String getUserEmail(String userId) {
		return (userMapper.getUserEmail(userId));
	}
	
	@Override
	public int isValid(String userId){return (userMapper.isValid(userId));}


}
