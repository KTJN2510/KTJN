package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DeptDAO;
import com.bean.Dept;

public class editdeptServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	int id=Integer.parseInt(req.getParameter("id"));
	Dept dept=new DeptDAO().getbyid(id);
	req.setAttribute("dept", dept);
	req.getRequestDispatcher("editdept.jsp").forward(req, resp);
}
}
