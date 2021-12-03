package account.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import account.entity.Result;
import account.entity.User;
import account.exception.ExistedUserException;
import account.exception.PasswordException;
import account.exception.UserNameException;
import account.service.UserService;
import account.util.DegistUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService service;
	
	//Ajax调用返回   注册的时候 用户名查重
	@RequestMapping("/validName.do")
	@ResponseBody  //不返回视图，返回字符串
	public Result validName(String Name){
		Result result = new Result();
		try {
			User u = service.checkUserName(Name);
			result.setStatus(1); //
			result.setMsg("用户名可用");
		} catch (ExistedUserException e) {
			result.setStatus(0); //
			result.setMsg("用户名已被占用");
		}
		return result;
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "../index";       //登陆成功后的页面
	}
	
	// 登陆功能
	@RequestMapping("/login.do")
	public String login(String Name, String Password, HttpSession session, ModelMap model) {
		try {

			System.out.println(Name);
			System.out.println(Password);
			// String pwd = DegistUtil.produceDegistCode(Password.toLowerCase()); //转为小写统一处理
			String pwd = Password;
			User u = service.checkLogin(Name, pwd);
			session.setAttribute("username", u.getName());
			return "redirect:toIndex.do"; // 验证正确
		} catch (UserNameException e) {
			model.addAttribute("message", e.getMessage());
			return "error"; // 用户名错误
		} catch (PasswordException e) {
			model.addAttribute("message", e.getMessage());
			return "error"; // 密码错误
		}
	}


	@RequestMapping("/registe.do")   //注册功能
	public String registe(HttpSession session, String name,
			String pwd, int gender,int telephone,int age,){
		
		String pwd = DegistUtil.produceDegistCode(pwd.toLowerCase());  //转为小写统一处理
		service.addUser(String name, String pwd, int age, int Tender, String telephone);
		session.setAttribute("username", nickname);
		
		return "redirect:toIndex.do";  //注册完成
	}

	


	
}