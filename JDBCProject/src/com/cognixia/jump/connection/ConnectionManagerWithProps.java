package com.cognixia.jump.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManagerWithProps {
	
	private static Connection connection = null;
	
	private static void makeConnection() {
		Properties props = new Properties();
		
		
		try {
			props.load( new FileInputStream("resources/config.properties"));

			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			
			connection = DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			System.out.println("Could not make connection.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		if (connection == null) {
			makeConnection();
		}
		
		return connection;
	}
	
}
