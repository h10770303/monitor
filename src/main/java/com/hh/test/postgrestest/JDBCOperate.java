package com.hh.test.postgrestest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hh.test.pojo.Student;

public class JDBCOperate {
	
	/**
	 * add
	 * 
	 */
	public int insert(Student stu){
		Connection conn=PostgreSQLJDBC.getConn();
		String sql="insert into students (id,Name,Sex,Age) values(?,?,?,?)";
		PreparedStatement pst;
		int reuslt=0;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, stu.getId());
			pst.setString(2, stu.getName());
			pst.setString(3, stu.getSex());
			pst.setString(4, stu.getAge());
			reuslt=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reuslt;
	}
	
	/**
	 * delete
	 * @param args
	 * @throws SQLException 
	 */
	public int delete () throws RuntimeException, SQLException{
		Connection conn=PostgreSQLJDBC.getConn();
		String sql="delete from students";
		int i=0;
		PreparedStatement pst;
			pst = (PreparedStatement) conn.prepareStatement(sql);
			i = pst.executeUpdate();  
			System.out.println("resutl: " + i);  
			pst.close();  
			conn.close();  
		 return i;
	}

	
	
	public static void main(String[] args) {

		Student stu=new Student();
		stu.setId("344343");
		stu.setName("胡明伟");
		stu.setSex("男");
		stu.setAge("33");
		JDBCOperate jdbcOperate=new JDBCOperate();
		jdbcOperate.insert(stu);
//		jdbcOperate.delete();
	}
}
