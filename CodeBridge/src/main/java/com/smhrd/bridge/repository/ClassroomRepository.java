package com.smhrd.bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smhrd.bridge.entity.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}
