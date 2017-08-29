package com.zhiyou100.video.web.controller;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.LoginSercice;
import com.zhiyou100.video.service.TService;

import sun.misc.BASE64Encoder;


@Controller
public class tongjiController {
	@Autowired
	TService ts;
	
	@RequestMapping("/vedio/tongji.action")
	public String loginYmController(ModelMap mm){
	List<Video> v=	ts.findbiao();
	
	StringBuffer name=new StringBuffer();
	StringBuffer data=new StringBuffer();
	for (int i = 0; i < v.size(); i++) {

		name.append(v.get(i).getCourseName());
		data.append(v.get(i).getVideo_play_times());
		if(i != v.size() -1 ){
			name.append(",");
			data.append(",");
		}
		
	}
	
	mm.addAttribute("name", name);
	mm.addAttribute("data", data);
		return "/tongji"; 
		
	}
	
	
	

}
