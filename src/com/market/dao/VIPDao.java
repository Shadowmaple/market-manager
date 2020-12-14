package com.market.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.market.model.Plan;
import com.market.model.VIP;

public class VIPDao extends BaseDao {

	public boolean create(VIP vip) {
		String sqlString = "insert into vip(VIP_name, VIP_money, createtime, validitytime, is_use) "
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
	
	public boolean updateValidityTime(VIP vip) {
		String sqlString = "update vip set validitytime = ? where id = ?";
		
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, vip.getValidityTime()));
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

		String sqlString = "update vip set is_use = 0 where id = ?";

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