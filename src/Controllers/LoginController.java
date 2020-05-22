package Controllers;

import Posta.CheckLogin;

/**
 *  V tejto triede sa nach�dza controller, ktor� vyhodnocuje, ktor� pou��vate� sa prihl�sil
 * @author Lucia Rap�nov�
 */
public class LoginController {
	
	/**
	 * Met�dasl��i na vyhodnotenie, �i boli �daje pri prihlasovan� spr�vne
	 * @param username pou��vate�sk� meno
	 * @param password heslo pou��vate�a
	 * @see CheckLogin zoznam u��vate�ov
	 * @return string, ktor� ur��, ktor� u��vate� sa prihl�sil, null, ak zadan� �daje neexistuj�
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
