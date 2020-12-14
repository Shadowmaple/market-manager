package com.market.model;

import com.market.dao.StaffDao;

public class Staff {
	private int id;
	private String name;
	private String password;
	private int type;
	private String entryTime;
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
		this.name = password;
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
}