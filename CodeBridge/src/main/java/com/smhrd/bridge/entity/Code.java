package com.smhrd.bridge.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CodeSave")
public class Code {

	@Id
	private int test_num;
	private String user_id;
	private String sub_code;
	private Timestamp regi_date;

}
