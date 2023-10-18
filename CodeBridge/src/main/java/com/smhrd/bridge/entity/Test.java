package com.smhrd.bridge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
	
	private int test_num;
	private String test_title;
	private String test_level;
	private String test_lang;
	private String test_contents;
	private String test_condition;
	private String regi_date;

}
