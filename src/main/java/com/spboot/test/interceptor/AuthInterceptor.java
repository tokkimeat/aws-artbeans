package com.spboot.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession hs = request.getSession();
		if(hs.getAttribute("user")==null) {
			response.sendRedirect("/views/user/login");
			return false;
		}
		return true;
	}

}
