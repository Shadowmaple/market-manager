package com.market.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private String url="jdbc:mysql://localhost:3306/market?useUnicode=true&characterEncoding=utf8";
	private String username="root"; // 用户名
	private String password="root"; // 密码
	private String jdbcName="com.mysql.jdbc.Driver"; // 驱动名

	public Connection getCon(){
		try {
			Class.forName(jdbcName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// 关闭数据库连接
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}

	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("DB连接成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("连接失败");
		}
	}
}
