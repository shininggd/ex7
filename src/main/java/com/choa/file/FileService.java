package com.choa.file;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	//save
	public String fileSave(MultipartFile m, HttpSession session) throws Exception{
		FileSaver fileSaver = new FileSaver();
		String fileName = fileSaver.fileSave(session.getServletContext().getRealPath("resources/upload"), m);
		return fileName;
	}
	//delete
	public Boolean fileDelete(String fileName, HttpSession session) throws Exception{
		String realPath = session.getServletContext().getRealPath("resources/upload");
		File f = new File(realPath, fileName);
		
		return f.delete();
	}
	
	
}
