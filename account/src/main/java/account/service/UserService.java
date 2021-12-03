package account.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import account.dao.UserDAOJdbc;
import account.entity.User;
import account.exception.ExistedUserException;
import account.exception.PasswordException;
import account.exception.UserNameException;

@Service("userService")
public class UserService {
	@Resource(name = "userDAO")
	private UserDAOJdbc dao;

	//注册的时候查重
	public User checkUserName(String Name) throws ExistedUserException { 
		User user = dao.findByName(Name);
		if (user != null) {
			throw new ExistedUserException("existed");
		}
		return user;
	}
	
	//登录的时候，验证用户名与密码
	public User checkLogin(String Name, String password) 
			throws UserNameException, PasswordException {
		User user = dao.findByName(Name);
		if (user == null) {
			throw new UserNameException("没有这个用户名");
		} else if (!user.getPassword().equals(password)) {
			throw new PasswordException("密码错");
		}
		return user;
	}

	public void addUser(String Name, String Password, int Age, int Tender, String Telephone) {
		User u=new User();
		//u.setId(Id);  自动增长
		u.setPassword(Password);
		u.setName (Name);
		u.setAge(Age);
		u.setDate( new Date());
		u.setTelephone(Telephone);
		u.setTender(Tender);		
		dao.save(u);
	}

	
}
