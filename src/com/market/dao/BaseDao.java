package com.market.dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.market.util.DbUtil;

public class BaseDao {
	public Connection con = new DbUtil().getCon();
	public void closeDao(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
