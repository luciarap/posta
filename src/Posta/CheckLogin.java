package Posta;

import Controllers.LoginController;

/**
 * Trieda, v ktorej sa nachádza zoznam používate¾ov, ich username a password
 * 
 * @see LoginController využíva sa pri vyhodnocovaní prihlasovacích údajov
 * @author Lucia Rapánová
 *
 */
public class CheckLogin {

	private static String veduciUsername = "veduci";
	private static String veduciPassword = "123456";

	private static String pracovnikUsername = "pracovnik";
	private static String pracovnikPassword = "456789";
	/**
	 * 
	 * @return username vedúceho pošty
	 */
	public static String getVeduciUsername() {
		return veduciUsername;
	}
	/**
	 * 
	 * @param veduciUsername je username vedúceho pošty
	 */
	public static void setVeduciUsername(String veduciUsername) {
		CheckLogin.veduciUsername = veduciUsername;
	}
	/**
	 * 
	 * @return heslo vedúceho pošty
	 */
	public static String getVeduciPassword() {
		return veduciPassword;
	}
	/**
	 * 
	 * @param veduciPassword je heslo vedúceho pošty
	 */
	public static void setVeduciPassword(String veduciPassword) {
		CheckLogin.veduciPassword = veduciPassword;
	}
	/**
	 * 
	 * @return username pracovníka pošty
	 */
	public static String getPracovnikUsername() {
		return pracovnikUsername;
	}
	/**
	 * 
	 * @param pracovnikUsername je username pracovníka pošty
	 */
	public static void setPracovnikUsername(String pracovnikUsername) {
		CheckLogin.pracovnikUsername = pracovnikUsername;
	}
	/**
	 * 
	 * @return heslo pracovníka pošty
	 */
	public static String getPracovnikPassword() {
		return pracovnikPassword;
	}
	/**
	 * 
	 * @param pracovnikPassword je heslo pracovníka pošty
	 */
	public static void setPracovnikPassword(String pracovnikPassword) {
		CheckLogin.pracovnikPassword = pracovnikPassword;
	}


}
