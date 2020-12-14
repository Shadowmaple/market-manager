package com.market.model;

import com.market.dao.ProductDao;
import com.market.dao.SaleRecordDao;
import com.market.dao.StaffDao;

public class SaleRecord {
	private int id;
	private int staffId;
	private int productId;
	private int number; // 数量
	private float money; // 销售总金额
	private int stratey; // 销售策略
	private String createTime; // 销售时间
	
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
		staff = staffDao.getStaffById(id);
		return staff.getName();
	}

	public String getProductName() {
		Product product = new Product();
		ProductDao productDao = new ProductDao();
		product = productDao.getStaffById(id);
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
	public static SaleRecord getRecordById(int id) {
		var dao = new SaleRecordDao();
		return dao.getSaleRecord(id);
	}
}