package com.choa.memo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.util.ListInfo;

@Repository
public class MemoDAO {
	@Autowired
	private SqlSession sqlSession;
	private  final String NAMESAPCE = "MemoMapper.";
	
	//count
	public int count(ListInfo listInfo) throws Exception{
		return sqlSession.selectOne(NAMESAPCE+"count", listInfo);
		
	}
	
	//LIST
	public List<MemoDTO> list(ListInfo listInfo) throws Exception{
		
		return sqlSession.selectList(NAMESAPCE+"list", listInfo);
	}
	
	//INSERT
	public int insert(MemoDTO memoDTO) throws Exception{
		return sqlSession.insert(NAMESAPCE+"write", memoDTO);
	}
	
	//VIEW
	public MemoDTO view(int num) throws Exception{
		return sqlSession.selectOne(NAMESAPCE+"view", num);
	}
	//UPDATE
	public int update(MemoDTO memoDTO) throws Exception{
		return sqlSession.update(NAMESAPCE+"update", memoDTO);
	}
	
	//DELETE
	public int delete(int num) throws Exception{
		return sqlSession.delete(NAMESAPCE+"delete", num);
	}
	
}
