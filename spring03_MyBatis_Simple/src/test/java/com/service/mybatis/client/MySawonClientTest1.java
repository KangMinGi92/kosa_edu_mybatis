package com.service.mybatis.client;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonClientTest1 {

	public static void main(String[] args) throws Exception {
		//사원 추가로직을 작성..
		//1. 폼에서 정보를 입력 받아야 하는데... 그냥
		MySawon pvo = new MySawon();
		pvo.setId("kosa");
		pvo.setPwd("1234");
		pvo.setName("james");
		pvo.setAge(32);
		
		//1.SqlMapConfig.xml읽어서 SqlSesssionFactory생성
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(r);
		
		//2.SqlSession...쿼리문을 실행하는 기능
		// insert, delete, update | select, selectOne
		SqlSession session=factory.openSession();
		
		//3.Session 기능을 사용
		session.insert("SawonMapper.sawonAdd",pvo);
		System.out.println(pvo.getName()+" 회원가입 성공^^");
		
		session.commit();
		session.close();
		
	}//main
	
}
