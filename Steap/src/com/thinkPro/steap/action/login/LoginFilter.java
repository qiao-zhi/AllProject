package com.thinkPro.steap.action.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		
		String userId = (String) session.getAttribute("userId");
		String specialistId = (String) session.getAttribute("specialistId");
		String path = servletRequest.getRequestURI();
		if (path.contains("logout") || path.equals("/Steap/") || path.contains("login") || path.contains("verify")) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		
		
		if (userId == null || userId.equals("")) {
			if ( specialistId == null || specialistId.equals("")) {
				servletResponse.sendRedirect("/Steap/admin/login/login.jsp");
			}else {
				chain.doFilter(servletRequest, servletResponse);
				return;
			}
		} else {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
