package util;

import java.sql.Connection;
import java.sql.DriverManager;

// TODO: Auto-generated Javadoc
/**
 * The Class Conexao.
 */
public class Conexao {
	
	/** The driver. */
	private static String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private static String url = "jdbc:mysql://localhost/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private static String user = "root";
	
	/** The password. */
	private static String password = "";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
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
