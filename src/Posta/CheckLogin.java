package Posta;

import Controllers.LoginController;

/**
 * Trieda, v ktorej sa nach�dza zoznam pou��vate�ov, ich username a password
 * 
 * @see LoginController vyu��va sa pri vyhodnocovan� prihlasovac�ch �dajov
 * @author Lucia Rap�nov�
 *
 */
public class CheckLogin {

	private static String veduciUsername = "veduci";
	private static String veduciPassword = "123456";

	private static String pracovnikUsername = "pracovnik";
	private static String pracovnikPassword = "456789";
	/**
	 * 
	 * @return username ved�ceho po�ty
	 */
	public static String getVeduciUsername() {
		return veduciUsername;
	}
	/**
	 * 
	 * @param veduciUsername je username ved�ceho po�ty
	 */
	public static void setVeduciUsername(String veduciUsername) {
		CheckLogin.veduciUsername = veduciUsername;
	}
	/**
	 * 
	 * @return heslo ved�ceho po�ty
	 */
	public static String getVeduciPassword() {
		return veduciPassword;
	}
	/**
	 * 
	 * @param veduciPassword je heslo ved�ceho po�ty
	 */
	public static void setVeduciPassword(String veduciPassword) {
		CheckLogin.veduciPassword = veduciPassword;
	}
	/**
	 * 
	 * @return username pracovn�ka po�ty
	 */
	public static String getPracovnikUsername() {
		return pracovnikUsername;
	}
	/**
	 * 
	 * @param pracovnikUsername je username pracovn�ka po�ty
	 */
	public static void setPracovnikUsername(String pracovnikUsername) {
		CheckLogin.pracovnikUsername = pracovnikUsername;
	}
	/**
	 * 
	 * @return heslo pracovn�ka po�ty
	 */
	public static String getPracovnikPassword() {
		return pracovnikPassword;
	}
	/**
	 * 
	 * @param pracovnikPassword je heslo pracovn�ka po�ty
	 */
	public static void setPracovnikPassword(String pracovnikPassword) {
		CheckLogin.pracovnikPassword = pracovnikPassword;
	}


}
