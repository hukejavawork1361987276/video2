package com.zhiyou100.video.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.service.LoginSercice;

@Controller
public class UserMenu {
	//@Autowired
	//UserSercice us;
	@RequestMapping("user/userMenuYm.action")
	public String userMenuYmController(){
		return "/front/index"; 
		
	}

}
