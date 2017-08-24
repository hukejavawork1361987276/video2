package com.zhiyou100.video.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;

public interface SpeakerSercice {
     List<Speaker>  showSpeakers(Integer page,
 			 String speaker_name,
 			 String speaker_job);

	Page loadPage(Integer page, String speaker_name, String speaker_job);

	void addOneSpeaker(Speaker speaker);

	Speaker editSpeaker(Integer id);
}
