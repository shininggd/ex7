package com.choa.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.util.ListInfo;

@Service
public class MemoService {
	@Autowired
	private MemoDAO memoDAO;
	
	public List<MemoDTO> memoList(ListInfo listInfo)throws Exception{
		int count = memoDAO.count(listInfo);
		listInfo.makePage(count);
		listInfo.makeRow();
		return memoDAO.list(listInfo);
	}
	public MemoDTO memoView(int num)throws Exception{
		return memoDAO.view(num);
	}
	public int memoWrite(MemoDTO memoDTO)throws Exception{
		return memoDAO.insert(memoDTO);
	}
	public void memoUpdate(MemoDTO memoDTO)throws Exception{
		memoDAO.update(memoDTO);
	}
	public void memoDelete(int num)throws Exception{
		memoDAO.delete(num);
		
	}

}
