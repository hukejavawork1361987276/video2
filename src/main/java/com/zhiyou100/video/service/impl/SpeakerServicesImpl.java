package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.SpeakerSercice;

@Service
public class SpeakerServicesImpl implements SpeakerSercice{
@Autowired
SpeakerMapper sm;
	@Override
	public List<Speaker> showSpeakers() {
		
		return sm.findAllSpesker();
	}

}
