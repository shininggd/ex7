package com.choa.file;

import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class Download extends AbstractView {//일반 클래스가 아닌 view 객체를 만들어야해서
											//AbstractView를 상속해야한다
	
	public Download() {
		//어떤애를 다운로드에 연결하는 역활을 하는 클래스다
		setContentType("application/download;charset=UTF-8");//헤더파일이 올시 어떠한 일을 하게할지
	}
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//modelandview를 model에 넣는다
		File f = (File)model.get("downloadFile");
		response.setCharacterEncoding(getContentType());
		response.setContentLength((int)f.length());//파일크기
		String fileName = URLEncoder.encode(f.getName(), "UTF-8") ; //파일이름을 가져오되 UTF-8로 해야한다(깨질수있으니)
		response.setHeader("Content-Disposition", "attachment;");
		
	
		
	}

}
