package com.smhrd.bridge.controller;

import java.io.IOException;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.bridge.util.FileUploadUtil;

@RestController
@CrossOrigin("*")
@RequestMapping("/Img")
public class ImgController {

	// 저장할 디렉토리 경로
	private static final String UPLOAD_DIR = "C:\\Users\\smhrd\\git\\rCodeBridgeRepo\\CodeBridge\\src\\main\\resources\\static\\uploads/";

	@PostMapping("/save")
	public String handleFileUpload(@RequestParam("img") MultipartFile file) {
		System.out.println("메서드 진입");
		// 파일 이름 중복 방지를 위해 현재 시간을 추가
		String fileName = StringUtils.cleanPath(System.currentTimeMillis() + "_" + file.getOriginalFilename());
		System.out.println("fileName 확인 " + fileName);

		try {
			// 파일을 저장할 경로 설정
			String uploadDir = UPLOAD_DIR;
			System.out.println("uploadDir 확인 " + uploadDir);
			String filePath = uploadDir + fileName;
			System.out.println("filePath 확인 " + filePath);

			
			// 실제 파일 저장
			FileUploadUtil.saveFile(uploadDir, fileName, file);

			// 파일 URL 반환 (클라이언트에서 접근 가능한 경로로 변환)
			return "/uploads/" + fileName;
		} catch (IOException e) {
			return "Upload failed";
		}
	}

}
