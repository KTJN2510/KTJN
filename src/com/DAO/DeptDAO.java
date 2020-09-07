package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Dept;

public class DeptDAO {
	private static final String DBurl="jdbc:mysql://localhost:3306/day16?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT";
	private static final String DBdriver="com.mysql.cj.jdbc.Driver";
	private static final String DBuser="root";
	private static final String DBpwd="251070";
	public Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(DBdriver);
			conn=DriverManager.getConnection(DBurl, DBuser, DBpwd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	public int total() {
		int total=0;
		String sql="select count(1) from testindex";
		try {
			Connection conn=getConnection();
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()) {
				total=rs.getInt(1);
			}
//			System.out.println("total:"+total);
			conn.close();
			stat.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return total;
	}
	public List<Dept> list(int start,int count){
		List<Dept> depts=new ArrayList<Dept>();
		String sql="select id,tname from testindex limit ?,?";
		try {
			Connection conn=getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				depts.add(new Dept(id, name));
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return depts;
	}
	public Dept getbyid(int id) {
		Dept dept=new Dept();
		String sql="select id,tname from testindex where id="+id;
		try {
			Connection conn=getConnection();
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			if(rs.next()) {
				String name=rs.getString(2);
				dept.setId(id);
				dept.setName(name);
			}else
			{
				System.out.println("没有找到!");
			}
			conn.close();
			stat.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dept;
	}
	public void delete(int id) {
		String sql="delete from testindex where id="+id;
		try {
			Connection conn=getConnection();
			Statement stat=conn.createStatement();
			stat.executeUpdate(sql);
			System.out.println("删除成功！");
			conn.close();
			stat.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public void update(Dept dept) {
		String sql="update testindex set tname=? where id=?";
		try {
			Connection conn=getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, dept.getName());
			ps.setInt(2, dept.getId());
			ps.executeUpdate();
			System.out.println("更新成功！");
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public void add(Dept dept) {
		String sql="insert into testindex values(?,?)";
		try {
			Connection conn=getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(2, dept.getName());
			ps.setInt(1, dept.getId());
			ps.executeUpdate();
			System.out.println("添加成功！");
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
