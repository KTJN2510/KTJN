package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=req.getParameter("user");
		String pwd=req.getParameter("pwd");
		if("admin".equals(user)&&"123456".equals(pwd)){
			req.getSession().setAttribute("userName", user);
            resp.sendRedirect("deptlist");
		}else {
			resp.sendRedirect("login.html");
		}
	}

}
