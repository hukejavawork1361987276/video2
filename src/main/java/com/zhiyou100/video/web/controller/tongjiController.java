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
	for (int i = 0; i < v.size(); i++) {
		
		mm.addAttribute("zhiname"+i, v.get(i).getCourseName());
		System.out.println("zhiname"+i+"-------"+v.get(i).getCourseName());
		mm.addAttribute("zhi"+i, v.get(i).getVideo_play_times());
		System.out.println("zhi"+i+"--------"+v.get(i).getVideo_play_times());
		
	}
	
	mm.addAttribute("zhi", v);
		return "/tongji"; 
		
	}
	
	
	

}
