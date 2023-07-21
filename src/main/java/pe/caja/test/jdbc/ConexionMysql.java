package pe.caja.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMysql {
	static final String USER = "admin";
	static final String PASS = "12345678";

	public Connection obtenerConexion() throws SQLException, ClassNotFoundException {
		// STEP 2: Register JDBC driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// STEP 3: Open a connection
		System.out.println("Connecting to database...");
		String DB_URL = "jdbc:mysql://test.ceqkaakfharr.us-east-2.rds.amazonaws.com/test";

		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		// STEP 4: Execute a query
		System.out.println("Se conecto a nuestra base de datos...");

		return conn;

	}
}
