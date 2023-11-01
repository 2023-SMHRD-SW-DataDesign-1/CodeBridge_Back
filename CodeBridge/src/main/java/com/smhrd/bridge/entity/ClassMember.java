package com.smhrd.bridge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassMember {
	private int class_num;
	private String user_id;
	private String user_name;
	private int approved;
	private int isteacher;

}
