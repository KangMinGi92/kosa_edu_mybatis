package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.Item;

public class MyBatisUnitTest2 {
	public static void main(String[] args) throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
	SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
	SqlSession session = factory.openSession();
	
	//~mapping.xml의 쿼리문이 잘 작성되었는지는
	//session 함수를 호출해서 확인
	List<Item> list=session.selectList("ns.sql.FruitMapper.getItemList");
	for(Item item : list)
		System.out.println(item);
	
	System.out.println("===================================");
	Item item=session.selectOne("ns.sql.FruitMapper.getItem",1111);
	System.out.println(item);
	}
}
