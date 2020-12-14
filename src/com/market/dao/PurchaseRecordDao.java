package com.market.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.market.model.PurchaseRecord;

public class PurchaseRecordDao extends BaseDao {

	public List<PurchaseRecord> getPurchaseRecordList(PurchaseRecord record) {
        List<PurchaseRecord> retList = new ArrayList<PurchaseRecord>();
        String sqlString = "select * from pur_record";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while(executeQuery.next()){
                PurchaseRecord p = new PurchaseRecord();
                p.setId(executeQuery.getInt("pur_id"));
                p.setStaffId(executeQuery.getInt("staff_id"));
                p.setProduceId(executeQuery.getInt("goods_id"));
                p.setNum(executeQuery.getInt("number"));
                p.setPrice(executeQuery.getFloat("price"));
                p.setMoney(executeQuery.getFloat("money"));
                p.setCreateTime(executeQuery.getString("createtime"));
                retList.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retList;
    }

	public boolean create(PurchaseRecord record) {
		if (record == null) return false;

		String sqlString = "insert into sale_record(staff_id, goods_id, number, price, money, createtime) values(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1, record.getStaffId());
            ps.setInt(2,  record.getProductId());
            ps.setInt(3,  record.getNum());
            ps.setFloat(4,  record.getPrice());
            ps.setFloat(5, record.getMoney());
            ps.setString(6, record.getCreateTime());
            if(ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}
}