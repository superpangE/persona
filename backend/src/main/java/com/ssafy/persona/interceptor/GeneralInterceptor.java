package com.ssafy.persona.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.persona.domain.user.security.SecurityService;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Component
public class GeneralInterceptor implements HandlerInterceptor{

	@Autowired
	SecurityService securityService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		if (url.contains("swagger")|| url.contains("api-docs") || url.contains("webjars")) {
			return true;
		}
		
		log.info(request.getRequestURI());
		log.info("token: "+request.getHeader("token"));

		//HttpSession session = request.getSession();
		//System.out.println(securityService.getSubject(request.getHeader("token")));
		//System.out.println(session.getAttribute("token"));
		Map<String, Object> map = null;


		try {
			//System.out.println(securityService.getSubject(session.getAttribute("token").toString()));
			//securityService.getSubject(session.getAttribute("token").toString());
			// JSON 파일을 MAP으로 변환
			map = new ObjectMapper().readValue(request.getHeader("token").toString(), Map.class);
			securityService.getSubject(map.get("token").toString());
//			System.out.println(securityService.getSubject(map.get("token").toString()));
//			System.out.println(map.get("token"));

		} catch (Exception e) {
			log.error("허가받지 않은 사용자");
			// 로그인 페이지로 redirect 해야함
			// 사용자 정의 Exception으로 throw 하기
			// throw new myException
			return (false);
		}
		
		return (true);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
