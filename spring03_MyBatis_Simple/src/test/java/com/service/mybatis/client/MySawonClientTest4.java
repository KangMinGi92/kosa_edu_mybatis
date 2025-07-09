package com.service.mybatis.client;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.service.mybatis.vo.MySawon;

import util.FactoryService;

public class MySawonClientTest4 {

	public static void main(String[] args) throws Exception {
		//사원 추가로직을 작성..
		//1. 폼에서 정보를 입력 받아야 하는데... 그냥
		MySawon pvo = new MySawon();
		pvo.setNum(4);
		pvo.setId("kosa");
		pvo.setPwd("1234");
		pvo.setName("Tomas");
		pvo.setAge(33);
		
		//1.FactoryService에서 SqlMapConfig.xml읽어서 SqlSesssionFactory생성
		SqlSessionFactory factory=FactoryService.getFactory();
		//2.SqlSession...쿼리문을 실행하는 기능
		// insert, delete, update | select, selectOne
		SqlSession session=factory.openSession();
		
		//3.Session 기능을 사용
		int row = session.update("SawonMapper.sawonUpdate",pvo);
		System.out.println(row+"명 정보 수정=>"+pvo.getName()+" 회원정보 수정 성공^^");
		
		session.commit();
		session.close();
		
	}//main
	
}
