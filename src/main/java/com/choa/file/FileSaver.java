package com.choa.file;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	
	public String fileSave(String realPath,String oriName, byte [] fileData ) throws Exception{
		File f = new File(realPath);
		if(!f.exists()){
			f.mkdirs();
		}
		//업로드 폴더에 저장되는 실제 파일 이름
		String fileName = UUID.randomUUID().toString()+"_"+oriName;
		File target = new File(f, fileName); // (경로를 가진 File 객체, 저장될 파일 이름)
		FileCopyUtils.copy(fileData, target); //(파일데이터를 타겟으로 저장)
		
		
		return fileName;
	}
	public String fileSave(String realPath, MultipartFile m) throws Exception{
		File f = new File(realPath);
		System.out.println(realPath);
		if(!f.exists()){
			f.mkdirs();
		}
//		String fileName = UUID.randomUUID().toString()+"_"+m.getOriginalFilename(); uuid로 이름 네이밍 하기
		Calendar ca = Calendar.getInstance(); // 현재시간을 밀리세컨드로 바꿔서 파일네임에 붙이기
		String fileName = ca.getTimeInMillis()+"_"+m.getOriginalFilename();
		File target = new File(f, fileName);
		m.transferTo(target);//파일 저장해주는것 매개변수는 타겟을 넣어주면 된다.

		return fileName;
	}
	
}
