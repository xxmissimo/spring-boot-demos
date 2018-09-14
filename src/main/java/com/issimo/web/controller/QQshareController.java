package com.issimo.web.controller;

import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.issimo.web.bean.Msg;
import com.issimo.web.bean.QQspeed;
import com.issimo.web.service.QQshareService;

@Controller
public class QQshareController {

	@Autowired
	QQshareService qs;
	
	@ResponseBody
	@RequestMapping("/typein")
	public Msg TypeIn(QQspeed qq){
		//特么无语了 int类型 最长只能为2147483647 我还一直以为是正则表达式出错了
		return qs.TypeIn(qq);		
	}
	//查询所有数据
	@ResponseBody
	@RequestMapping("/queryall")
	public Msg QueryAll(){
		List<QQspeed> list=qs.QueryAll();
		ListIterator<QQspeed> li=list.listIterator();
		while(li.hasNext()){
			System.out.print(",\""+li.next().getQq()+"\"");
		}
		return Msg.success().add("PageInfo", list);
	}
	//查询id
	
	@ResponseBody
	@RequestMapping("/queryid")
	public Msg QueryId(QQspeed qq){	
		return qs.QueryId(qq);
	}
	
	
}
