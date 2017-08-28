package com.zhiyou100.video.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.VideoService;

@Controller
public class VideoManager {
	@Autowired
	VideoService vs;
	@RequestMapping(value="/vedio/videoList.action")
	public String videoList(String page,ModelMap mm,String titlelike,String speakid,String courseid){	
		
		//�����������б�
	List<Speaker> allSpeaker= vs.findSpeaker();	
	mm.addAttribute("allSpeaker", allSpeaker);
	//���ҿγ��б�
	List<Course> allCourse= vs.findCourse();	
	mm.addAttribute("allCourse", allCourse);
	
	
	
	

	if(titlelike==null|| speakid==null||courseid==null){
		titlelike="";
		speakid="";
		courseid="";
		}
	
	
	
		mm.addAttribute("titlelike", titlelike);
		mm.addAttribute("speakid",speakid);
		mm.addAttribute("courseid",courseid);
	
		int currentPage=(page==null?1:Integer.parseInt(page));
	
		Page page1=vs.loadPage(titlelike,speakid,courseid,currentPage);
		
	
		mm.addAttribute("page",page1);
	
	
	return "radioList";
	}
	
	@RequestMapping("/vedio/addVideo.action")
	public String addVideoYM(ModelMap mm){
		//�����������б�
		List<Speaker> allSpeaker= vs.findSpeaker();	
		mm.addAttribute("allSpeaker", allSpeaker);
		//���ҿγ��б�
		List<Course> allCourse= vs.findCourse();	
		mm.addAttribute("allCourse", allCourse);
	return "editRadio";
	}
	
	@RequestMapping(value="/vedio/addVideo.action",method=RequestMethod.POST)
	public String addVideo(Video v,MultipartFile pic){
	int flag=vs.addVideo(v,pic);
	return "forward:/vedio/videoList.action";
	}
	
	@RequestMapping(value="/vedio/deleVideo.action",method=RequestMethod.POST)
	public String deleVideo(Integer[] deleVideo){
		int flag=vs.deleVideo(deleVideo);
		return "forward:/vedio/videoList.action";	
	}
	
	@RequestMapping("/vedio/editVideo.action")
	public String editVideoYM(ModelMap mm,Integer id){
		//�����������б�
		List<Speaker> allSpeaker= vs.findSpeaker();	
		mm.addAttribute("allSpeaker", allSpeaker);
		//���ҿγ��б�
		List<Course> allCourse= vs.findCourse();	
		mm.addAttribute("allCourse", allCourse);
		//����һ����Ƶ��Ϣ
		
		Video video=vs.findOneVideo(id);
		mm.addAttribute("video", video);
		
	return "editRadioUpdate";
	}
	//������Ƶ
	@RequestMapping(value="/vedio/updateVideo.action",method=RequestMethod.POST)
	public String updateVideo(Video v){
		vs.updateOneVideo(v);
		return "forward:/vedio/videoList.action";
	}
	
	
	//deldeOne��Ƶ
		@RequestMapping(value="/vedio/deleOneVideo.action",method=RequestMethod.POST)
		@ResponseBody
		public String deleOneVideo(Integer id){
			System.out.println("dgfdj------------");
			vs.deleOneVideo(id);
			return "success";
		}
}
