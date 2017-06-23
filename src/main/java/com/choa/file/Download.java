package com.choa.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
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
		fileName = fileName.substring(fileName.lastIndexOf("_")+1);

		//String oriName = (String)model.get("oriName");
		
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");//파일 이름 정해주는 곳
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream(); // socket 생각해라 서버에서 보낸다 output
													   //  어디서 정보얻냐? response
		
		FileInputStream fi = null;
		
		fi = new FileInputStream(f);
		
		FileCopyUtils.copy(fi, out);
		
		fi.close();
		out.close();
		
	
		
	}

}
