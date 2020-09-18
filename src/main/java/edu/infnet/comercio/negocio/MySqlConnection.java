package edu.infnet.comercio.negocio;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MySqlConnection {
	
	private static Logger logger  = LogManager.getLogger(MySqlConnection.class);
	
	private static Connection con;
	
	private MySqlConnection() {}
	
	public static Connection getConnection() {
		
		if (con == null) {
			String url = "jdbc:mysql://localhost:3306/comercio"
					+ "?useTimezone=true"
					+ "&serverTimezone=UTC"
					+ "&createDatabaseIfNotExist=true";
			
			String user = "root";
			String pass = "root";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection(url, user, pass);
				logger.info("Banco iniciou");
				return con;
			} catch (Exception e) {
				logger.error("Erro ao obter conexao", e);
				throw new RuntimeException("Erro ao obter conexao", e);
			}
		}
		return con;
	}
}
