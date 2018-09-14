package com.issimo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.issimo.web.bean.Msg;
import com.issimo.web.bean.UserInfo;
import com.issimo.web.service.UserService;

@Controller
public class ManageController {
	@Autowired
	UserService us;
	
	//查询所有用户
	
	@ResponseBody
	@RequestMapping("/showallmember")
	public Msg Showallmember(){
		
	List<UserInfo> ui=us.findall();						
		return Msg.success().add("PageInfo", ui);
	}
	
	
	@ResponseBody
	@RequestMapping("/delmember")
	public Msg delmember(UserInfo ui){
		System.out.println(ui.getUid());
		us.delmember(ui);
				
		return Msg.success().add("PageInfo", "该用户已删除！");
	}
	
}
