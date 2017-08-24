package com.zhiyou100.video.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.Courseservice;
@Service
public class CourseServiceImpl implements Courseservice{
@Autowired
CourseMapper cm;
	
	
	@Override
	public List<Course> findcourseList() {
		
		return cm.findcourseList();
	}


	@Override
	public Page loadPage(Integer page) {
		
		Page<Video> page1=new Page<>();
		page1.setPage(page);
		
		
		page1.setTotal(cm.findSCount());
		page1.setSize(10);
		
		Map paramMap2=new HashMap();		
		int	currentPage1 =(page-1)*10;
		paramMap2.put("currentPage",currentPage1);
		
		page1.setRows(cm.findS(paramMap2));

		return page1;
	}

}
