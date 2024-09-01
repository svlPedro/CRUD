package Application;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import Models.Conferente;
import Models.DAO.Conferente_DAO;

public class Main {

	public static void main(String[] args) {
		
		//primeiro teste
		Conferente wendell = new Conferente("Wendell");
		
		Conferente_DAO confDao = new Conferente_DAO();
		
		
		try {
			confDao.removeConferente(wendell);
		} catch (ClassNotFoundException i) {
			i.printStackTrace();
		}//teste de remoção bem sucedido.
	}
}
