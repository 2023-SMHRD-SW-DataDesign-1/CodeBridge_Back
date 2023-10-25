package com.smhrd.bridge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectStudent {

	private int sub_num;
	private String user_id;
	private int tested;
}
