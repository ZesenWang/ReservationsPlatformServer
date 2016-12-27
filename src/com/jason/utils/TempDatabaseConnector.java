package com.jason.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class TempDatabaseConnector {
	String url = "jdbc:sqlserver://localhost:1433;" +
        "databaseName=IS_01;";
	String username = "sa";
	String password = "sasasa";
	public boolean writeSignUpInformation(String pName, String pPwd, String pSex,
			String pID_card,String pInsuarnace_card, String pInsurance_type){
		String sql = "INSERT INTO Patient_information_of_menzhen VALUES"
				+ "('"+pName+"','"+ pPwd+"',' "+pSex+"',' "+pID_card+"',' "+pInsuarnace_card+"',' "+pInsurance_type+"')";
		executeSQL(sql);
		return true;
	}
	public boolean writeReservationInformation(String PID, String PName, String CDocName){
		String sql = "INSERT INTO exLine VALUES"
				+ "('"+PID+"','"+PName+"','0','"+CDocName+"')";
		executeSQL(sql);
		return true;
	}
	public boolean deleteReservationInformation(String PID){
		String sql = "DELETE FROM exLine WHERE PID = '"+PID+"'";
		executeSQL(sql);
		return true;
	}
	public Vector queryReservationInformation(String PID){
		//String sql = "SELECT";
		//ResultSet set = (ResultSet)executeSQL(sql);
		return null;
	}
	public Object executeSQL(String sql){
		Connection conn = null;
		Statement statement = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, password);
			statement = conn.createStatement();
			ResultSet set;
			if(sql.startsWith("SELECT")){
				set = statement.executeQuery(sql);
				return set;
			}else{
				statement.execute(sql);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
