package util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionFactory를 반환받는 코드
public class FactoryService {
	private static SqlSessionFactory factory = null;
	static {
		try {
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			factory=new SqlSessionFactoryBuilder().build(r);
		}catch(Exception e) {
			
		}
	}//static
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}

}
