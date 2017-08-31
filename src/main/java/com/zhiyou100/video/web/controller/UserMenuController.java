package com.zhiyou100.video.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.LoginInf;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.LoginSercice;
import com.zhiyou100.video.service.UserSercice;
import com.zhiyou100.video.utils.HMS;
import com.zhiyou100.video.utils.MailUtil;

@Controller

public class UserMenuController {
	@Autowired
	UserSercice us;
	//��¼ҳ��
	@RequestMapping("/front/user/userMenuYm.action")
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
	@RequestMapping("/front/user/forgetpwd.action")
	public String forgetYm(){
		return "/front/user/forget_pwd"; 
		
	}
	//������֤��Ϣ
	@RequestMapping("/front/user/sendemail.action")
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
	@RequestMapping(value="/front/user/forgetpwd.action",method=RequestMethod.POST)
	public String forgetYZ(String captcha,String email,HttpSession session,ModelMap mm){
	int a=	us.captchaYZ( captcha,email);
	session.setAttribute("mailMsg", a);
	session.setAttribute("email", email);
	mm.addAttribute("captcha", captcha);
	//session.setAttribute("captcha", captcha);
	if(a==1){
		return "/front/user/reset_pwd"; 
	}else{
		return ""; 
	}
		
		
	}
	//��������
	@RequestMapping(value="/front/user/resetpwd.action")
public String resetpwd1(String email,String captcha,String password,String pwdAgain){
		if(password.equals(pwdAgain)){
	us.resetpwd(email,captcha,password);
	return "/front/index"; 
		}else{
			return "";
		}
	}
//��������,���ص�¼	
@RequestMapping("/front/user/index.action")
public String relogin(){
	
	return "/front/index"; 
	
	}
//��¼
@RequestMapping(value="/front/user/login.action",method=RequestMethod.POST)
@ResponseBody
public String login(String email,String password,HttpSession session){
	System.out.println(password);
	System.out.println(email);
	
	User user =	us.login(email,password);
	System.out.println("sdfgjk--------"+user);
	session.setAttribute("_front_user", user);
	session.setAttribute("user", user);
	LoginInf inf = new LoginInf();
	ObjectMapper mapper = new ObjectMapper();
	String json=null;
	if (user!=null) {
		System.out.println(222);
	try {
		inf.setSuccess("��¼�ɹ�!");
		json = mapper.writeValueAsString(inf);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return json;	 	
	}else{
		inf.setMessage("�û������벻ƥ��!");
		try {
			json = mapper.writeValueAsString(inf);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json; 
	}
	}
//�����������
@RequestMapping("/front/user/index1.action")
	public String userInfo(){

		return "/front/user/index"; 
	}

//���ĸ�������
@RequestMapping(value="/front/user/profile.action",method=RequestMethod.POST)
	public String editUserInfoYm(User user,HttpSession session){
	
	us.updateInfo(user);
User user1 =	us.findAllInf(user.getEmail());
System.out.println(user1);
	session.setAttribute("user", user1);
	return "redirect:/front/user/index.action"; 
	}
	//���ĸ�������ҳ��
	@RequestMapping("/front/user/profile.action")
		public String editUserInfo(){
			return "/front/user/profile"; 
		}
	
	
	//���ĸ���ͷ��ҳ��
		@RequestMapping("/front/user/avatar.action")
			public String editUserPicYM(){
				return "/front/user/avatar"; 
			}
		
		//���ĸ���ͷ��
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
		
		//��������ym
		@RequestMapping(value="/front/user/password.action")
			public String editPasswordym(){

	       return "/front/user/password"; 
			}
		//��������
		@RequestMapping(value="/front/user/password.action",method=RequestMethod.POST)
			public String editPassword(String oldPassword,String newPassword,String newPasswordAgain,String email){
			String mes =	us.editPassword( oldPassword, newPassword, newPasswordAgain, email);
			if(mes==""){
				return "/front/user/index";
			}else{
				return"";
			}
			}
		
		//�˳�
		@RequestMapping("/front/user/logout.action")
			public String exit(HttpSession session){
			session.invalidate();
			return "redirect:/front/user/userMenuYm.action";
			}
		
		//�γ�չʾ
		@RequestMapping("/front/course/index.action")
			public String showCourse(int subjectId,ModelMap mm){
				mm.addAttribute("subjectId", subjectId);
				Subject subject		=	us.findSubject(subjectId);
				mm.addAttribute("subject", subject);
			List<Course>  course=	us.findCourseVideo(subjectId);
			for (Course course2 : course) {
				List<Video> videoList = course2.getVideoList();
				for (Video video : videoList) {
					int vlength = video.getVideo_length();
					String  vlengthStr=	HMS.trans(vlength);
						video.setVideo_lengthStr(vlengthStr);
					
					
					
				}
			}	
			
			
				mm.addAttribute("courses", course);
				
				
				return "/front/course/index";
		}
		
		//�ۿ���Ƶ1
		@RequestMapping("/front/video/index.action")
			public String showRadio(String videoId,int subjectId,ModelMap mm,HttpSession session){
			Subject subject		=	us.findSubject(subjectId);
			mm.addAttribute("subject", subject);
			mm.addAttribute("videoId", videoId);
			System.out.println("subjectId_--------"+subjectId);
			session.setAttribute("subjectId", subjectId);
				return "/front/video/index";
		}
	//�ۿ���Ƶ2
				/*@RequestMapping("/front/video/videoData.action")
					public String showRadioData(String videoId,ModelMap mm){
					System.out.println("videoId:"+videoId);
					
					Video video	= us.findVideo(videoId);
					mm.addAttribute("video", video);
			System.out.println("video:"+video);
					int subjectid =	video.getSubject_id();
					
					mm.addAttribute("subjectId", subjectid);
					
					int speakerid=	video.getSpeaker_id();
					Speaker speaker = us.findSpeaker(speakerid);
				
					mm.addAttribute("speaker", speaker);
					
					
				
				Course inf=	us.findCourse(videoId);
					mm.addAttribute("course", inf);
					
					List<Video> videoList =us.findVideos(subjectid);
					
					mm.addAttribute("videoList", videoList);
					
						return "/front/video/content";
			
				}*/
				
				
				//�ۿ���Ƶ(���title)
				@RequestMapping("/front/video/videoDataTitle.action")
					public String showRadioDataTitle(String videoId,String subjectId,ModelMap mm,HttpSession session){		
					Video video	= us.findVideoinf(videoId);
					
					
					mm.addAttribute("video", video);

					mm.addAttribute("subjectId", subjectId);
					
					int speakerid=	video.getSpeaker_id();
					Speaker speaker = us.findSpeaker(speakerid);
				
					mm.addAttribute("speaker", speaker);
					
					
				
				Course inf=	us.findCourse(videoId);
					mm.addAttribute("course", inf);
					
					
					
			int courseid=	video.getCourse_id();
					List<Video> videoList =us.findVideos(courseid);
					for (Video video2 : videoList) {
						int vlength = video2.getVideo_length();
					String  vlengthStr=	HMS.trans(vlength);
						video2.setVideo_lengthStr(vlengthStr);
					}
					
					
					mm.addAttribute("videoList", videoList);
					
						return "/front/video/content";
			
				}
				//ͳ�Ʋ��Ŵ���
				@RequestMapping("/front/video/state.action")
				public void count(Integer videoId){
					us.updateCount(videoId);
				
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
