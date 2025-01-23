package com.unbox.spring_project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unbox.spring_project.entity.Menu;
import com.unbox.spring_project.service.MenuRestService;

@RestController
public class MenuRestController {
	
	@Autowired
	private MenuRestService menuRestService;

	// 메뉴(모든 게시판) 조회
	@GetMapping("/menu/all")
	public ResponseEntity<List<Menu>> getAllMenu() {
		List<Menu> menus = menuRestService.getList();
		
		if(menus != null && !menus.isEmpty()) {
			return ResponseEntity.ok(menus);
		} else {	
			return ResponseEntity.noContent().build(); // 상태코드 204번 noContent 반환
		}		
	}
	
	// 메뉴(게시글) 생성
	@PostMapping("/menu/add")
	public ResponseEntity<String> addMenu(@RequestBody Menu menu) {
		
		// 작성된 시점의 날짜 자동 설정
		if(menu.getIndate() == null || menu.getIndate().isEmpty()) {
			menu.setIndate(LocalDate.now().toString());
		}
		
		// 조회수 초기 설정
		menu.setCount(0);
		
		// 메뉴를 DB에 삽입
		menuRestService.boardInsert(menu);
		
		return ResponseEntity.ok("게시글 작성 완료");
	}
	
	// 메뉴(게시글) 수정
	@PutMapping("/menu/update/{idx}")
	public void updateMenu(@RequestBody Menu menu, @PathVariable("idx") int idx) {
		menu.setIdx(idx);
		menuRestService.boardUpdate(menu);
	}
	
	// 메뉴(게시글) 삭제
	@DeleteMapping("/menu/delete/{idx}")
	public void deleteMenu(@PathVariable("idx") int idx) {
		menuRestService.boardDelete(idx);
	}
	
	// 메뉴(게시글) 조회
	@GetMapping("/menu/{idx}")
	public ResponseEntity<Menu> getMenuById(@PathVariable("idx") int idx) {
		Menu menu = menuRestService.boardContent(idx);
		
		if(menu != null) {
			return ResponseEntity.ok(menu);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// 특정 메뉴(게시글) 조회수 증가
	@PutMapping("/menu/count/{idx}")
	public void incrementMenuCount(@PathVariable("idx") int idx) {
		menuRestService.boardCount(idx);
	}
	
}
