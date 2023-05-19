package dbConn.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {

	public static Connection getConnection() {
		Connection conn = null;
		try {

			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "jj", "oracle");
//				System.out.println("oracle connection success!!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return conn;
		}
	}

}