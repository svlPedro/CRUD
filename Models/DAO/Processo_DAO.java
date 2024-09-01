package Models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Factory.ConnectionFactory;
import Models.Processo;

public class Processo_DAO {

	public void addProcesso(Processo processo) throws ClassNotFoundException {
		
		String sql = "INSERT INTO Processo (contratante, folhas, empresas, conferente) values (?), (?), (?), (?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setString(1, processo.getContractor());
			ps.setInt(2, processo.getPages());
			ps.setInt(3, processo.getCompanys());
			ps.setString(4, processo.getLecturer());
			
			ps.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
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
	
	public void deleteProcessoPorId(Processo processo) throws ClassNotFoundException {
		
		String sql = "DELETE Processo WHERE id = ";
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setString(1, processo.getContractor());
			ps.setInt(2, processo.getPages());
			ps.setInt(3, processo.getCompanys());
			ps.setString(4, processo.getLecturer());
			
			ps.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
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
