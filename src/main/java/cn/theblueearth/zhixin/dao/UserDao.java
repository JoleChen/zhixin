package cn.theblueearth.zhixin.dao;

import java.util.List;

import cn.theblueearth.zhixin.model.User;

public interface UserDao {
	List<User> findAllUsers();
	
	User findUserById(Long id);
	
	void insertUser(User user);
}
