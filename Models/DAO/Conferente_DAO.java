package Models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Factory.ConnectionFactory;
import Models.Conferente;

public class Conferente_DAO {

	public List<Conferente> showConferente() throws ClassNotFoundException{
	
		String sql = "SELECT * FROM Conferente";
		
		List<Conferente> conferentes = new ArrayList<Conferente>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;//ResultSet usado para operações com SELECT
		
		try{
			conn = ConnectionFactory.createConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Conferente conferente = new Conferente();
				
				conferente.setName(rs.getString("nome"));
				
				conferentes.add(conferente);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
					if(ps != null) {
					ps.close();
					}
			
					if (conn != null) {
					conn.close();
					}
					
					if (rs != null) {
						rs.close();
					}
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conferentes;	
	}
	
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