package tovary;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Aspekt na kontrolu, èi nejaká metóda nevyhodila exception
 * 
 * @author Lucia Rapánová
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
