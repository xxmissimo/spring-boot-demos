package com.issimo.web.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ZxingQRcodeUtils {
	public static String ZxingQRcode(String content) throws WriterException, IOException{ 
		int width = 300;//定义图片宽度 
		int height = 300;//定义图片高度 
		String format ="png";//定义图片格式 
		//String content ="www.issimo-二手交易.com";//定义二维码内容 //定义二维码参数 
		@SuppressWarnings({ "rawtypes" })
		HashMap<EncodeHintType, Comparable> hints = new HashMap<EncodeHintType, Comparable>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//设置编码 //设置容错等级，等级越高，容量越小
		hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M); 
		hints.put(EncodeHintType.MARGIN,2);//设置边距 //生成矩阵 
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE, width, height); //设置路径 
		//UUid生成二维码名称 避免重复
		String ZxingQrCodeName =UUIDUtils.get8UUID()+".png";
		Path file = new File("E:/Users/"+ZxingQrCodeName).toPath();
		MatrixToImageWriter.writeToPath(bitMatrix, format, file);//输出图像 }
		//返回图片的路径
		return "E:/Users/"+ZxingQrCodeName;
	}
}
