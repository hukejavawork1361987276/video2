package com.zhiyou100.video.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	//登录页面
	@RequestMapping("/user/userMenuYm.action")
	public String userMenuYmController(){
		return "/front/index"; 	
	}
	//注册
	@RequestMapping("/front/user/regist.action")
	@ResponseBody
	public String userRegController(String email,String password,ModelMap mm){
	int no=	us.selectMail(email);
	LoginInf inf=new LoginInf();

	if(no!=0){
		
		inf.setMessage("用户已存在!");		
	}else{		
		us.userRegister(email,password);
		inf.setSuccess("注册成功！");		
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
	
	
	//点击忘记密码,进入的界面,发送邮件
	@RequestMapping("/forgetpwd.action")
	public String forgetYm(){
		return "/front/user/forget_pwd"; 
		
	}
	//发送验证信息
	@RequestMapping("/sendemail.action")
	@ResponseBody
	public String sendemailYm(String email){
		String num=	 UUID.randomUUID().toString();
		String  a=	num.substring(0, 5);
		LoginInf inf=new LoginInf();
	       us.addCaptcha(email,a);
		try {
			MailUtil.send(email, "激活信息",a);
			inf.setSuccess("发送成功！");
			System.out.println("发送成功！");
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
	//到重置密码页面
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
	//重置密码
	@RequestMapping(value="/ret/resetpwd.action")
public String resetpwd1(String email,String captcha,String password,String pwdAgain){
		if(password.equals(pwdAgain)){
	us.resetpwd(email,captcha,password);
	return "/front/index"; 
		}else{
			return "";
		}
	}
//忘记密码,返回登录	
@RequestMapping("/fanhui/index.action")
public String relogin(){
	
	return "/front/index"; 
	
	}
//登录
@RequestMapping("/front/user/login.action")
@ResponseBody
public String login(String email,String password,HttpSession session){
	System.out.println(password);
	System.out.println(email);
	
	User user =	us.login(email,password);
	session.setAttribute("_front_user", user);
	session.setAttribute("user", user);
	LoginInf inf = new LoginInf();
	ObjectMapper mapper = new ObjectMapper();
	String json=null;
	if (user!=null) {
		
	try {
		inf.setSuccess("登录成功!");
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
//跳入个人资料
@RequestMapping("/front/user/index.action")
	public String userInfo(){

		return "/front/user/index"; 
	}

//更改个人资料
@RequestMapping(value="/front/user/profile.action",method=RequestMethod.POST)
	public String editUserInfoYm(User user,HttpSession session){
	
	us.updateInfo(user);
User user1 =	us.findAllInf(user.getEmail());
System.out.println(user1);
	session.setAttribute("user", user1);
	return "redirect:/front/user/index.action"; 
	}
	//更改个人资料页面
	@RequestMapping("/front/user/profile.action")
		public String editUserInfo(){
			return "/front/user/profile"; 
		}
	
	
	//更改个人头像页面
		@RequestMapping("/front/user/avatar.action")
			public String editUserPicYM(){
				return "/front/user/avatar"; 
			}
		
		//更改个人头像
		@RequestMapping(value="/front/user/avatar.action",method=RequestMethod.POST)
			public String editUserPic(User user,MultipartFile image_file,HttpSession session){
		
	       String str = UUID.randomUUID().toString().replaceAll("-", "");
	       String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());
	       String fileName = str+"."+ext;
	       user.setHead_url(fileName);
	      us.updateHeadUrl(user);
	      
	        String path = "D:\\develo\\Java\\vimage";
	      
	       try {
			image_file.transferTo(new File(path+"\\"+fileName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	       User user1 =	us.findAllInf(user.getEmail());
	       System.out.println(user1);
	   	session.setAttribute("user", user1);
	       return "/front/user/index"; 
			}
		
		//更改密码ym
		@RequestMapping(value="/front/user/password.action")
			public String editPasswordym(){

	       return "/front/user/password"; 
			}
		//更改密码
		@RequestMapping(value="/front/user/password.action",method=RequestMethod.POST)
			public String editPassword(String oldPassword,String newPassword,String newPasswordAgain,String email){
			String mes =	us.editPassword( oldPassword, newPassword, newPasswordAgain, email);
			if(mes==""){
				return "/front/user/index";
			}else{
				return"";
			}
			}
		
		//退出
		@RequestMapping("/front/user/logout.action")
			public String exit(HttpSession session){
			session.invalidate();
			return "redirect:/user/userMenuYm.action";
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
			MailUtil.send(email, "激活信息","<a href="+url+">"+url+"</a>");
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
