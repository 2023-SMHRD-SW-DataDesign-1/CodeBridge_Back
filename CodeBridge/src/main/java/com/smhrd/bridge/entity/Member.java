package com.smhrd.bridge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_nick;
	private String user_pic;
	private String user_phone;
	private int user_type;
	private String user_his;
	private int hasclass;
	private String server_url;
	private String regi_date;

	private int class_num;
}
