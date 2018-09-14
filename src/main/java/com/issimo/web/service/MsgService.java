package com.issimo.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issimo.web.bean.MsgInfo;
import com.issimo.web.dao.MsgInfoMapper;

@Service
public class MsgService {
	
	@Autowired
	MsgInfoMapper mim;
	public void AddtoDB(MsgInfo ms){
		mim.insertSelective(ms);
		
		
	}
	public  List<MsgInfo> QueryDB(){
		return mim.selectByExample(null);
	}
}
