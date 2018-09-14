package com.issimo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.issimo.web.bean.Evaluate;
import com.issimo.web.bean.Msg;
import com.issimo.web.service.EvaluateService;

@Controller
public class EvaluateController {
	
	@Autowired
	EvaluateService es;
	//插入留言
	@RequestMapping("/InsertMsg")
	public void InsertEvaMsg(Evaluate e){
		if(e.getContent().contains("四川理工学院")){
			e.setContent("#$****@##@");
		}
		es.InsertEvaMsg(e);
		
	}
	//显示最新留言
	@ResponseBody
	@RequestMapping("/ShowlateMsg")
	public Msg ShowLateEvaMsg(Evaluate e){
	
	return Msg.success().add("PageInfo", es.ShowLateEvaMsg(e));
		
	}
}
