package com.hh.test.postgrestest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLJDBC { 
	
	
	public static Connection getConn(){
		 String driver = "org.postgresql.Driver";  
	        String url = "jdbc:postgresql://10.27.137.141:5432/postgres";  
	        String username = "postgres";  
	        String password = "postgres";  
	        Connection conn = null;  
	        try {  
	            Class.forName(driver); // classLoader,加载对应驱动  
	            conn = (Connection) DriverManager.getConnection(url, username, password);  
	        } catch (ClassNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        return conn;
	}
	
	
    public static void main(String args[]) {  
        Connection c = null;  
        Statement stmt = null;  
        try {  
            Class.forName("org.postgresql.Driver");  
            c = DriverManager.getConnection("jdbc:postgresql://10.27.137.141:5432/postgres", "postgres", "postgres");  
            c.setAutoCommit(false); // 把自动提交  
            System.out.println("Opened database successfully");  
  
            stmt = c.createStatement();   
            String sql = "CREATE TABLE STUDENTS " +   
                         "(ID TEXT PRIMARY KEY     NOT NULL ," +   
                         " NAME            TEXT    NOT NULL, " +   
                         " SEX             TEXT    NOT NULL, " +   
                         " AGE             TEXT    NOT NULL)";   
            stmt.executeUpdate(sql);   
            System.out.println("Table created successfully");  
              
            stmt.close();  
            c.commit();  
            c.close();  
        } catch (Exception e) {  
            System.err.println(e.getClass().getName() + ": " + e.getMessage());  
            System.exit(0);  
        }  
    } 
}