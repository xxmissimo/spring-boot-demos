package com.issimo.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.issimo.web.bean.Msg;

@Controller
public class SessionController {
	
	@ResponseBody
	@RequestMapping("/ses")
	public Msg Testsession(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		
	
		  
		
		//System.out.println(sessionId);
		 if (session.isNew()) {
			 System.out.println("session创建成功，session的id是："+sessionId);
			 session.setAttribute("data", "孤傲苍狼");
		 }else {
		    	System.out.println("服务器已经存在该session了，session的id是："+sessionId);
		   System.out.println(session.getAttribute("data"));
		 }
		return Msg.success().add("PageInfo", "sessionId").add("login", "true");
	}
	
	
}
