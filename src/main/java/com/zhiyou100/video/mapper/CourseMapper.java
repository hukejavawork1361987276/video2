package com.zhiyou100.video.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Video;

public interface CourseMapper {
	List<Course>	findcourseList();

	int findSCount();

	List<Video> findS(Map paramMap2);
}
