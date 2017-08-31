package com.zhiyou100.video.web.controller;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.service.LoginSercice;

import sun.misc.BASE64Encoder;


@Controller
public class Login {
	@Autowired
	LoginSercice ls;
	
	@RequestMapping("/loginYm.action")
	public String loginYmController(){
		return "/login"; 
		
	}
	
	
	 @RequestMapping("/login.action")
	public String loginController(String name,String password,HttpSession session){
		/* MessageDigest md= null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] bts = md.digest(password.getBytes());
			
			
			//采用Base64编码表示
			BASE64Encoder encoder = new BASE64Encoder();
			 String encode = encoder.encode(bts);
		 System.out.println(encode);*/
		 
		 
		 
		 String password1= DigestUtils.md5Hex(password); 
	int flag=ls.loginSuccess(name, password1);
	session.setAttribute("flag", flag);
	if(flag==1){
		return "menu";
	}
		return "login";
			
	}

}
