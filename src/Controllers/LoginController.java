package Controllers;

import Posta.CheckLogin;

/**
 *  V tejto triede sa nachádza controller, ktorý vyhodnocuje, ktorý používate¾ sa prihlásil
 * @author Lucia Rapánová
 */
public class LoginController {
	
	/**
	 * Metódaslúži na vyhodnotenie, èi boli údaje pri prihlasovaní správne
	 * @param username používate¾ské meno
	 * @param password heslo používate¾a
	 * @see CheckLogin zoznam užívate¾ov
	 * @return string, ktorý urèí, ktorý užívate¾ sa prihlásil, null, ak zadané údaje neexistujú
	 */
	public String validateUser(String username, String password) {
		
		if (username.equals(CheckLogin.getVeduciUsername())
				&& password.equals(CheckLogin.getVeduciPassword())) {
			return "veduci";
			
		}
		
		if (username.equals(CheckLogin.getPracovnikUsername())
				&& password.equals(CheckLogin.getPracovnikPassword())) {
			return "pracovnik";
			
		}
		return null;
		
	}

}
