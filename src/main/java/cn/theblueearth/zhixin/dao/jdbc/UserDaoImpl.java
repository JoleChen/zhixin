package cn.theblueearth.zhixin.dao.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.theblueearth.zhixin.dao.UserDao;
import cn.theblueearth.zhixin.model.User;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public User findUserById(Long id) {
		String sql = "select * from sys_user where id=?";
		List<User> users = jdbcTemplate.query(sql, new Object[]{id},new BeanPropertyRowMapper<User>(User.class));
		if(users==null || users.size()==0){
			return null;
		}
		return users.get(0);
	}

	public void insertUser(User user) {
		String sql = "insert into sys_user(name) values(?)";
		jdbcTemplate.update(sql, user.getName());
	}

	public List<User> findAllUsers() {
		String sql = "select * from sys_user";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}

}
