package ro.emanuel.book.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
	
	public static Connection conn; // asta ei o variabila ce o sa o folosim pt conexiunea la bd
	
	// Metoda asta deschide conexiunea la bd
	public static Connection getConnection() throws SQLException {
		
		if(conn == null || conn.isClosed()) {
			Properties connectionProps = new Properties();
			connectionProps.put("user", "root");
			connectionProps.put("password", "");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop2024", connectionProps);
		}
		return conn;
	}
	
	// Metoda asta inchide connexiunea cu bd
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}