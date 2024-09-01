package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String USERNAME = "root";

	private static final String PASSWORD = "123456";

	private static final String URL = "jdbc:mysql://localhost:3306/conferencia";

	
	public static Connection createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = createConnection();
		
		if (con != null) {
			System.out.println("Conexão estabelecida");
			con.close();
		}
	}
}
