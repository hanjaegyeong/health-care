package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {

	//jdbc_test테이블
	private static String url = "jdbc:mysql://127.0.0.1:3306/jdbc_test?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static String user = "";
	private static String pwd = "";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void releaseConnection(PreparedStatement pstmt, Connection con) { //prepareStatement에 쿼리 전달해서 컴파일

		try {
			if(pstmt != null ) { pstmt.close(); }
			if(con != null ) { con.close(); } //커넥션 객체는 반드시 반납
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// for Statement / insert2()
	public static void releaseConnection(Statement stmt, Connection con) {

		try {
			if(stmt != null ) { stmt.close(); }
			if(con != null ) { con.close(); }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void releaseConnection(ResultSet rs, PreparedStatement pstmt, Connection con) {

		try {
			if(rs != null ) { rs.close(); }
			if(pstmt != null ) { pstmt.close(); }
			if(con != null ) { con.close(); }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// ... 표현식 사용
//	public void releaseConnection(AutoCloseable... params) {
//		for(AutoCloseable c: params) {
//			if (c != null) {
//				try {
//					c.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
}
