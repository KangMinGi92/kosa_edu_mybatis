package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import spring.service.dao.MemberDAO;

/*
 * FileName : HelloTestApp03UseSpring.java
 * ㅇ Hello.class 을 사용하는 Application
 * ㅇ Spring Framework 에서 제공하는 API를 사용하여 instance 생성
 * 		[[[ HelloTestApp02와 비교 ]]]
 * 		- hello.properties  ==> hello.xml
 * 		- HelloFactory ==> org.springframework.beans.factory.BeanFactory     
 
	==>	Spring Framework 은 다양한 메타데이터 중  xml 을 일반적으로 사용하며,
	  		instance 생성, 초기화, 객체의 상호 관계를  xml 에 선언적으로 기술. 
	 		( 사용자는Meta-Data 만 변경,수정 만으로 code 의  수정없이 instance 를 가능)
		
			<bean id="hello" class="spring.services.hello.Hello"/>
			
	==> 	HelloFactory :  Hello Data type 만 관리 하는 Factory 
	==> Spring Framework :모든 Data Type(Bean/POJO) 생성관리하는 Factory
 */
public class DAOTestApp04UseSpring {

	/// main method
	public static void main(String[] args) {
		
		//1. DI Container
		ClassPathXmlApplicationContext factory =
				new ClassPathXmlApplicationContext("/config/dao.xml");
		System.out.println("1-----------BeanFactory 주문서 읽어들임....");
		//2. Container 로 부터 hello 의 name 을 갖는 instance return 받기  
		System.out.println("2-----------getBean()으로 빈 찾아옴....");
		MemberDAO dao = (MemberDAO)factory.getBean("dao");
		
		System.out.println("3-----------비지니스로직 호출....");
		dao.resgister("kosa", "강민기");
		dao.delete("kosa");
	}
	
}//end of class