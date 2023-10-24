package com.smhrd.bridge.entity;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
	private int sub_num;
	@NonNull private String user_name;
	@NonNull private String sub_lang;
	@NonNull private String sub_title;
	private int used;
	private int tested;
	private String regi_date;
}
