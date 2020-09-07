package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DeptDAO;
import com.bean.Dept;

public class deptlistServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	String userName=(String) req.getSession().getAttribute("userName");
//	if(null==userName) {
//		resp.sendRedirect("login.html");
//		return;
//	}
	int start=0;
	int count=10;
	int total=new DeptDAO().total();
	int last;
	if(total%count==0)
		last=total-count;
	else
		last=total-total%count;
	try {
		start=Integer.parseInt(req.getParameter("start"));
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	int next=start+count;
	int pre=start-count;
	pre=pre<0?0:pre;
	next=next>last?last:next;
	req.setAttribute("next", next);
	req.setAttribute("pre", pre);
	req.setAttribute("last", last);
	List<Dept> depts=new DeptDAO().list(start, count);
	req.setAttribute("depts", depts);
	req.getRequestDispatcher("/list.jsp").forward(req, resp);
}
}
