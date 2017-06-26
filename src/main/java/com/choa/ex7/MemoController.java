package com.choa.ex7;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

@Controller
@RequestMapping(value="/memo/**")
//@RestController: @controller 대신 이걸 하면 하단 모든 메소드가 responsebody 효과가 적용된다.
public class MemoController {
	@Autowired
	private MemoService memoService;
	//list
	@RequestMapping(value="memoList")
	public void memoList(){

		
	}
	@RequestMapping(value="getMemoList")
	@ResponseBody
	public List<MemoDTO> memoList(ListInfo listInfo, Model model) throws Exception{
		List<MemoDTO> list = memoService.memoList(listInfo);
		
		return list;
		
		
	}
	@RequestMapping(value="memoWrite" ,method=RequestMethod.POST)
	public String memoWrite(MemoDTO memoDTO,Model model) throws Exception{
		memoService.memoWrite(memoDTO);
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);
		
		List<MemoDTO> list =memoService.memoList(listInfo);
		model.addAttribute("list", list);
		return "memo/getMemoList";
	}
	
	@RequestMapping(value="memoView")
	@ResponseBody
	public MemoDTO memoView(int num)throws Exception{
		MemoDTO memoDTO = memoService.memoView(num);
		return memoDTO;
	}
	

}
