package com.unbox.spring_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.unbox.spring_project.entity.Menu;

// @Component 와 비슷 => @ComponentScan
// @Mapper => @MapperScan => 자동으로 스프링컨테이너에 등록
@Mapper
public interface MenuRestMapper {

	// insert
	@Insert("INSERT INTO backend_spring_project(memID,title,content,writer,indate) VALUES(#{memID},#{title},#{content},#{writer},#{indate})")
	public void boardInsert(Menu menu);
	
	// select
	@Select("SELECT idx, memID, title, content, indate, count FROM backend_spring_project.memu ORDER BY idx DESC")
	public List<Menu> getList();
	
	@Select("SELECT idx, memID, title, content, indate, count FROM backend_spring_project.memu WHERE idx = #{idx}")
	public Menu boardContent(int idx);
	
	// update
	@Update("UPDATE backend_spring_project.menu SET title=#{title}, content=#{content}, writer=#{writer} WHERE idx=#{idx}")
	public void boardUpdate(Menu menu);
	
	@Update("UPDATE backend_spring_project.menu SET count=count+1 WHERE idx=#{idx}")
	public void boardCount(int idx);
	
	// delete
	@Delete("DELETE FROM backend_spring_project.menu WHERE idx=#{idx}")
	public void boardDelete(int idx);
}
