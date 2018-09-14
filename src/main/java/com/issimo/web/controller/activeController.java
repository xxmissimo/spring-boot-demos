package com.issimo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.issimo.web.bean.UserInfo;
import com.issimo.web.service.UserService;


@Controller
public class activeController {
	@Autowired
	UserService rs;
	
	@RequestMapping("/active")
	public String ActiveUser(String code) throws Exception{
		UserInfo user=rs.findByCode(code);
		
		if(user!=null){
			//如果存在 就激活
			user.setState(1);  
			user.setCode(null);
			rs.update(user);
			return "suc";
		}else {
			return "Reactive";
		}
		
	}
}
