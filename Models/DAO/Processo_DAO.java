package Models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Factory.ConnectionFactory;
import Models.Conferente;
import Models.Processo;

public class Processo_DAO {

	public List<Processo> showProcessos() throws SQLException, ClassNotFoundException{
		
		String sql = "SELECT * From Processo";
		
		List<Processo> processo = new ArrayList<Processo>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		
		try {
			conn = ConnectionFactory.createConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		
			while(rs.next()) {
				Processo processos = new Processo();
				
				processos.setId(rs.getInt("id"));
				processos.setContractor(rs.getString("contratante"));
				processos.setPages(rs.getInt("folhas"));
				processos.setLecturer(rs.getString("conferente"));
				processos.setCompanys(rs.getInt("empresas"));
				processos.setPoints(rs.getInt("pontos"));
				
				processo.add(processos);	
			}
		}catch(SQLDataException e){
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
		return processo;
	}

	public void addProcesso(Processo processo) throws ClassNotFoundException {
		
		String sql = "INSERT INTO Processo (contratante, folhas, empresas, conferente) values (?, ?, ?, ?)";
		
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
	
	public void deleteProcessoPorId(int id) throws ClassNotFoundException {
		
		String sql = "DELETE FROM Processo WHERE id = (?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
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
