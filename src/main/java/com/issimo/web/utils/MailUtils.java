package com.issimo.web.utils;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailUtils {
	
   public static void sendMail(String to,String code) throws Exception {
	
	   Properties pros=new Properties();
	   pros.setProperty("mail.transport.protocol", "smtp"); 
       pros.setProperty("mail.smtp.host", "smtp.163.com"); 
       pros.setProperty("mail.smtp.port", "25"); 
       pros.setProperty("mail.smtp.auth", "true"); 
	  // pros.setProperty("host", value);
	   Session session=Session.getInstance(pros, new Authenticator(){

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("lovehyxd@163.com", "issimo20180123");
		}
		   
	   });
	  
	  Message message=new MimeMessage(session);
	 
	  message.setFrom(new InternetAddress("lovehyxd@163.com"));
	  
	  message.setRecipient(RecipientType.TO, new InternetAddress(to));
	  
	  message.setSubject("JavaMailTest");
	 
	  message.setContent("<h1>欢迎加入荣华富贵大家庭，请激活</h1><h3>http://localhost:8080/Hex/active?code="+code+"</h3> ", "text/html;charset=UTF-8");
	 
	  
	  Transport.send(message);
}
}
