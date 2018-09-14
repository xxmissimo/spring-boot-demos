package com.issimo.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issimo.web.bean.UserInfo;
import com.issimo.web.dao.UserInfoMapper;
import com.issimo.web.utils.MailUtils;
import com.issimo.web.utils.UUIDUtils;

@Service
public class UserService {
	@Autowired
	UserInfoMapper um;
	public void register(UserInfo ui) throws Exception {
		//0表示未激活 1表示激活
		ui.setState(0);
		String code=UUIDUtils.getUUID();
		ui.setCode(code);
		um.insertSelective(ui);
		MailUtils.sendMail(ui.getEmail(), ui.getCode());
	}
	
	public boolean CheckEmail(UserInfo user){
		int count=um.selectByEmail(user.getEmail());
		if(count==0){
			//System.out.println("邮箱不存在！可以注册！"); 
			return true; 
		}else{
			//System.out.println("邮箱已存在  请直接登陆！");
			return false;
		}
	}
	
	//查询所有用户 并返回该集合
	public List<UserInfo> findall(){
		
		return um.selectByExample(null);
	}
	//通过id输出某一用户
	
	public void delmember(UserInfo ui){
		um.deleteByPrimaryKey(ui.getUid());
	}
	
	
	
	public UserInfo findByCode(String code) throws Exception {			
			return um.findBycode(code);
		}	
	public void update(UserInfo user){
		um.updateByPrimaryKeySelective(user);
	}
	
	public boolean checkUser(UserInfo user){			
			//1.判断邮箱是否存在		
		if(CheckEmail(user)){
			System.out.println("邮箱不存在！"); 
			return false;
		}else{
			//2.通过取出的User判断是否激活
			UserInfo ui=um.findUserByEmail(user.getEmail());
			if(ui.getState()==1){
				if(ui.getPassword().equals(user.getPassword())){
					System.out.println("登陆成功！");	
					return true;
				}else{
					System.out.println("密码错误！");
					return false;
				}				
			}else{
					System.out.println("未激活！请去激活再登陆");
					return false;
			}										
		}	
	}
}
	
	

