package com.service.spring.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.dao.ItemDAO;

public class DAOUnitTest2 {

	public static void main(String[] args) throws Exception {
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		ItemDAO dao = new ItemDAO();
		dao.setSqlSession(session);
		
		System.out.println(dao.getItem(1111));
		System.out.println("=====================================");
		dao.getItemList().forEach(c-> System.out.println(c));
		
	}

}
