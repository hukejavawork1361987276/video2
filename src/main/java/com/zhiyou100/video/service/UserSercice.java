package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.Video;

public interface UserSercice {
	int selectMail(String email);

	void userRegister(String email, String password);

	void addCaptcha(String email, String num);

	int captchaYZ(String captcha, String email);

	void resetpwd(String email,String captcha,String password);

	User login(String email, String password);

	void updateInfo(User user);

	User findAllInf(String email);

	void updateHeadUrl(User user);

	String editPassword(String oldPassword, String newPassword, String newPasswordAgain, String email);

	Subject findSubject(int subjectId);

	List<Course> findCourseVideo(int subjectId);

	Video findVideo(String videoId);

	Speaker findSpeaker(int speakerid);

	Course findCourse(String videoId);

	List<Video> findVideos(int sid);

	void updateCount(Integer videoId);

	Video findVideoinf(String videoId);


}
