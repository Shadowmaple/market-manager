package com.market.model;

import java.util.Map;

import com.market.dao.StaffDao;
import com.sun.org.apache.xpath.internal.operations.Equals;
import com.sun.tools.javadoc.main.TypeMaker;

import jdk.nashorn.internal.codegen.TypeMap;

public class Staff {
	private int id;
	private String name;
	private String password;
	private int type;
	private String entryTime;
	
	private static String[] typeMap = {"收银员", "进货员", "管理员"};

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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String time) {
		this.entryTime = time;
	}

	public static String getNameById(int id) {
		StaffDao d = new StaffDao();
		var staff = d.getStaffById(id);
		if (staff == null) return "";
		return staff.getName();
	}

	public String getTypeForRole() {
		return typeMap[type];
	}
	
	public static int gettypeIntByRoleStr(String s) {
		for (int i = 0; i < 3; i++) {
			if (s.equals(typeMap[i])) {
				return i;
			}
		}
		return -1;
	}
}