package com.issimo.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issimo.web.bean.ShowForgoods;
import com.issimo.web.bean.ShowForgoodsExample;
import com.issimo.web.bean.ShowForgoodsExample.Criteria;
import com.issimo.web.dao.ShowForgoodsMapper;

@Service
public class GoodsService {
	@Autowired
	ShowForgoodsMapper sfm;
	public void InsertGoods(ShowForgoods sf){
		sfm.insertSelective(sf);
	}
	//卖家
	public List<ShowForgoods> SelectBySeller(ShowForgoods sf){
		ShowForgoodsExample example=new ShowForgoodsExample();
		Criteria criteria = example.createCriteria();
		criteria.andSellerEqualTo(sf.getSeller());
		List<ShowForgoods> list=sfm.selectByExample(example);
		return list;
		
	}
	//查询全部
	public List<ShowForgoods> ShowGoodsInfo(){
		return sfm.selectByExample(null);
	}
	//主键
	public ShowForgoods SelectByid(ShowForgoods sf){
		return sfm.selectByPrimaryKey(sf.getId());
	}
	//通过类型查询
	public List<ShowForgoods> SelectByType(ShowForgoods sf){
		ShowForgoodsExample example=new ShowForgoodsExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(sf.getType());
		List<ShowForgoods> list=sfm.selectByExample(example);		
		return list;
		
		
	}
}
