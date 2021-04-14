package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnection() throws SQLException{
		String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=rootpsw";
		return DriverManager.getConnection(jdbcURL);
	}

}
