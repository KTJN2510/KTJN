package com.bean;

public class Dept {
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Dept(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
