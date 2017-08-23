package com.zhiyou100.video.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;

public interface VideoService {
		List<Video> findVideoList();

		int deleVideo(Integer[] deleVideo);

		List<Speaker> findSpeaker();

		List<Course> findCourse();

		Page loadPage(String titlelike, String speakid, String courseid, int currentPage);

		int addVideo(Video v,MultipartFile pic);

		Video findOneVideo(Integer id);

		void updateOneVideo(Video v);

		void deleOneVideo(Integer id);
}
