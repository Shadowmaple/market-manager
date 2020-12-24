package com.market.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.market.model.Plan;
import com.market.model.Product;
import com.market.model.VIP;

public class VIPDao extends BaseDao {

	public boolean create(VIP vip) {
		String sqlString = "insert into VIP(VIP_name, VIP_money, createtime, validitytime, is_use) "
				+ "values(?, 0, ?, ?, 1)";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, vip.getName());
            ps.setString(2,  vip.getCreateTime());
            ps.setString(3, vip.getValidityTime());
            if(ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}

	public VIP getVIPById(int id) {
		VIP vip = null;
		String sqlString = "select * from VIP where VIP_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1, id);
            ResultSet executeQuery = ps.executeQuery();

            if(executeQuery.next()){
            	vip = new VIP();
                vip.setId(executeQuery.getInt("VIP_id"));
                vip.setName(executeQuery.getString("VIP_name"));
                vip.setMoney(executeQuery.getFloat("VIP_money"));
                vip.setCreateTime(executeQuery.getString("createtime"));
                vip.setValidityTime(executeQuery.getString("validitytime"));
                vip.setIsUse(executeQuery.getInt("is_use"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return vip;
	}
	
	public VIP getVIPByName(String name) {
		VIP vip = null;
		String sqlString = "select * from VIP where VIP_name = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, name);
            ResultSet executeQuery = ps.executeQuery();

            if(executeQuery.next()){
            	vip = new VIP();
                vip.setId(executeQuery.getInt("VIP_id"));
                vip.setName(executeQuery.getString("VIP_name"));
                vip.setMoney(executeQuery.getFloat("VIP_money"));
                vip.setCreateTime(executeQuery.getString("createtime"));
                vip.setValidityTime(executeQuery.getString("validitytime"));
                vip.setIsUse(executeQuery.getInt("is_use"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return vip;
	}

	public boolean updateValidityTime(VIP vip) {
		String sqlString = "update VIP set validitytime = ? where VIP_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, vip.getValidityTime());
            ps.setInt(2,  vip.getId());
            if(ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}
	
	// 更新消费金额
	public boolean updateConsumeMoney(VIP vip) {
		String sqlString = "update VIP set VIP_money = ? where VIP_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setFloat(1, vip.getConsumeMoney());
            ps.setInt(2,  vip.getId());
            if(ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}

	// 注销会员卡，软删除，将 is_use 设为 0
	public boolean delete(int id) {
		if (id == 0) {
			return false;
		}

		String sqlString = "update VIP set is_use = 0 where VIP_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1, id);
            if(ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}
}