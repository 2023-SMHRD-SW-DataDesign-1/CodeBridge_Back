package com.smhrd.bridge.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.mapper.MarkMapper;

@Service
public class MarkService {

	@Autowired
	private MarkMapper markMapper;

	public int uploadMark(Map<String, Object> req) {
		int row = markMapper.uploadMark(req);

		return row;
	}

}
