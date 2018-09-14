package com.issimo.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.WriterException;
import com.issimo.web.bean.Msg;
import com.issimo.web.service.ExtraService;

@Controller
public class ExtraController {
	
	@Autowired
	ExtraService es;
	
	@ResponseBody
	@RequestMapping("/QRcode")
	public Msg GenerateQRcode(String content) throws WriterException, IOException{
		
		return Msg.success().add("PageInfo", es.GenerateQRcode(content));
		
	}
	
	
}
