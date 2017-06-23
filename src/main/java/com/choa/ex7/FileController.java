package com.choa.ex7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.choa.file.FileDTO;
import com.choa.file.FileService;
import com.choa.file.MultiFileDTO;
import com.choa.file.SameMultiFileDTO;

@Controller
@RequestMapping(value="/file/**")
public class FileController {

	@RequestMapping(value="fileUpload", method=RequestMethod.GET)
	public void fileUpload(){

	}
	//다중 파일 업로드 - 파라미터 이름이 다를 고 갯수가 고정일때
	//1. DTO를 만들어서 한다잉
	/*@RequestMapping(value="multiFileUpload",method=RequestMethod.POST )
	public void multiFileUpload(MultiFileDTO multiFileDTO){
		System.out.println(multiFileDTO.getF1().getOriginalFilename() + " [][][] " + multiFileDTO.getF2().getOriginalFilename());

	}*/
	//2. MultipartFile 자체로 받기
	/*@RequestMapping(value="multiFileUpload",method=RequestMethod.POST )
	public void multiFileUpload(MultipartFile f1, MultipartFile f2){
		System.out.println(f1.getOriginalFilename() + " [2][2][2] " + f2.getOriginalFilename());

	}*/
	//3. Request를 이용해서 받기
	/*@RequestMapping(value="multiFileUpload",method=RequestMethod.POST )
	public void multiFileUpload(MultipartHttpServletRequest request){
		MultipartFile f1 = request.getFile("f1");
		MultipartFile f2 = request.getFile("f2");
		System.out.println(f1.getOriginalFilename() + " [3][3][3] " + f2.getOriginalFilename());
	}*/
	//다중 파일이지만 같은 이름의 파라미터를 받을때 -> 배열로 받는다

	//1.DTO 매개변수중 멀티파일을 배열형
	/*@RequestMapping(value="sameMultiFileUpload",method=RequestMethod.POST )
	public void sameMultiFileUpload(SameMultiFileDTO multiFileDTO){
		for(int i = 0 ; i < multiFileDTO.getF1().length ; i++){
			System.out.println(multiFileDTO.getF1()[i].getOriginalFilename());
		}
		System.out.println("No2");

	}*/
	//2. 배열형 MultiFile
	/*	@RequestMapping(value="sameMultiFileUpload",method=RequestMethod.POST )
	public void sameMultiFileUpload(MultipartFile [] f1){
		for(int i = 0 ; i < f1.length ; i++){
			System.out.println(f1[i].getOriginalFilename());
		}

	}*/
	//3. Request로 받기
	/*@RequestMapping(value="sameMultiFileUpload",method=RequestMethod.POST )
	public void sameMultiFileUpload(MultipartHttpServletRequest request){
		//tip)request.getFileNames() 파라미터 이름을 모를때 사용 ( 이름을 꺼내온다)
		List<MultipartFile> ar = request.getFiles("f1");
		for(MultipartFile f: ar ){
			System.out.println(f.getOriginalFilename()+"리퀘스트 향상된 포문 ~~");
		}


	}*/
	//다중파일 업로드★★★★★★ -- 파라미터 이름을 모르거나 갯수가 유동적일때★★★★★★★
	/*@RequestMapping(value="upload",method=RequestMethod.POST )
	public void upload(MultipartHttpServletRequest request){
		Iterator<String> it =request.getFileNames();
		ArrayList<MultipartFile> ar = new ArrayList<MultipartFile>();
		while(it.hasNext()){
			System.out.println(it.next());
			MultipartFile m = request.getFile(it.next());
			ar.add(m);
		}
		for(MultipartFile m : ar){
			System.out.println("뚜스따스뚜스"+m.getOriginalFilename());
		}
	}*/




	/*//단일 파일 업로드
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public void fileUpload(MultipartHttpServletRequest request){


	}
	public void fileUpload(MultipartFile f1){

	}
	public void fileUpload(FileDTO fileDTO){

	}//*/
/////////////////////////////////////////////////////////////////////////////////////////////////////실전, 추가하기
	@RequestMapping(value="upload",method=RequestMethod.POST )
	public ModelAndView fileUpload(MultipartFile f1, HttpSession session) throws Exception{
		FileService fileService = new FileService();// 귀찮으니까 서비스 inject 안하고 걍 만듬
		String fileName = fileService.fileSave(f1, session);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("file/fileView");
		mv.addObject("fileName", fileName);
		mv.addObject("oriName", f1.getOriginalFilename());
		return mv;
	}
	////////////////////////////////////////////////////////////////////////////////////////////DB 뿐만 아니라 실제 파일 삭제
	@RequestMapping(value="fileDelete",method=RequestMethod.GET)
	public void fileDelete(String fileName, HttpSession session)throws Exception{
		FileService fileService = new FileService();
		if(fileService.fileDelete(fileName, session)){
			System.out.println("성공");
		}else{
			System.out.println("실패");
		}
		
		
	}
	
}
