package it.brax.DbConnectWithProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main 
{
	private void run()
	{
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("dBConnection.properties"));
			String jdbcURL = props.getProperty("jdbcURL");
			String user = props.getProperty("user");
			String pass = props.getProperty("pass");
			
			Connection conn = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Connectio OK");
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			System.out.println("Connection NOK");
		}
	}
	
	
	public static void main(String args[])
	{
		Main m = new Main();
		m.run();
	}

}
