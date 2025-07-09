package com.service.mybatis.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonClientTest3 {

	public static void main(String[] args) throws Exception {
		//1.SqlMapConfig.xml읽어서 SqlSesssionFactory생성
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(r);
		
		//2.SqlSession...쿼리문을 실행하는 기능
		//int insert, delete, update |List selectList, Object selectOne
		SqlSession session=factory.openSession();
		
		//3.Session 기능을 사용... delete()
		System.out.println(session.delete("SawonMapper.sawonDelete",3));
		session.selectList("SawonMapper.sawonList").forEach(c->System.out.println(c));
		session.commit();
		 
	}//main
	
}
