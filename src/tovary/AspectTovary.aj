package tovary;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Aspekt na kontrolu, �i nejak� met�da nevyhodila exception
 * 
 * @author Lucia Rap�nov�
 *
 */
public aspect AspectTovary {

	Alert alert = new Alert(AlertType.ERROR);

	pointcut callPredatTovar(): call(* Tovary.predatTovar(..));

	after() throwing (Exception e): callPredatTovar() {
		alert.setContentText("Chyba: " + e + "\n" + "Neboli zvolene ziadne udaje.");
		alert.show();
		System.out.println("Vynimka: " + e + "\n" + "Nebola zvolena ziadna zasielka na dorucenie");
	}

}
