package com.market.model;

// 进货记录
public class PurchaseRecord {
	private int id;
	private int staffId;
	private int productId;
	private int number; // 进货量
	private int price; // 进货单价
	private float money; // 进货总价
	private String createTime; // 进货时间
}