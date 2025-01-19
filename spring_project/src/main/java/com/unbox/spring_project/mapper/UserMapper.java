package com.unbox.spring_project.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.unbox.spring_project.entity.User;

// @Mapper => @Component와 비슷하게 자동으로 스프링 컨테이너에 등록이 됨(인터페이스)
// 자바와 mysql를 서로 통역해주는 역할
@Mapper 
public interface UserMapper {

	// Create
	@Insert("INSERT INTO backend_spring_project.user(username, password, writer, role) VALUES(#{username}, #{password}, #{writer}, #{role})")
	void insertUser(User user);
	
	// Read
	@Select("SELECT username, password, writer, role FROM backend_spring_project.user WHERE username=#{username}")
	User findByUsername(String username);
	
	// 작성자 찾기
	@Select("SELECT writer FROM backend_spring_project.user WHERE username=#{username}")
	String findWriter(String username);
	
	// Update
//	@Update()
	
	// Delete
//	@Delete()
}
