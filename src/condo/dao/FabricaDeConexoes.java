package condo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			// return DriverManager.getConnection("jdbc:mysql://localhost/condoweb", "root",
			// "");
			return DriverManager.getConnection("jdbc:mysql://www.qualitysys.com.br:3300/condoweb", "root",
					"senha@1234");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
