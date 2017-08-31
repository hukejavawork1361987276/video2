package com.zhiyou100.video.web.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class VideoException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse res, Object obj,
			Exception exception) {System.out.println(req+"---"+res+"---"+obj+"----"+exception);
	        ModelAndView mav = new ModelAndView();
	        mav.addObject("obj", obj);
	        mav.addObject("exception", exception);
	        mav.setViewName("/front/message");
	        return mav;

	}

}
