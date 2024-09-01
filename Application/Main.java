package Application;

import java.sql.SQLException;

import Models.Processo;
import Models.DAO.Processo_DAO;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Processo processo = new Processo();
		Processo_DAO processoDao = new Processo_DAO();

		//Teste de inserção de processo bem sucedido
		//Processo Jati = new Processo("Jati", 23, 2, "Luiz");
		//processoDao.addProcesso(Jati);
		
		//int id = 1;//testar deleção de processo por id 
		//processoDao.deleteProcessoPorId(1);
		
		for(Processo p : processoDao.showProcessos()) {
			System.out.println("ID: "+p.getId()+" | Contractor: "+p.getContractor()+" | Pages: "+p.getPages()+
					" | Lecturer: "+p.getLecturer()+" | Companys: "+p.getCompanys()+" | Points: "+p.getPoints());
		}
	}
}
