package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DeptDAO;
import com.bean.Dept;

public class updatedeptServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	req.setCharacterEncoding("utf-8");
	int id=Integer.parseInt(req.getParameter("id"));
	String userName=req.getParameter("user");
	Dept dept=new Dept(id, userName);
	new DeptDAO().update(dept);
	resp.sendRedirect("deptlist");
}
}
