package com.mycompany.b66b80;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:testdb.db";

    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void initlizeDatabase() {
		String sql = "CREATE TABLE IF NOT EXISTS Users(" +
					 " Id INTEGER PRIMARY KEY AUTOINCREMENT," +
					 " Name TEXT NOT NULL," +
					 "Age INTEGER)";
		try (Connection conn = getConnection();
			Statement stmt = conn.createStatement()) {
				stmt.execute(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
