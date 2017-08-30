package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.User;

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

	Subject findSubject(String subjectId);

	List<Course> findCourseVideo(String subjectId);
}
