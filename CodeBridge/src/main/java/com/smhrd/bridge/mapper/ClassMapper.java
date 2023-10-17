package com.smhrd.bridge.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.smhrd.bridge.entity.classs;

@Mapper
public interface ClassMapper {

	


	@Insert("insert into Class values(default, 'asd@asd.com', #{class_title},#{class_content}, #{class_target}, #{curriculum}, #{class_startdate},#{class_enddate})")
	public int ClassWrite(classs classs);
	
	

}
