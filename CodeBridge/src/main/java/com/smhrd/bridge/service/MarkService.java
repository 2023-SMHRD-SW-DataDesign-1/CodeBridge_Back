package com.smhrd.bridge.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.MarkResult;
import com.smhrd.bridge.entity.MarkResultStu;
import com.smhrd.bridge.mapper.MarkMapper;

@Service
public class MarkService {

	@Autowired
	private MarkMapper markMapper;

	public int uploadMark(Map<String, Object> req) {
		int row = markMapper.uploadMark(req);

		return row;
	}

	public int testSubmit(Map<String, Object> req) {
		int row = markMapper.testSubmit(req);
		return row;
	}

	public List<Integer> getMarkScore(Map<String, Object> req) {
		List<Integer> sub_list = markMapper.getMarkScore(req);
		return sub_list;
	}

	public List<MarkResult> getScore(String sub_num, String user_id) {
		List<MarkResult> score_list = markMapper.getScore(sub_num, user_id);
		return score_list;
	}

	public List<MarkResultStu> getDetailMark(Map<String, Object> req) {
		List<MarkResultStu> list = markMapper.getDetailMark(req);
		return list;
	}

}
