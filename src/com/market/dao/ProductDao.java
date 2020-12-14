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
		String sqlString = "select * from goods where name = ?";
		Product p = null;
		try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            ResultSet executeQuery = preparedStatement.executeQuery();            

            if(executeQuery.next()){
            	p = new Product();
                p.setId(executeQuery.getInt("id"));
                p.setName(executeQuery.getString("name"));
                p.setNum(executeQuery.getInt("num"));
                p.setPrice(executeQuery.getFloat("price"));
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
        	sqlString += " where name = '" + product.getName() + "'";
        }
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while(executeQuery.next()){
                Product p = new Product();
                p.setId(executeQuery.getInt("id"));
                p.setName(executeQuery.getString("name"));
                p.setNum(executeQuery.getInt("num"));
                p.setPrice(executeQuery.getFloat("price"));
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
		String sqlString = "select * from goods where id = '" + id + "'";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);
            ResultSet executeQuery = preparedStatement.executeQuery();
            if (executeQuery.next()) {
                p = new Product();
                p.setId(executeQuery.getInt("id"));
                p.setName(executeQuery.getString("name"));
                p.setNum(executeQuery.getInt("num"));
                p.setPrice(executeQuery.getFloat("price"));
                p.setStratey(executeQuery.getInt("stratey"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return p;
	}	
}