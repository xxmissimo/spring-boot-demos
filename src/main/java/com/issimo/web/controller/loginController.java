package com.issimo.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.issimo.web.bean.Msg;
import com.issimo.web.bean.UserInfo;
import com.issimo.web.service.UserService;

@Controller
public class loginController {
	@Autowired
	UserService us;
	
	@ResponseBody
	@RequestMapping("/login")
	public Msg login(UserInfo ui,HttpServletRequest request){		
			//判断登陆状态
		if(us.checkUser(ui)){
			//成功就创建/获取会话，并检查会话是否存在		
			HttpSession session = request.getSession();
			String sessionId = session.getId();
				 if (session.isNew()) {
					 //这是做  重复登录保存在session  
					 System.out.println("已创建会话，把Email保存到sesion，");
					 session.setAttribute("data", ui.getEmail());
				 }else {
				   System.out.println("您已经登陆："+sessionId);
				   System.out.println(session.getAttribute("data"));
				   return Msg.fail().add("login", "此账号已登录").add("account", "null");
				 }
				 return Msg.success().add("login", "true").add("account", ui.getEmail());
		}
	return Msg.fail().add("login", "false").add("account", "null");
	}
	
}
