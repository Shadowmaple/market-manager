package com.market.dao;

import com.market.model.Staff;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDao extends BaseDao {

	public Staff login(Staff staff) {
		String sql = "select * from staff where name = ? and password = ?";
		Staff StaffRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, staff.getName());
			prst.setString(2, staff.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()) {
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

	// 创建新员工
	public boolean create(Staff staff) {
		String sql = "insert into staff(name, password, type) values(?, ?, ?)";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, staff.getName());
			prst.setString(2, staff.getPassword());
			prst.setInt(3, staff.getType());
			ResultSet executeQuery = prst.executeQuery();
		
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Staff> getStaffList(Staff staff) {
        List<Staff> retList = new ArrayList<Staff>();
        String sqlString = "select * from staff";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while(executeQuery.next()){
                Staff s = new Staff();
                s.setId(executeQuery.getInt("id"));
                s.setName(executeQuery.getString("name"));
                s.setType(executeQuery.getInt("type"));
                s.setEntryTime(executeQuery.getString("entry_time"));
                retList.add(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retList;
    }
	
	public Staff getStaffById(int id) {
		if (id == 0) return null;
	
		Staff staff = null;
		String sqlString = "select * from staff where id = '" + id + "'";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);
            ResultSet executeQuery = preparedStatement.executeQuery();
            if (executeQuery.next()) {
                staff = new Staff();
                staff.setId(executeQuery.getInt("id"));
                staff.setName(executeQuery.getString("name"));
                staff.setType(executeQuery.getInt("type"));
                staff.setEntryTime(executeQuery.getString("entry_time"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return staff;
	}
}
