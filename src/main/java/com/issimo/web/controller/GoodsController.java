package com.issimo.web.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.issimo.web.bean.Msg;
import com.issimo.web.bean.ShowForgoods;
import com.issimo.web.service.GoodsService;
import com.issimo.web.utils.UUIDUtils;

@Controller
public class GoodsController {
	@Autowired
	GoodsService gs;
	
	@RequestMapping("/publis")
	public void PublisGoods(HttpServletRequest request, HttpServletResponse response) throws IOException{
		 request.setCharacterEncoding("UTF-8");
	     response.setContentType("text/html;charset=UTF-8");
		DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();		
		ServletFileUpload fileUpload=new ServletFileUpload(diskFileItemFactory);
		try {
			//解析一下客户端上传来的数据
			@SuppressWarnings("unchecked")
			List<FileItem> fileItems=fileUpload.parseRequest(request);
			//迭代器  遍历
			Iterator<FileItem> iterator=fileItems.iterator();
			ShowForgoods sf=new ShowForgoods();
			while (iterator.hasNext()) {
				FileItem fileItem=iterator.next();
				
				///判断是否为表单数据
				if (fileItem.isFormField()) {
					//文本数据
					//s你的文本框中的数据
					String s=fileItem.getString();
					//进行编码解码   这一步就很重要
					s = URLEncoder.encode(s, "ISO-8859-1");
					s= URLDecoder.decode(s, "UTF-8");
					//你的文本框的名字
					String fieldName=fileItem.getFieldName();
					
					//直接入库
//					封装数据
					if (fieldName.equals("name")) {
						sf.setName(s);
						//System.out.println(s);
					}
					
					if (fieldName.equals("price")) {
						
						sf.setPrice(Integer.parseInt(s));
					}
					if (fieldName.equals("type")) {
						sf.setType(s);
					}
					if (fieldName.equals("info")) {
						sf.setInfo(s);
					}
					
					//还有一步没做 那就是保存发货人啊
					if (fieldName.equals("seller")) {
						sf.setSeller(s);
					}
					
				}else {
					//文件数据
//					String s=fileItem.getString();
					@SuppressWarnings("unused")
					String fieldName=fileItem.getFieldName();
					//文件名
					String name=fileItem.getName();
					 String suffix = name.substring(name.lastIndexOf("."));
					//修改文件名称 避免重复
					name=UUIDUtils.get8UUID()+suffix;
					
				
					
					//写入磁盘  然后路径入库
					
					//得到你的tomcat的路径  这个在ssm里面不一样 搞了好久
					File file=new File(request.getSession().getServletContext().getRealPath("/")+"images/"+name);
					//System.out.println(file.getAbsolutePath());
					//判断你的file的父路径是否存在
					if (!file.getParentFile().exists()) {
						//如果不存在，创建之
						file.getParentFile().mkdirs();
					}
					//创建你的文件
					//mkdirs创建文件夹    createnewfile创建文件
					file.createNewFile();
					
					//把你的fileitem中的数据写入file中
					try {
						fileItem.write(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
					//	video.setDiskUrl(file.getAbsolutePath());
					//video.setNetUrl("http://localhost:8080/videoWeb/video/"+name);
					sf.setSrc("http://localhost:8080/Hex/images/"+name);

				}
				
			}
			
			//把数据入库
			gs.InsertGoods(sf);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}		
	}
	
	//通过发货人查询发布的商品
	@ResponseBody
	@RequestMapping("/goodsbyseller")
	public Msg SelectBySeller(ShowForgoods sf){
	
	return Msg.success().add("PageInfo", gs.SelectBySeller(sf));
		
	}
	//查询商品数据在前台显示
	@ResponseBody
	@RequestMapping("/show")
	public Msg ShowGoodsInfo(){				
		return Msg.success().add("PageInfo", gs.ShowGoodsInfo());	
	}
	
	@ResponseBody
	@RequestMapping("/bydetailsid")
	public Msg SelectById(ShowForgoods sf){
		return Msg.success().add("PageInfo", gs.SelectByid(sf));
		
	}
	//通过类型查询 也就是分类 
	@ResponseBody
	@RequestMapping("/bytype")
	public Msg SelectByType(ShowForgoods sf){
		
		return Msg.success().add("PageInfo", gs.SelectByType(sf));
	}
}
