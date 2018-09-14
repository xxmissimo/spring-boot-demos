package com.issimo.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issimo.web.bean.Evaluate;
import com.issimo.web.bean.EvaluateExample;
import com.issimo.web.dao.EvaluateMapper;

@Service
public class EvaluateService {
	@Autowired
	EvaluateMapper em;
	//插入留言
	public void InsertEvaMsg(Evaluate e){
		em.insertSelective(e);
	}
	
	//查询倒数10条留言
	public List<Evaluate> ShowLateEvaMsg(Evaluate e){
		EvaluateExample example=new EvaluateExample();
		EvaluateExample.Criteria criteria = example.createCriteria();
		criteria.andGoodsidEqualTo(e.getGoodsid());
		example.setOrderByClause("id desc");
		List<Evaluate> list=em.selectByExample(example);
		return list;
		
	}
	
}
