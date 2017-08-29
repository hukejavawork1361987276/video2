package com.zhiyou100.video.web.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhiyou100.video.model.LoginInf;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.LoginSercice;
import com.zhiyou100.video.service.UserSercice;
import com.zhiyou100.video.utils.MailUtil;

@Controller

public class UserMenuController {
	@Autowired
	UserSercice us;
	//��¼ҳ��
	@RequestMapping("/user/userMenuYm.action")
	public String userMenuYmController(){
		return "/front/index"; 	
	}
	//ע��
	@RequestMapping("/front/user/regist.action")
	@ResponseBody
	public String userRegController(String email,String password,ModelMap mm){
	int no=	us.selectMail(email);
	LoginInf inf=new LoginInf();

	if(no!=0){
		
		inf.setMessage("�û��Ѵ���!");		
	}else{		
		us.userRegister(email,password);
		inf.setSuccess("ע��ɹ���");		
	}	
	
	ObjectMapper mapper = new ObjectMapper();
	String json=null;
	try {
		json = mapper.writeValueAsString(inf);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return json;
	}
	
	
	//�����������,����Ľ���,�����ʼ�
	@RequestMapping("/forgetpwd.action")
	public String forgetYm(){
		return "/front/user/forget_pwd"; 
		
	}
	//������֤��Ϣ
	@RequestMapping("/sendemail.action")
	@ResponseBody
	public String sendemailYm(String email){
		String num=	 UUID.randomUUID().toString();
		String  a=	num.substring(0, 5);
		LoginInf inf=new LoginInf();
	       us.addCaptcha(email,a);
		try {
			MailUtil.send(email, "������Ϣ",a);
			inf.setSuccess("���ͳɹ���");
			System.out.println("���ͳɹ���");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String json=null;
		try {
			json = mapper.writeValueAsString(inf);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;		
	}
	//����������ҳ��
	@RequestMapping(value="/forgetpwd.action",method=RequestMethod.POST)
	public String forgetYZ(String captcha,String email,HttpSession session){
	int a=	us.captchaYZ( captcha,email);
	session.setAttribute("email", email);
	session.setAttribute("captcha", captcha);
	if(a==1){
		return "/front/user/reset_pwd"; 
	}else{
		return ""; 
	}
		
		
	}
	//��������
	@RequestMapping(value="/ret/resetpwd.action")
public String resetpwd1(String email,String captcha,String password,String pwdAgain){
		if(password.equals(pwdAgain)){
	us.resetpwd(email,captcha,password);
	return "/front/index"; 
		}else{
			return "";
		}
	}
//��������,���ص�¼	
@RequestMapping("/fanhui/index.action")
public String relogin(){
	
	return "/front/index"; 
	
	}
//��¼
@RequestMapping("/front/user/login.action")
@ResponseBody
public String login(String email,String password,HttpSession session){
	User user =	us.login(email,password);
	session.setAttribute("_front_user", user);
	LoginInf inf = new LoginInf();
	ObjectMapper mapper = new ObjectMapper();
	String json=null;
	if (user!=null) {
		
	try {
		inf.setSuccess("��¼�ɹ�!");
		json = mapper.writeValueAsString(inf);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return json;	 	
	}else{
		return json; 
	}
	}
//�����������
@RequestMapping("/front/user/index.action")
	public String userInfo(){
		return "/front/user/index"; 
	}

//���ĸ�������ҳ��
@RequestMapping("front/user/profile.action")
	public String editUserInfo(){
		return "/front/user/profile"; 
	}
	/*@RequestMapping(value="user/front/user/regist.action")
	public String userRegist(String email,String password){
		StringBuffer body= new StringBuffer();
		body.append(email).append(password).append(System.currentTimeMillis());
		
	String body1= DigestUtils.md5Hex("body");
		 System.out.println(body1);
	String id=	 UUID.randomUUID().toString();
		 String url="http://localhost:8080/video/Mail/active.action?id="+id+"&activeCode="+body1;
		try {
			MailUtil.send(email, "������Ϣ","<a href="+url+">"+url+"</a>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "forward:/NewFile.jsp"; 
		
	}
	
	@RequestMapping("Mail/active.action")
	public String mailActiveController(String id,String activeCode,ModelMap mm){
		mm.addAttribute("id", id);
		mm.addAttribute("activeCode", activeCode);
		return "forward:/NewFile.jsp"; 
		
	}*/
}
