package com.unbox.spring_project.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

// @Component 한마디로 스프링빈으로 등록하기 위한 라벨링 작업
@Controller
@Log4j2
public class PageController {

	@GetMapping("/")
	public String returnHome() {
		return "index";
	}
	
	@GetMapping("/registerPage")
	public String registerPage(HttpServletRequest request, Model model) {
		System.out.println("회원가입 페이지 요청");
		
		CsrfToken csrfToken = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
		model.addAttribute("_csrf", csrfToken);
		
		return "register/register_Index";
	}
	
	@GetMapping("/loginPage")
	public String loginPage(HttpServletRequest request, Model model) {
		
		CsrfToken csrfToken = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
		model.addAttribute("_csrf", csrfToken);
		
		return "login/login_Index";
	}
}
