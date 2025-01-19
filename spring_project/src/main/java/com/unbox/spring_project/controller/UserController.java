package com.unbox.spring_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.unbox.spring_project.entity.Role;
import com.unbox.spring_project.entity.User;
import com.unbox.spring_project.service.UserService;


@Controller
public class UserController {

	// 아래처럼 생성자를 이용하는게 보안적으로는 더 좋다	
	//	public UserController(UserService userService) {
	//		this.userService = userService;
	//	}
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// @ModelAttribute => .jsp 에서 넘어온 데이터들을 User에 담기게 함
	@PostMapping("/register")
	public String register(@ModelAttribute User user) {
		
		System.out.println("회원가입 요청");
		
		String userPassword = user.getPassword();
		System.out.println("userPassword: "+ userPassword);
		user.setRole(Role.MEMBER);
		String passwordEncoded = passwordEncoder.encode(userPassword);
		user.setPassword(passwordEncoded);
		userService.insertUser(user);
		
		return "redirect:/loginPage";
	}
	
	
}
