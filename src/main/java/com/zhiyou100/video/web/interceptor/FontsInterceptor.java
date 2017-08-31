package com.zhiyou100.video.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.User;

public class FontsInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse arg1, Object arg2) throws Exception {
		/*int  a=(int)req.getSession().getAttribute("mailMsg");
		System.out.println("adsfgh");
		if(a==1){
			System.out.println(req.getServletPath());
			if (req.getServletPath().equals("/front/user/resetpwd.action")) {
				return true;
			} else {
				return false;
			}
		}else{*/
		
			User user= (User) req.getSession().getAttribute("user");
			System.out.println(user);
			if (user==null) {
				return false;
			} else {
				return true;
			}
		}
		
		
		
		
		
		
		
	
	}


