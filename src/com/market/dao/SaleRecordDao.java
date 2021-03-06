package com.market.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.market.model.Product;
import com.market.model.SaleRecord;

public class SaleRecordDao extends BaseDao {

	public List<SaleRecord> getSaleRecordList(SaleRecordDao record) {
        List<SaleRecord> retList = new ArrayList<SaleRecord>();
        String sqlString = "select * from sale_record";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while(executeQuery.next()){
                SaleRecord s = new SaleRecord();
                s.setId(executeQuery.getInt("sale_id"));
                s.setNumber( executeQuery.getInt("number"));
                s.setProductId(executeQuery.getInt("goods_id"));
                s.setStaffId(executeQuery.getInt("staff_id"));
                s.setMoney(executeQuery.getInt("money"));
                s.setStratey(executeQuery.getInt("stratey"));
                s.setCreateTime(executeQuery.getString("createtime"));
                retList.add(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retList;
    }

	public boolean create(SaleRecord record) {
		String sqlString = "insert into sale_record(staff_id, goods_id, number, money, stratey, createtime,profit,belong) values(?, ?, ?, ?, ?, ?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1, record.getStaffId());
            ps.setInt(2,  record.getProductId());
            ps.setInt(3,  record.getNumber());
            ps.setFloat(4, record.getMoney());
            ps.setInt(5, record.getStratey());
            ps.setString(6,  record.getCreateTime());
            ps.setFloat(7,record.getProfit());
            ps.setString(8,record.getBelong());
            if(ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}

	public SaleRecord getSaleRecord(String belong,int id) {
		String sqlString = "select * from sale_record where belong = ? and goods_id = ?";
		SaleRecord s = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);
            preparedStatement.setString(1,belong);
            preparedStatement.setInt(2, id);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while(executeQuery.next()){
                s = new SaleRecord();
                s.setId(executeQuery.getInt("sale_id"));
                s.setNumber( executeQuery.getInt("number"));
                s.setProductId(executeQuery.getInt("goods_id"));
                s.setStaffId(executeQuery.getInt("staff_id"));
                s.setMoney(executeQuery.getInt("money"));
                s.setStratey(executeQuery.getInt("stratey"));
                s.setCreateTime(executeQuery.getString("createtime"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s;
	}

	public boolean delete(String belong,int id) {
		String sqlString = "delete from sale_record where belong = ? and goods_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,belong);
            ps.setInt(2, id);
            if(ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}

	public List<SaleRecord> searchSaleRank(String beginTime, String endTime) {
		List<SaleRecord> retList = new ArrayList<SaleRecord>();
        String sqlString = "select goods_id, sum(number) as num, sum(money) as money from "
        		+ "sale_record where createtime >= ? and createtime <= ? "
        		+ "group by goods_id order by sum(money) desc";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, beginTime);
            ps.setString(2, endTime);
            ResultSet executeQuery = ps.executeQuery();
            while(executeQuery.next()){
                SaleRecord s = new SaleRecord();
                s.setNumber( executeQuery.getInt("num"));
                s.setProductId(executeQuery.getInt("goods_id"));
                s.setMoney(executeQuery.getInt("money"));
                retList.add(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retList;
	}
}