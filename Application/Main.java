package Application;

import Models.Conferente;
import Models.DAO.Conferente_DAO;

public class Main {

	public static void main(String[] args) {
		
		//primeiro teste
		Conferente wendell = new Conferente("Wendell");
		
		Conferente_DAO confDao = new Conferente_DAO();
		
		try {
			confDao.addConferente(wendell);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
