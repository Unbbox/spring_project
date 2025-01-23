package com.unbox.spring_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unbox.spring_project.entity.Menu;
import com.unbox.spring_project.service.MenuRestService;
import com.unbox.spring_project.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

// @Component 한마디로 스프링빈으로 등록하기 위한 라벨링 작업
@Controller
@Log4j2
public class PageController {
	
	@Autowired
	private MenuRestService menuRestService;
	
	@Autowired
	private UserService userService;

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
	
	@GetMapping("/noticeAddPage")
	public String noticeAddPage(Model model, Authentication authentication) {
		
		// 작성자 추가
		String writer = userService.findWriter(authentication.getName());
		model.addAttribute("writer", writer);
		
		return "noticeAdd/index";
	}
	
	@GetMapping("/noticeCheckPage")
	public String showNoticeCheckPage(@RequestParam("idx") int idx, Model model) {
		Menu menu = menuRestService.boardContent(idx);
		
		model.addAttribute("menu", menu);
		
		return "noticeCheck/index";
	}
	
	@GetMapping("/noticeModifyPage")
	public String showNoticeModifyPage(@RequestParam("idx") int idx, Model model) {
		Menu menu = menuRestService.boardContent(idx);
		
		model.addAttribute("menu", menu);
		
		return "noticeModify/index";
	}
}
