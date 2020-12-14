package com.market.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.market.model.Plan;

public class PlanDao extends BaseDao {

	public List<Plan> getPlanList(Plan plan) {
        List<Plan> retList = new ArrayList<Plan>();
        String sqlString = "select * from pur_plan";
        if (plan != null && !plan.getName().equals("")) {
        	sqlString += "where name = '" + plan.getName() + "'";
        }

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while(executeQuery.next()){
                Plan p = new Plan();
                p.setId(executeQuery.getInt("id"));
                p.setName(executeQuery.getString("name"));
                p.setNum(executeQuery.getInt("number"));
                p.setPrice(executeQuery.getFloat("price"));
                retList.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retList;
    }

	public boolean create(Plan plan) {
		String sqlString = "insert into pur_plan(name, number, price) values(?, ?, ?)";
		
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, plan.getName());
            ps.setInt(2,  plan.getNum());
            ps.setFloat(3,  plan.getPrice());
            if(ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}
	
	public boolean update(Plan plan) {
		if (plan.getId() == 0) {
			return false;
		}
		
		String sqlString = "update pur_plan set name = ?, number = ?, price = ? where id = ?";
		
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, plan.getName());
            ps.setInt(2,  plan.getNum());
            ps.setFloat(3,  plan.getPrice());
            ps.setInt(4, plan.getId());
            if(ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}

	public boolean delete(int id) {
		if (id == 0) {
			return false;
		}

		String sqlString = "delete from pur_plan where id = ?";
		
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