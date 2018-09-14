package com.issimo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.issimo.web.bean.Msg;
import com.issimo.web.bean.UserInfo;
import com.issimo.web.service.UserService;

@Controller
@RequestMapping("/regist")
public class registerContoller {
	@Autowired
	UserService rs;
	
	@ResponseBody
	@RequestMapping("/re")	
	public Msg UserRegister(UserInfo ui) throws Exception{
		if(rs.CheckEmail(ui)){
			rs.register(ui);
			return Msg.success().add("status", "注册成功 请去激活！");
		}else{
			return Msg.success().add("status", "邮箱已存在！");
		}
		
		
	}
}
