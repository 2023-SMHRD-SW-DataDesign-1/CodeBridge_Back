package com.smhrd.bridge.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smhrd.bridge.entity.Member;

@Mapper
public interface MemberMapper {

	@Insert("insert into Member values(#{user_id}, #{user_pw}, #{user_name}, "
			+ "#{user_nick}, 'https://i.ibb.co/XsypSbQ/profile-01.png', #{user_phone}, #{user_type}, null, null, default)")
	public int memberJoin(Member member);

	@Select("select * from Member where user_id = #{id}")
	public String idCheck(String id);

	@Select("select * from Member where user_id = #{user_id} and user_pw = #{user_pw}")
	public String memberLogin(Member member);

	@Select("SELECT cm.class_num, m.* " + "FROM Member m " + "LEFT JOIN ClassMember cm ON cm.user_id = m.user_id "
			+ "WHERE m.user_id = #{user_id}")
	public List<Member> memberCheck(Map<String, Object> id);

	@Update("update Member SET user_name = #{user_name} where user_id = #{user_id}")
	public int nameEdit(Map<String, Object> map);

	@Update("update Member SET user_nick = #{user_nick} where user_id = #{user_id}")
	public int nickEdit(Map<String, Object> map);

	@Update("update Member SET user_phone = #{user_phone} where user_id = #{user_id}")
	public int phoneEdit(Map<String, Object> map);

	@Update("update Member SET user_pw = #{user_pw} where user_id = #{user_id}")
	public int passwordEdit(Map<String, Object> map);

	@Delete("delete FROM Member where user_id = #{user_id}")
	public int idDelete(Map<String, Object> map);

	@Update("update Member set user_pic = #{user_pic} where user_id = #{user_id}")
	public int changePic(String user_id, String user_pic);

	@Select("select * from Member where user_id = #{user_id}")
	public List<Member> memberInfoTeacher(String user_id);

	@Update("update Member set hasclass = #{class_num} where user_id = #{user_id}")
	public void updateHasClass(String user_id, int class_num);

	@Select("select server_url from IdeMember where used = 0")
	public List<String> getIdeUrl();

	@Update("update Member set server_url = #{server_url} where user_id = #{user_id}")
	public int giveIde(Map<String, Object> req);

	@Update("update IdeMember set user_id = #{user_id}, used = 1 where server_url = #{server_url}")
	public void updateUseIde(Map<String, Object> req);

}
