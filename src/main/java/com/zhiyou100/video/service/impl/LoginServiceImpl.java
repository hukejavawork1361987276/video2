package com.zhiyou100.video.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.LoginMapper;
import com.zhiyou100.video.service.LoginSercice;
@Service
public class LoginServiceImpl implements LoginSercice{
@Autowired 
LoginMapper lm;
	@Override
	public int loginSuccess(String name, String password) {
		Map  map1=new HashMap<>();
		map1.put("name", name);
		map1.put("password", password);
		
		
	int a=	lm.selectuser(map1);
		return a;
	}

}
