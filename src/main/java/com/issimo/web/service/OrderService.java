package com.issimo.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issimo.web.bean.Order;
import com.issimo.web.bean.OrderExample;
import com.issimo.web.bean.OrderExample.Criteria;
import com.issimo.web.dao.OrderMapper;

@Service
public class OrderService {
	@Autowired
	OrderMapper om;
	
	//通过卖家查询
	public List<Order>SelectByShipper(Order or){
		OrderExample example=new OrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andShipperEqualTo(or.getShipper());
		List<Order> list=om.selectByExample(example);
		return list;
		
	}
	//通过买家查询
	public List<Order> SelectByReceiver(Order or){
		OrderExample example=new OrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andReceiverEqualTo(or.getReceiver());
		List<Order> list=om.selectByExample(example);
		return list;
	}
	//新增订单
	public void InsertOrder(Order or){
		or.setState("0");
		om.insertSelective(or);
	}
	//删除订单
	public void DelOrder(Order or){
		om.deleteByPrimaryKey(or.getId());
	}
}
