package com.smhrd.bridge.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "SubjectTest")
public class SubjectTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int sub_num;

	@ElementCollection
	@CollectionTable(name = "test_num", joinColumns = @JoinColumn(name = "subject_test_id"))
	@Column(name = "test_num")
	private List<Integer> test_num;

	// Getters and Setters
}
