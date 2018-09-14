package com.issimo.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issimo.web.bean.GoodsInfo;
import com.issimo.web.dao.GoodsInfoMapper;

@Service
public class ShopService {
	@Autowired
	GoodsInfoMapper gim;
	
	public void SaveCar(GoodsInfo gi){	
		gim.insertSelective(gi);
		
	}

	public List<GoodsInfo> getAll() {		
		return gim.selectByExample(null);
		
	}
	
	public void  savetolib(GoodsInfo gi){
		gim.insertSelective(gi);
	}
	
}
