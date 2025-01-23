package com.unbox.spring_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbox.spring_project.entity.Menu;
import com.unbox.spring_project.mapper.MenuRestMapper;

@Service
public class MenuRestService {

	@Autowired
	private MenuRestMapper menuRestMapper;
	
	// 게시글 목록을 가져오는 메소드
	public List<Menu> getList() {
		return menuRestMapper.getList();
	}
	
	// 게시글 추가
	public void boardInsert(Menu menu) {
		menuRestMapper.boardInsert(menu);
	}
	
	// 특정 게시글 조회
	public Menu boardContent(int idx) {
		return menuRestMapper.boardContent(idx);
		
	}
	
	// 게시글 수정
	public void boardUpdate(Menu menu) {
		menuRestMapper.boardUpdate(menu);
	}
	
	// 게시글 삭제
	public void boardDelete(int idx) {
		menuRestMapper.boardDelete(idx);
	}
	
	// 게시글 조회수 증가
	public void boardCount(int idx) {
		menuRestMapper.boardCount(idx);
	}
}
