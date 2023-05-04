package com.multi.instagram.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardFileUploadLogic {
	public List<BoardFileDTO> uploadFiles(List<MultipartFile> multipartFiles, String path) throws IllegalStateException, IOException{
		List<BoardFileDTO> filedtolist = new ArrayList<BoardFileDTO>();
		for (MultipartFile multipartFile:multipartFiles) {
			//클라이언트가 업로드한 파일명
			String originalFilename  = multipartFile.getOriginalFilename();
			//서버에서 식별할 수 있도록 파일명을 변경
			String storeFilename = createStoreFilename(originalFilename);
			
			//File객체를 실제 경로에 저장
			multipartFile.transferTo(new File(path+File.separator + storeFilename));
			filedtolist.add(new BoardFileDTO(originalFilename, storeFilename));
			
		}
		
		return filedtolist;
	}
	
	private String createStoreFilename(String origianlFilename) {
		int pos = origianlFilename.lastIndexOf(".");
		String ext = origianlFilename.substring(pos+1);
		String uuid = UUID.randomUUID().toString();
		return uuid+"."+ext;
	}
}


