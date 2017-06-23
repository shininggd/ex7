package com.choa.file;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.choa.util.SeDTO;

@Service
public class FileService {
	//seupload
	public String seUpload(SeDTO seDTO, HttpSession session) throws Exception{
		String  file_result = null;
		if(seDTO.getFiledata() != null && seDTO.getFiledata().getOriginalFilename()!=null && !seDTO.getFiledata().getOriginalFilename().equals("")){
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/upload");
		String realName = fs.fileSave(realPath, seDTO.getFiledata());
		
		 file_result = "&bNewLine=true&sFileName="+seDTO.getFiledata().getOriginalFilename()+"&sFileURL=/ex7/resources/upload/"+realName;
		
		}else{
			file_result="&errst=error";
		}
		return "redirect:"+seDTO.getCallback()+"?callback_func="+seDTO.getCallback_func()+file_result;
		
	}
	
	
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
