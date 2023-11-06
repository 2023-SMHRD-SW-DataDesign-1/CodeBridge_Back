package com.smhrd.bridge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkResultStu {
	
	int sub_num;
	int test_num;
	String user_id;
	String sub_code;
	String mark_result;
	Double mark_score;
	int objection;
	String test_description;

}
