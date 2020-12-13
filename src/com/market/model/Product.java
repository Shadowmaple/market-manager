package com.market.model;

public class Product {
	private int id;
	private String name;
	private int num; // 库存量
	private float price;
	private int stratey; // 营销策略
	
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
	
	public int getStratey() {
		return stratey;
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
	
	public void setStratey(int stratey) {
		this.stratey = stratey;
	}
}
