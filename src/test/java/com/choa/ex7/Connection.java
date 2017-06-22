package com.choa.ex7;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Connection extends MyAbstractTestUnit {
	@Inject
	private SqlSession sqlSession;
	@Test
	public void test() {
		assertNotNull(sqlSession);
	}

}
