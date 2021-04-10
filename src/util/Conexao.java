package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/dbagenda?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "";

	public static Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
