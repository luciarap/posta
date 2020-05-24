package Posta;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Aspekt sa pou��va na o�etrovanie v�nimiek pri volan� funkci�
 * 
 * @author Lucia Rap�nov�
 *
 */
public aspect AspectTest {
	
	Alert alert = new Alert(AlertType.ERROR);

	pointcut callZobrazZasielkyScreen(): call(* ZasielkyScreen.ZobrazZasielkyScreen(..));

	pointcut callzobrazPracovnikScreen(): call(* PracovnikScreen.zobrazPracovnikScreen(..));

	pointcut callzobrazVeduciScreen(): call(* VeduciScreen.zobrazVeduciScreen(..));

	pointcut callZobrazZamestnanciScreen(): call(* ZamestnanciScreen.ZobrazZamestnanciScreen(..));

	pointcut callvalidateUser(): call(* Controllers.LoginController.validateUser(..));

	after() throwing (Exception e): callZobrazZasielkyScreen() {
		alert.setContentText("Chyba: " + e);
		alert.show();
		System.out.println("Vynimka: " + e);
	}

	after() throwing (Exception e): callvalidateUser() {
		alert.setContentText("Chyba: " + e);
		alert.show();
		System.out.println("Vynimka: " + e);
	}

	after() throwing (Exception e): callzobrazPracovnikScreen() {
		alert.setContentText("Chyba: " + e);
		alert.show();
		System.out.println("Vynimka: " + e);
	}

	after() throwing (Exception e): callzobrazVeduciScreen() {
		alert.setContentText("Chyba: " + e);
		alert.show();
		System.out.println("Vynimka: " + e);
	}

	after() throwing (Exception e): callZobrazZamestnanciScreen() {
		alert.setContentText("Chyba: " + e);
		alert.show();
		System.out.println("Vynimka: " + e);
	}

}
