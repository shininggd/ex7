package com.choa.ex7;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDAOImpl;


public class DtoTest extends MyAbstractTestUnit {
	@Autowired
	private NoticeDAOImpl noticeDAOImpl;
	
	@Test
	public void test() throws Exception{
		BoardDTO dto = noticeDAOImpl.boardView(153);
		assertNotNull(dto);
		
		
	}
	

}
