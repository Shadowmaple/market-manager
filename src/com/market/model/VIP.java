package com.market.model;

import com.market.dao.StaffDao;

public class VIP {
	private int id;
	private String name; // 暂时不使用
	private float money; // 消费金额
	private String createTime; // 发放时间
	private String validityTime; // 有效截止时间
	private Boolean isUse; // 是否在使用
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public float getConsumeMoney() {
		return money;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	
	public String getValidityTime() {
		return validityTime;
	}
	
	public Boolean getIsUse() {
		return isUse;
	}
	
	public static String getNameById(int id) {
		StaffDao d = new StaffDao();
		var staff = d.getStaffById(id);
		if (staff == null) return "";
		return staff.getName();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMoney(float money) {
		this.money = money;
	}
	
	public void setCreateTime(String time) {
		this.createTime = time;
	}
	
	public void setValidityTime(String time) {
		this.validityTime = time;
	}
	
	public void setIsUse(boolean use) {
		this.isUse = use;
	}
	
	// to do
	public static boolean checkValid(int id) {
		return true;
	}
}