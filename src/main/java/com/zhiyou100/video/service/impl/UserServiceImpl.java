package com.zhiyou100.video.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.UserMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.UserSercice;

@Service
public class UserServiceImpl implements UserSercice{
@Autowired
UserMapper um;
	@Override
	public int selectMail(String email) {
		// TODO Auto-generated method stub
		return um.selectMail1(email);
	}
	@Override
	public void userRegister(String email, String password) {
		String password1= DigestUtils.md5Hex(password);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		Map map=new HashMap<>();
		map.put("email", email);
		map.put("password1", password1);
		map.put("timestamp", timestamp);
	um.userRegister(map);
	}
	@Override
	public void addCaptcha(String email, String num) {
		Map map=new HashMap<>();
		map.put("email", email);
		map.put("num", num);
		um.addCaptcha(map);
		
	}
	@Override
	public int captchaYZ(String captcha, String email) {
		Map map=new HashMap<>();
		map.put("captcha", captcha);
		map.put("email", email);
		return um.captchaYZ(map);
	}
	@Override
	public void resetpwd(String email,String captcha,String password) {
		String password1= DigestUtils.md5Hex(password);
		Map map=new HashMap<>();
		map.put("captcha", captcha);
		map.put("email", email);
		map.put("password", password1);
		um.resetpwd(map);
		
	}
	@Override
	public User login(String email, String password) {
		Map map=new HashMap<>();
		String password1= DigestUtils.md5Hex(password);
		
		map.put("password", password1);
		map.put("email", email);
		return um.login(map);
	}
	@Override
	public void updateInfo(User user) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		user.setUpdate_time(timestamp);
		
		um.updateInfo(user);
		
	}
	@Override
	public User findAllInf(String email) {
		
		return um.findAllInf(email);
	}
	@Override
	public void updateHeadUrl(User user) {
		um.updateHeadUrl(user);
		
	}
	@Override
	public String editPassword(String oldPassword, String newPassword, String newPasswordAgain, String email) {
		Map map = new HashMap<>();
		String password1= DigestUtils.md5Hex(oldPassword);
		map.put("oldPassword", password1);
		map.put("email", email);
		int flag=um.findOldpassword(map);
		
		if(flag==1){
			String a="false";
			if(newPassword.equals(newPasswordAgain)){
				Map map1 = new HashMap<>();
				String password2= DigestUtils.md5Hex(newPassword);
				map1.put("newPassword", password2);
				map1.put("email", email);
				um.updatePassword(map1);
				a="";	
			}
			return a;
			
		}else{
			return "æ…√‹¬Î≤ª’˝»∑!";
		}
		
		
	}
	@Override
	public Subject findSubject(int subjectId) {
		
		return um.findSubject(subjectId);
	}
	@Override
	public List<Course> findCourseVideo(int subjectId) {
		
		return um.findCourseVideo(subjectId);
	}
	@Override
	public Video findVideo(String videoId) {
		// TODO Auto-generated method stub
		return um.findVideo(videoId);
	}
	@Override
	public Speaker findSpeaker(int speakerid) {
		// TODO Auto-generated method stub
		return um.findSpeaker(speakerid);
	}
	@Override
	public Course findCourse(String videoId) {
	
		return um.findCourse(videoId) ;
	}
	@Override
	public List<Video> findVideos(int courseid) {
	
		return um.findVideos(courseid);
	}
	@Override
	public void updateCount(Integer videoId) {
		
		um.updateCount(videoId);
		
	}
	@Override
	public Video findVideoinf(String videoId) {
		
		return um.findVideoinf(videoId);
	}
	
	

}
