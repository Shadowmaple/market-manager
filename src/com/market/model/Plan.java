package com.market.model;

public class Plan {
	private int id;
	private String name;
	private int num; // 进货量
	private float price; // 进货单价
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
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
	
	public void setName(String name) {
		this.name = name;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}