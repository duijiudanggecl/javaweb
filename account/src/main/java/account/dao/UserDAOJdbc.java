package account.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import account.entity.User;

@Repository("userDAO") 
public class UserDAOJdbc {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate template;

	//保存数据到数据库---注册
	public void save(User user) {
		//1.
		String sql = "insert into user values(null,?,?,?,?,?,?)";
		
		//2.
		Object[] params = new Object[]{
				user.getName(),
				user.getTelephone(),
				user.getTender(),
				user.getAge(),
				user.getDate(),
				user.getPassword(),			
				//user.getId(),

		};
				
		//3.
		template.update(sql,params);
	}
	
	
	private class UserRowMapper implements RowMapper<User>{
		//4.
		public User mapRow(ResultSet rs, int index) 
				throws SQLException {
			User u = new User();
			u.setId(rs.getInt("Id"));
			u.setPassword(rs.getString("Password"));
			u.setName (rs.getString("Name"));
			u.setAge(rs.getInt("Age"));
			u.setDate(rs.getDate("Date"));
			u.setTelephone(rs.getString("Telephone"));
			u.setTender(rs.getInt("Tender"));		
			return u;
		}
	}
	
	//通过名字查找信息 
	public User findByName(String Name) {
		//1.
		String sql = "select * from user where Name= ?";
		//2.
		Object[] params = new Object[]{Name};
		//3.ִ
		return template.queryForObject(sql, params ,new UserRowMapper());
	}
	
	
}
