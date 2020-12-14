package com.market.model;

public class Plan {
	private int id;
	private int productId;
	private String productName;
	private int num; // 进货量
	private float price; // 进货单价

	public int getId() {
		return id;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public int getNum() {
		return num;
	}

	public float getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProductId(int id) {
		this.productId = id;
	}

	public void setProductName(String name) {
		this.productName = name;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}