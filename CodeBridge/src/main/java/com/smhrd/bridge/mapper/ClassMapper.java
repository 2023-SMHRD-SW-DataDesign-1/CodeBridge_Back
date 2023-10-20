package com.smhrd.bridge.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.smhrd.bridge.entity.Classroom;

@Mapper
public interface ClassMapper {

	


	@Insert("insert into Class values(default, #{user_id}, #{class_title},#{class_content}, #{class_target}, #{curriculum}, #{class_startdate}, #{class_enddate}, 1, sysdate())")
	public int classWrite(Classroom classroom);
	
	

}
