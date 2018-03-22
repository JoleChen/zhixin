package cn.theblueearth.zhixin;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.theblueearth.zhixin.dao.UserDao;
import cn.theblueearth.zhixin.model.User;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("application-beans.xml");

		UserDao userDao = 
	      (UserDao)context.getBean("userDao");

	      System.out.println("------Records Creation--------" );
	      userDao.insertUser(new User("Maxsu"));
	      userDao.insertUser(new User("Allen"));

	      System.out.println("------Listing Multiple Records--------" );
	      List<User> users = userDao.findAllUsers();
	      for (User user : users) {
	         System.out.print("ID : " + user.getId() );
	         System.out.print(", Name : " + user.getName() );
	      }  
	}

}
