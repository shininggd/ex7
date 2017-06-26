package com.choa.memo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.util.ListInfo;

@Service
public class MemoService {
	@Autowired
	private MemoDAO memoDAO;
	
	public void memoList(ListInfo listInfo)throws Exception{
		int count = memoDAO.count(listInfo);
		listInfo.makePage(count);
		listInfo.makeRow();
		memoDAO.list(listInfo);
	}
	public void memoView(int num)throws Exception{
		memoDAO.view(num);
	}
	public void memoWrite(MemoDTO memoDTO)throws Exception{
		memoDAO.insert(memoDTO);
	}
	public void memoUpdate(MemoDTO memoDTO)throws Exception{
		memoDAO.update(memoDTO);
	}
	public void memoDelete(int num)throws Exception{
		memoDAO.delete(num);
		
	}

}
