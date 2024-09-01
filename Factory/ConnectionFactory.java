package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String USERNAME = "root";

	private static final String PASSWORD = "123456";

	private static final String URL = "jdbc:mysql://localhost:3306/conferencia?allowPublicKeyRetrieval=true&useSSL=false";

	
	public static Connection createConnection() throws SQLException, ClassNotFoundException {
		  return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		  //atualizei o driver, não sendo mais necessário as linhas de codigo para carregar o driver
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {	
		 try {
	            Connection con = createConnection();
	            if (con != null) {
	                System.out.println("Conexão estabelecida");
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
}
