package Posta;
/**
 * Trieda, v ktorej sa nach�dza zoznam pou��vate�ov, ich username a password
 * @see LoginController vyu��va sa pri vyhodnocovan� prihlasovac�ch �dajov
 * @author Lucia Rap�nov�
 *
 */
public class CheckLogin {
	
	private static String veduciUsername = "veduci";
	private static String veduciPassword = "123456";
	
	private static String pracovnikUsername = "pracovnik";
	private static String pracovnikPassword = "456789";
	
	
	public static String getPracovnikUsername() {
		return pracovnikUsername;
	}
	public static void setPracovnikUsername(String pracovnikUsername) {
		CheckLogin.pracovnikUsername = pracovnikUsername;
	}
	public static String getPracovnikPassword() {
		return pracovnikPassword;
	}
	public static void setPracovnikPassword(String pracovnikPassword) {
		CheckLogin.pracovnikPassword = pracovnikPassword;
	}
	public static String getVeduciUsername() {
		return veduciUsername;
	}
	public void setVeduciUsername(String veduciUsername) {
		this.veduciUsername = veduciUsername;
	}
	public static String getVeduciPassword() {
		return veduciPassword;
	}
	public void setVeduciPassword(String veduciPassword) {
		this.veduciPassword = veduciPassword;
	}
	
	
	
	

}
