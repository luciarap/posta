package Posta;

public class LoginController {
	
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
