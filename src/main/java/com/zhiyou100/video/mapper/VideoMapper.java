package com.zhiyou100.video.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;

public interface VideoMapper {
	List<Video> findVideoList();

	void deleVideo(Integer[] deleVideo);

	List<Speaker> speakerList();

	List<Course> findCourse();

	int findVCount(Map paramMap1);

	List<Video> findV(Map paramMap2);

	int addVideo(Video v);

	Video findOneVideo(Integer id);

	void updateOneVideo(Video v);

	void deleOneVideo(Integer id);
}
