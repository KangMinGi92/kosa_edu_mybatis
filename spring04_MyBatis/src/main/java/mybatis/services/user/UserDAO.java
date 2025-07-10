package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

/*
 * 	비지니스로직 템플릿...기술
 * ~maaping10.xml에 있는 쿼리id가 비지니스로직 함수명
 * addUser,updateUser,removeUser,getUser, getUserList
 */
public interface UserDAO {
	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	int removeUser(String userId) throws Exception;
	
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
