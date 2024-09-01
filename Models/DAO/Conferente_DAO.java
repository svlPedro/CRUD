package Models.DAO;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Factory.ConnectionFactory;
import Models.Conferente;

public class Conferente_DAO {

	public void addConferente(Conferente conferente) throws ClassNotFoundException {
		String sql = "INSERT INTO Conferente (nome) VALUES (?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
	
		try {
			conn = ConnectionFactory.createConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setString(1, conferente.getName());
			
			ps.execute();//executar query
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//Fechar conexões
			try {
					if(ps != null) {
						ps.close();
				}
				
					if (conn != null) {
						conn.close();
				}
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
			}	
		}
	
	public void removeConferente(Conferente conferente) throws ClassNotFoundException {
		String sql = "DELETE FROM Conferente WHERE nome = (?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
	
		try {
			conn = ConnectionFactory.createConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setString(1, conferente.getName());
			
			ps.execute();//executar query
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//Fechar conexões
			try {
					if(ps != null) {
						ps.close();
				}
				
					if (conn != null) {
						conn.close();
				}
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}	
	}
}