package com.zhiyou100.video.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;

public interface SpeakerMapper {
	List<Speaker> findAllSpesker();

	int findSCount(Map paramMap1);

	List<Video> findS(Map paramMap2);

	void addOneSpeaker(Speaker speaker);

	Speaker editSpeaker(Integer id);
}
