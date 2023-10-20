package com.smhrd.bridge.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.bridge.entity.Subject;

@Mapper
public interface SubMapper {

	@Insert("insert into Subject values(default, #{user_id}, #{sub_lang}, #{sub_title}, 0, sysdate())")
	public int subInsert(Map<String, Object> map);

	@Select("select * from Subject where used=0")
	public List<Subject> subSearch();

}
