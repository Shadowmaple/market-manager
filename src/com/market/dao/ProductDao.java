package com.market.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.market.model.Product;
import com.market.model.Product;

public class ProductDao extends BaseDao {

	public Product getProduct(String name) {
		String sqlString = "select * from goods where goods_name = ?";
		Product p = null;
		try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            ResultSet executeQuery = preparedStatement.executeQuery();

            if(executeQuery.next()){
            	p = new Product();
                p.setId(executeQuery.getInt("goods_id"));
                p.setName(executeQuery.getString("goods_name"));
                p.setNum(executeQuery.getInt("goods_num"));
                p.setPrice(executeQuery.getFloat("sell_price"));
                p.setPrice(executeQuery.getFloat("pur_price"));
                p.setStratey(executeQuery.getInt("stratey"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return p;
	}

	public List<Product> getProductList(Product product) {
        List<Product> retList = new ArrayList<Product>();
        String sqlString = "select * from goods";
        if (!product.getName().equals("")) {
        	sqlString += " where goods_name = '" + product.getName() + "'";
        }
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while(executeQuery.next()){
                Product p = new Product();
                p.setId(executeQuery.getInt("goods_id"));
                p.setName(executeQuery.getString("goods_name"));
                p.setNum(executeQuery.getInt("goods_num"));
                p.setPrice(executeQuery.getFloat("sell_price"));
                p.setPrice(executeQuery.getFloat("pur_price"));
                p.setStratey(executeQuery.getInt("stratey"));
                retList.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retList;
    }

	public Product getProductById(int id) {
		if (id == 0) return null;

		Product p = null;
		String sqlString = "select * from goods where goods_id = '" + id + "'";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);
            ResultSet executeQuery = preparedStatement.executeQuery();
            if (executeQuery.next()) {
                p = new Product();
                p.setId(executeQuery.getInt("goods_id"));
                p.setName(executeQuery.getString("goods_name"));
                p.setNum(executeQuery.getInt("goods_num"));
                p.setPrice(executeQuery.getFloat("sell_price"));
                p.setPrice(executeQuery.getFloat("pur_price"));
                p.setStratey(executeQuery.getInt("stratey"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return p;
	}
}