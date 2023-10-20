package com.smhrd.bridge.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
		Path uploadPath = Paths.get(uploadDir);
		
		System.out.println("유틸 진입");

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try {
			// 파일 저장
			FileCopyUtils.copy(multipartFile.getBytes(), Paths.get(uploadDir + fileName).toFile());
			System.out.println("파일이 저장된 경로: " + uploadDir + fileName); // 이 부분을 추가
		} catch (IOException e) {
			throw new IOException("Could not save file: " + fileName, e);
		}
	}
}