package com.market.dao;

import com.market.model.Staff;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDao extends BaseDao {

	public Staff login(Staff Staff){
		String sql = "select * from staff where name = ? and password = ?";
		Staff StaffRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, Staff.getName());
			prst.setString(2, Staff.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				StaffRst = new Staff();
				StaffRst.setId(executeQuery.getInt("id"));
				StaffRst.setName(executeQuery.getString("name"));
				StaffRst.setPassword(executeQuery.getString("password"));
				StaffRst.setEntryTime(executeQuery.getString("createDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StaffRst;
	}
}
