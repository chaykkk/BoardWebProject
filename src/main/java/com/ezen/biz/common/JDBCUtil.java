package com.ezen.biz.common;

import java.sql.*;

public class JDBCUtil {
	// 오라클 데이터에 연결하는 메소드
	public static Connection getConnection() {
		Connection conn = null;
		String url = "Jdbc:oracle:thin:@localhost:1521:XE";
		String uid = "spring_user";
		String pass = "ora123";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pass);
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		return conn;
	}
	
	// UPDATE, INSERT, DELETE 연결 해지에 사용하는 메소드
	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// SELECT 연결 해지에 사용하는 메소드
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
