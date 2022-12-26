package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection() throws Exception {
		// 드라이버 로딩
		Class.forName("org.mariadb.jdbc.Driver");
		// 드라이버 연결
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mvc", "root", "wkqk1234");
		return conn;
	}
}

