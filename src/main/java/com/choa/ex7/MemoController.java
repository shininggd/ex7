package com.choa.ex7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choa.memo.MemoService;

@Controller
@RequestMapping(value="/memo/**")
public class MemoController {
	@Autowired
	private MemoService memoService;
	//list
	@RequestMapping(value="memoList")
	public void memoList(){

		
	}
	

}
