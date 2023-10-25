package com.smhrd.bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smhrd.bridge.entity.Code;

public interface CodeSaveRepository extends JpaRepository<Code, Integer> {

	// 추가적인 메소드가 필요한 경우 여기에 작성할 수 있습니다.
}
