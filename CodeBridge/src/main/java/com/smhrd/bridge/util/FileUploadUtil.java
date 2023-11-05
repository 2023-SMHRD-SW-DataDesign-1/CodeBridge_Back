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
		

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try {
			// 파일 저장
			FileCopyUtils.copy(multipartFile.getBytes(), Paths.get(uploadDir + fileName).toFile());
		} catch (IOException e) {
			throw new IOException("Could not save file: " + fileName, e);
		}
	}
}