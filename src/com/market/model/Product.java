package com.market.model;

import com.market.dao.ProductDao;

public class Product {
	private int id;
	private String name;
	private int num; // 库存量
	private float price;
	private int stratey; // 营销策略，打几折，默认为100
	
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

	// 判断库存状态
	public String judgeRepoCondition() {
		if (num >= 500) {
			return "库存过剩";
		} else if (num >= 50) {
			return "正常";
		} else if (num > 0) {
			return "少货";
		}
		return "缺货";
	}

	// 根据 id 获取 name
	public static String getNameById(int id) {
		ProductDao d = new ProductDao();
		var p = d.getProductById(id);
		if (p == null) return "";
		return p.getName();
	}

	public static Product getById(int id) {
		ProductDao d = new ProductDao();
		var p = d.getProductById(id);
		return p;
	}
}
