package com.market.model;

import com.market.dao.ProductDao;
import com.market.dao.SaleRecordDao;
import com.market.dao.StaffDao;

public class SaleRecord {
	private static int num = 1;
	private int id;
	private int staffId;
	private int productId;
	private int number; // 数量
	private float money; // 销售总金额
	private float profit;//销售总利润
	private int stratey; // 销售策略
	private String createTime; // 销售时间
	private String belong;
	
	public static void setNum() {
		num++;
	}
	public SaleRecord() {
		belong = "2020";
		belong = belong + num;
	}

	public float getProfit() {
		return profit;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public int getId() {
		return id;
	}

	public int getStaffId() {
		return staffId;
	}

	public int getProductId() {
		return productId;
	}

	public String getStaffName() {
		Staff staff = new Staff();
		StaffDao staffDao = new StaffDao();
		staff = staffDao.getStaffById(staffId);
		return staff.getName();
	}

	public String getProductName() {
		var productDao = new ProductDao();
		var product = productDao.getProductById(productId);
		if (product == null) return "";
		return product.getName();
	}

	public int getNumber() {
		return number;
	}

	public float getMoney() {
		return money;
	}

	public int getStratey() {
		return stratey;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setNumber(int num) {
		this.number = num;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public void setStratey(int stratey) {
		this.stratey = stratey;
	}

	public void setCreateTime(String time) {
		this.createTime = time;
	}

	// 根据 id 查询记录
	public static SaleRecord getRecordById(String belong,int id) {
		var dao = new SaleRecordDao();
		return dao.getSaleRecord(belong,id);
	}
}