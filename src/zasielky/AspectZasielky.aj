package zasielky;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Aspekt sa používa na ošetrovanie výnimiek pri volaní funkcií
 * 
 * @author Lucia Rapánová
 *
 */
public aspect AspectZasielky {

	Alert alert = new Alert(AlertType.ERROR);

	pointcut callCheckPodacieCislo(): call(* Zasielky.CheckPodacieCislo(..));

	after() throwing (Exception e): callCheckPodacieCislo() {
		alert.setContentText("Chyba: " + e);
		alert.show();
		System.out.println("Threw an exception: " + e);
	}

}
