package com.zhiyou100.video.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.UserMapper;
import com.zhiyou100.video.model.User;
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
		map.put("password", password);
		um.resetpwd(map);
		
	}
	@Override
	public User login(String email, String password) {
		Map map=new HashMap<>();
		map.put("password", password);
		map.put("email", email);
		return um.login(map);
	}
	

}
