package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse resp=(HttpServletResponse) arg1;
		String uri=req.getRequestURI();
		if(uri.endsWith(".css")||uri.endsWith(".js")) {
			arg2.doFilter(req, resp);
			return;
		}
		if(uri.endsWith("login.html")||uri.endsWith("LoginServlet")) {
			arg2.doFilter(req, resp);
			return;
		}
		String userName=(String) req.getSession().getAttribute("userName");
		if(null==userName) {
			resp.sendRedirect("login.html");
			return;
		}
		arg2.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
