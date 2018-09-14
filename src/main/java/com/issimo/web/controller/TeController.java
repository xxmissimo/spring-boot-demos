package com.issimo.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeController {
	
	@ResponseBody
	@RequestMapping("/test")
	private Map<String, Integer> testc() {
		System.out.println("it oK");
		Map<String,Integer> mp=new HashMap<String, Integer>();
		mp.put("name", 1);
		return mp;
	}
}
