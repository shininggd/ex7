package com.choa.ex7;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.choa.memo.MemoDAO;




public class DtoTest extends MyAbstractTestUnit {
	@Autowired
	private MemoDAO dao;
	
	@Test
	public void test() throws Exception{
		assertNotNull(dao.view(1));
		
		
	}
	
	

}
