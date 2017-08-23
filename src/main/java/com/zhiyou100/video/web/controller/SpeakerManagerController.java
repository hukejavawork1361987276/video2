package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.LoginSercice;
import com.zhiyou100.video.service.SpeakerSercice;
@Controller
public class SpeakerManagerController {
	@Autowired
	SpeakerSercice ss;
	
	@RequestMapping("/vedio/speakerList.action")
	public String loginYmController(ModelMap mm){
	List<Speaker> speakers=	ss.showSpeakers();
		mm.addAttribute("speakers", speakers);
		return "/speakerList"; 
		
	}
}
