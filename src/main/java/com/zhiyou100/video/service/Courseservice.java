package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Page;

public interface Courseservice {
	List<Course>	findcourseList();

	Page loadPage(Integer page);
}
