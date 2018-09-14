package com.issimo.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issimo.web.bean.Msg;
import com.issimo.web.bean.QQspeed;
import com.issimo.web.bean.QQspeedExample;
import com.issimo.web.bean.QQspeedExample.Criteria;
import com.issimo.web.dao.QQspeedMapper;

@Service
public class QQshareService {

	@Autowired
	QQspeedMapper qsm;
	
	//录入QQ号并检查是否重复
	public Msg TypeIn(QQspeed qq){
		//检查格式是否正确  算了 前台js校验  不管了！
		
		//查询是否重复录入
		QQspeedExample example=new QQspeedExample();
		Criteria criteria = example.createCriteria();
		criteria.andQqEqualTo(qq.getQq());
		List<QQspeed> list =qsm.selectByExample(example);
		//如果查询不到此条QQ
		if(null == list || list.size() ==0 ){
			//录入QQ
			qsm.insertSelective(qq);
			return Msg.success().add("PageInfo", "录入成功！");			
		}else{
			return Msg.fail().add("PageInfo", "请勿重复录入");
		}				
	}
	//查询是否录入 并返回id
	public Msg QueryId(QQspeed qq){
		QQspeedExample example=new QQspeedExample();
		Criteria criteria = example.createCriteria();
		criteria.andQqEqualTo(qq.getQq());
		List<QQspeed> list =qsm.selectByExample(example);	
		if(null == list || list.size() ==0 ){
			return Msg.fail().add("PageInfo", "此QQ尚未录入！");				
		}else{			
			return Msg.success().add("PageInfo", list);
		}												
	}
	
	//查询所有数据
	public List<QQspeed> QueryAll(){
		return qsm.selectByExample(null);		
	}
	
	
}
