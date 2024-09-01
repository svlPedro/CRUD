package Application;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import Models.Conferente;
import Models.DAO.Conferente_DAO;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//primeiro teste
		//Conferente wendell = new Conferente("Wendell");
		
		Conferente_DAO confDao = new Conferente_DAO();
		
		for(Conferente conf : confDao.showConferente()) {
			System.out.println("Conferente: "+conf.getName());
		}
		//for each para imprimir os conferentes
		//saida:
		/*
		 * Conferente: Ari
		 * Conferente: Elton
 		 * Conferente: João Batista
		 * Conferente: Lobo
		 * Conferente: Luiz
		 */
		
	}
}
