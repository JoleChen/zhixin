package cn.theblueearth.zhixin.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.theblueearth.zhixin.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-beans.xml"})
public class UserDaoTest {
	@Autowired
	private UserDao userDao;
	@Test
	public void test(){
		System.out.println("start testing....");
		
		userDao.insertUser(new User("张三"));
		
		List<User> users = userDao.findAllUsers();
		for(User user:users){
			System.out.println("the user's name:"+user.getName());
		}
	}
}
