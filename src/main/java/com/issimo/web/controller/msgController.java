package com.issimo.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.issimo.web.bean.Msg;
import com.issimo.web.bean.MsgInfo;
import com.issimo.web.service.MsgService;

@Controller
public class msgController {
	@Autowired
	MsgService msgService;
	
	@ResponseBody
	@RequestMapping("/addmsg")
	public Msg AddMsg(@RequestParam(value = "pn", defaultValue = "1") Integer pn,MsgInfo mi) {
		if(mi!=null){
			msgService.AddtoDB(mi);
		}
		PageHelper.startPage(pn,5);
		List<MsgInfo> mg=msgService.QueryDB();
		PageInfo<MsgInfo> page=new PageInfo<MsgInfo>(mg,5);
		System.out.println(page);
		return Msg.success().add("PageInfo", page);
		
		
	}
}
