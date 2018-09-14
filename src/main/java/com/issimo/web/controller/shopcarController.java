package com.issimo.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.issimo.web.bean.GoodsInfo;
import com.issimo.web.bean.Msg;
import com.issimo.web.service.ShopService;

@Controller
public class shopcarController {
	@Autowired
	ShopService ss;
	
	
	@RequestMapping("/addtocar")
	public String addToCar(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model) {
		PageHelper.startPage(pn,5);
		List<GoodsInfo> emps=ss.getAll();
		
		PageInfo<GoodsInfo> page=new PageInfo<GoodsInfo>(emps,5);
		model.addAttribute("pageInfo", page);
		
		
		return "list";
	}
	
	//把发布的商品 保存到库
	@RequestMapping("/addtolib")
	public void addtolib(GoodsInfo gi){
		//System.out.println(gi.getGoodsName()+gi.getGoodsInfo()+gi.getGoodsPrices());
		ss.savetolib(gi);								
	}
	
	@ResponseBody
	@RequestMapping("/showdata")
	public 	Msg showdata(){			
		List<GoodsInfo> alldata=ss.getAll();				
				return  Msg.success().add("PageInfo", alldata);
	}
	
}
