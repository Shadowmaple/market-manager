package com.market.model;

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
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String time) {
		this.entryTime = time;
		
	}
}