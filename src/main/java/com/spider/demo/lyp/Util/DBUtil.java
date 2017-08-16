package com.spider.demo.lyp.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3307/test";
	private static String USERNAME="root";
	private static String PASSWORD="";
	private Connection conn=null;
	private PreparedStatement preparedStatement =null;
	private ResultSet resultSet =null;
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("连接失败");
			e.printStackTrace();
		}
	}
	/**
	 * @return
	 */
	public Connection getConn(){
		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public int executeUpdate(String sql,Object[] params){
		int affectedLines=0;
		try {
			conn=this.getConn();
			preparedStatement =conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					preparedStatement.setObject(i+1,params[i]);
				}
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		try {
			affectedLines=preparedStatement.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return affectedLines;
		
	}
    public ResultSet executeQueryRS(String sql, Object[] params) {  
        try {  
            conn = this.getConn();  
            preparedStatement = conn.prepareStatement(sql);  
            if (params != null) {  
                for (int i = 0; i < params.length; i++) {  
                    preparedStatement.setObject(i + 1, params[i]); 
                }  
            }  
            resultSet = preparedStatement.executeQuery();  
  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
  
        return resultSet;  
    }  
	public void closeAll(){
		
		if(preparedStatement!=null){
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
		

