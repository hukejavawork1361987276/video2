package com.zhiyou100.video.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.Video;

public interface UserMapper {
	int selectMail1(String email);

	void userRegister(Map map);

	void addCaptcha(Map map);

	int captchaYZ(Map map);

	void resetpwd(Map map);

	User login(Map map);

	void updateInfo(User user);

	User findAllInf(String email);

	void updateHeadUrl(User user);

	int findOldpassword(Map map );

	void updatePassword(Map map1);

	Subject findSubject(int subjectId);

	List<Course> findCourseVideo(int subjectId);

	Video findVideo(String videoId);

	Speaker findSpeaker(int speakerid);

	Course findCourse(String videoId);

	List<Video> findVideos(int courseid);

	void updateCount(Integer videoId);

	Video findVideoinf(String videoId);

	
}
