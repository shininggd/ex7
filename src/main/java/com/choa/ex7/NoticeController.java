 package com.choa.ex7;




import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeServiceImpl;
import com.choa.util.ListInfo;


@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Inject
	private NoticeServiceImpl noticeService;
	
		
	//list
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public String noticeList(Model model, ListInfo listInfo) throws Exception{
		System.out.println(listInfo.getCurPage());
		List<BoardDTO> ar = noticeService.boardList(listInfo);
		model.addAttribute("list", ar);
		model.addAttribute("board", "notice");
		model.addAttribute("listInfo", listInfo);
		return "board/boardList";
	}
	
	//View
	@RequestMapping(value="noticeView", method=RequestMethod.GET)
	public String noticeView(Integer num, Model model) throws Exception{
		BoardDTO noticeDTO=noticeService.boardView(num);
		model.addAttribute("dto", noticeDTO);
		model.addAttribute("board", "notice");
		return "board/boardView";
	}
	
	//writeForm
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public String noticeWrite(Model model){
		model.addAttribute("path", "Write");
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	
	//write 
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO, RedirectAttributes rd,Model model)throws Exception{
		int result=noticeService.boardWrite(noticeDTO);
		String message = "FAIL";
		if(result>0){
			message="SUCCESS";
		}
		rd.addFlashAttribute("message", message);
		model.addAttribute("board", "notice");
		return "redirect:noticeList?curPage=1";
	}
	
	//update
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public String noticeUpdate(Integer num, Model model) throws Exception{
		BoardDTO noticeDTO = noticeService.boardView(num);
		model.addAttribute("dto", noticeDTO);
		model.addAttribute("board", "notice");
		model.addAttribute("path", "Update");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO, RedirectAttributes rd,Model model) throws Exception{
		int result = noticeService.boardUpdate(noticeDTO);
		String message = "FAIL";
		if(result>0){
			message="SUCCESS";
		}
		model.addAttribute("board", "notice");
		rd.addFlashAttribute("message", message);
		return "redirect:noticeList?curPage=1";
	}
	
	@RequestMapping(value="noticeDelete", method=RequestMethod.GET)
	public String noticeDelete(Integer num)throws Exception{
		int result = noticeService.boardDelete(num);
		return "redirect:noticeList?curPage=1";
	}
	
	
	
}
