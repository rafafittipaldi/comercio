package edu.infnet.comercio.negocio;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
	
	private static Connection con;
	
	private MySqlConnection() {}
	
	public static Connection getConnection() {
		
		if (con == null) {
			String url = "jdbc:mysql://localhost:3306/comercio"
					+ "?useTimezone=true"
					+ "&serverTimezone=UTC"
					+ "&createDatabaseIfNotExist=true";
			
			String user = "root";
			String pass = "";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection(url, user, pass);
				System.out.println("Database iniciou");
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		}
		return con;
	}
}
