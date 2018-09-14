package com.issimo.web.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.zxing.WriterException;
import com.issimo.web.utils.ZxingQRcodeUtils;

@Service
public class ExtraService {
	
	public String GenerateQRcode(String content) throws WriterException, IOException{
		
		//生成二维码
		return ZxingQRcodeUtils.ZxingQRcode(content);
	}
}
