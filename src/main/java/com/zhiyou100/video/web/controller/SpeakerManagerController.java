package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.LoginSercice;
import com.zhiyou100.video.service.SpeakerSercice;
@Controller
public class SpeakerManagerController {
	@Autowired
	SpeakerSercice ss;
	
	@RequestMapping("/vedio/speakerList.action")
	public String speakerController(
			@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="") String speaker_name,
			@RequestParam(defaultValue="") String speaker_job,
			ModelMap mm){
		mm.addAttribute("speaker_name", speaker_name);
		mm.addAttribute("speaker_job",speaker_job);
		
	/*List<Speaker> speakers=	ss.showSpeakers(page,speaker_name,speaker_job);
		mm.addAttribute("speakers", speakers);*/
		
		Page page1=ss.loadPage(page,speaker_name,speaker_job);
		mm.addAttribute("page",page1);
		
		return "/speakerList"; 
		
	}
	
	@RequestMapping("/vedio/addSpeakerYM.action")
	public String addSpeakerYMController(){
		
		return "editSpeaker";
		
	}
	@RequestMapping(value="/vedio/addSpeaker.action",method=RequestMethod.POST )
	public String addSpeakerController(Speaker speaker){
		ss.addOneSpeaker(speaker);
		
		return "redirect:/vedio/speakerList.action";
		
	}
	
	@RequestMapping(value="/vedio/editSpeaker.action")
	public String editSpeaker(Integer id,ModelMap mm){
		
	Speaker speaker =	ss.editSpeaker(id);
	System.out.println(speaker);
		mm.addAttribute("speaker", speaker);
		
		return "editSpeakerUpdate";
		
	}
}
