package com.unbox.spring_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unbox.spring_project.entity.CustomUser;
import com.unbox.spring_project.entity.User;
import com.unbox.spring_project.mapper.UserMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userMapper.findByUsername(username);

		if(user == null) {
			// 데이터가 없다면
			throw new UsernameNotFoundException("아이디" + username + "이(가) 존재하지않습니다.");
		}
		
		// 로그인 했을 때 DB에 유저 정보가 있다면	
		return new CustomUser(user);
	}
}
