package com.unbox.spring_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbox.spring_project.entity.User;
import com.unbox.spring_project.mapper.UserMapper;

@Service
public class UserService {

	// 의존성 주입
	@Autowired
	private UserMapper userMapper;
	
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}
	
	public String findWriter(String username) {
		return userMapper.findWriter(username);
	}
}
