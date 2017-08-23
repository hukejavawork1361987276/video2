package com.zhiyou100.video.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.video.mapper.LoginMapper;
import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.VideoService;
@Service
public class VideoListImpl implements VideoService{
	@Autowired 
	VideoMapper vm;
	@Override
	public List<Video> findVideoList() {
		List<Video> li=	vm.findVideoList();
		
		return li;
	}
	@Override
	public int deleVideo(Integer[] deleVideo) {
		
		System.out.println("deleV----------------ideo"+deleVideo);
		if(deleVideo!=null){
		vm.deleVideo(deleVideo);
		}
		return 0;
	}
	@Override
	public List<Speaker> findSpeaker() {
		List<Speaker> speakerList =	vm.speakerList();
		return speakerList;
	}
	@Override
	public List<Course> findCourse() {
		List<Course> allCourse =	vm.findCourse();
		return allCourse;
		
	}
	@Override
	public Page loadPage(String titlelike, String speakid, String courseid, int currentPage) {
	
		Page<Video> page=new Page<>();
		page.setPage(currentPage);
		
		Map paramMap1=new HashMap();
		paramMap1.put("titlelike",titlelike);
		paramMap1.put("speakid",speakid);
		paramMap1.put("courseid",courseid);
		page.setTotal(vm.findVCount(paramMap1));
		page.setSize(10);
		
		Map paramMap2=new HashMap();
		paramMap2.put("titlelike",titlelike);
		paramMap2.put("speakid",speakid);
		paramMap2.put("courseid",courseid);
		
		int	currentPage1 =(currentPage-1)*10;
		paramMap2.put("currentPage",currentPage1);
		
		page.setRows(vm.findV(paramMap2));

		return page;
	}
	@Override
	//插入图片,插入和更新时间
	public int addVideo(Video v,MultipartFile pic) {
		v.setInsert_time(new Timestamp(System.currentTimeMillis()));
		v.setUpdate_time(new Timestamp(System.currentTimeMillis()));
		
	String name=	UUID.randomUUID().toString().replace("-", "");
	String ext=FilenameUtils.getExtension(pic.getOriginalFilename());	
	   String fileName = name+"."+ext;
       v.setVideo_image_url(fileName);
       vm.addVideo(v);
        String path = "D:\\develo\\Java\\vimage";
       
       try {
		pic.transferTo(new File(path+"\\"+fileName));
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
      
		return 0;
	}
	@Override
	public Video findOneVideo(Integer id) {
		
		return vm. findOneVideo(id);
	}
	@Override
	public void updateOneVideo(Video v) {
		v.setUpdate_time(new Timestamp(System.currentTimeMillis()));
		vm.updateOneVideo(v);
	}
	@Override
	public void deleOneVideo(Integer id) {
	vm.deleOneVideo(id);
		
	}

}
