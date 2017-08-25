package com.zhiyou100.video.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.LoginMapper;
import com.zhiyou100.video.mapper.TMapper;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.LoginSercice;
import com.zhiyou100.video.service.TService;
@Service
public class TServiceImpl implements TService{
@Autowired 
TMapper tm;

@Override
public List<Video> findbiao() {
	
	return tm.findbiao();
}
	

}
