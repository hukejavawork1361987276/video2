package com.zhiyou100.video.mapper;

import java.util.Map;

import com.zhiyou100.video.model.User;

public interface UserMapper {
	int selectMail1(String email);

	void userRegister(Map map);

	void addCaptcha(Map map);

	int captchaYZ(Map map);

	void resetpwd(Map map);

	User login(Map map);
}