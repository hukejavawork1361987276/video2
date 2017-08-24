package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.service.Courseservice;

@Controller
public class CourseList {

	@Autowired
	Courseservice cs;
@RequestMapping("/vedio/courseList.action")
public String courseList(ModelMap mm,@RequestParam(defaultValue="1") Integer page){
	/*List<Course> courseList=	cs.findcourseList();
	mm.addAttribute("courseList", courseList);*/
	
	Page page1=cs.loadPage(page);
	mm.addAttribute("page",page1);
	return "curriculumList";
}


}
