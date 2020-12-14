package com.market.model;

// 进货记录
public class PurchaseRecord {
	private int id;
	private int staffId;
	private int productId;
	private int number; // 进货量
	private float price; // 进货单价
	private float money; // 进货总价
	private String createTime; // 进货时间

	public int getId() {
		return id;
	}
	
	public int getStaffId() {
		return staffId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public int getNum() {
		return number;
	}
	
	public float getPrice() {
		return price;
	}
	
	public float getMoney() {
		return money;
	}
	
	public String getCreateTime() {
		return createTime;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setStaffId(int id) {
		this.staffId = id;
	}
	
	public void setProduceId(int id) {
		this.productId = id;
	}
	
	public void setNum(int num) {
		this.number = num;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public void setCreateTime(String time) {
		this.createTime = time;
	}

}