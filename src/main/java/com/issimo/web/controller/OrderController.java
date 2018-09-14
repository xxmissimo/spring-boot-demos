package com.issimo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.issimo.web.bean.Msg;
import com.issimo.web.bean.Order;
import com.issimo.web.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService os;
	
	//通过卖家查询
	@ResponseBody
	@RequestMapping("/byshipper")
	public Msg SelectByShipper(Order or){
	return Msg.success().add("PageInfo",os.SelectByShipper(or) );
		
	}
		
	//通过收货人查询
	@ResponseBody
	@RequestMapping("/byreceiver")
	public Msg SelectByReceiver(Order or){
	return Msg.success().add("PageInfo",os.SelectByReceiver(or) );
			
	}
	//添加订单
	@ResponseBody
	@RequestMapping("/proorder")
	public Msg ProduceOrder(Order or){
		os.InsertOrder(or);
		return Msg.success().add("PageInfo", "增加成功");
	}
	//订单删除
	@RequestMapping("/delorder")
	public void DelOrder(Order or){
		os.DelOrder(or);
	}
}
