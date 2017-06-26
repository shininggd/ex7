package com.choa.ex7;

import java.util.List;

import javax.xml.ws.Service.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

@Controller
@RequestMapping(value="/memo/**")
public class MemoController {
	@Autowired
	private MemoService memoService;
	//list
	@RequestMapping(value="memoList")
	public void memoList(){

		
	}
	@RequestMapping(value="getMemoList")
	public void memoList(ListInfo listInfo, Model model) throws Exception{
		List<MemoDTO> list = memoService.memoList(listInfo);
		model.addAttribute("list", list);
		
	}
	@RequestMapping(value="memoWrite" ,method=RequestMethod.POST)
	public String memoWrite(MemoDTO memoDTO,Model model) throws Exception{
		int result = memoService.memoWrite(memoDTO);
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);
		
		List<MemoDTO> list =memoService.memoList(listInfo);
		model.addAttribute("list", list);
		return "memo/getMemoList";
	}
	

}
