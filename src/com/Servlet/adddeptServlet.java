package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DeptDAO;
import com.bean.Dept;

public class adddeptServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		req.setCharacterEncoding("utf-8");
		String userName=req.getParameter("user");
		int total=new DeptDAO().total();
		System.out.println(total);
		Dept dept=new Dept(total+1, userName);
		new DeptDAO().add(dept);
		resp.sendRedirect("deptlist");
	}

}
