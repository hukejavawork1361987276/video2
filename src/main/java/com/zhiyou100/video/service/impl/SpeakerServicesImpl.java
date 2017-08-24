package com.zhiyou100.video.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.SpeakerSercice;

@Service
public class SpeakerServicesImpl implements SpeakerSercice{
@Autowired
SpeakerMapper sm;
	@Override
	public List<Speaker> showSpeakers(Integer page,String speaker_name, String speaker_job) {	
		return sm.findAllSpesker();
	}
	
	
	@Override
	public Page loadPage(Integer page, String speaker_name, String speaker_job) {
		Page<Video> page1=new Page<>();
		page1.setPage(page);
		
		Map paramMap1=new HashMap();
		paramMap1.put("speaker_name",speaker_name);
		paramMap1.put("speaker_job",speaker_job);
		
		page1.setTotal(sm.findSCount(paramMap1));
		page1.setSize(10);
		
		Map paramMap2=new HashMap();
		paramMap2.put("speaker_name",speaker_name);
		paramMap2.put("speaker_job",speaker_job);
		
		
		int	currentPage1 =(page-1)*10;
		paramMap2.put("currentPage",currentPage1);
		
		page1.setRows(sm.findS(paramMap2));
System.out.println(page1);
		return page1;
	}


	@Override
	public void addOneSpeaker(Speaker speaker) {
		sm.addOneSpeaker(speaker);
		
	}


	@Override
	public Speaker editSpeaker(Integer id) {
		
		return sm.editSpeaker(id);
	}

}
