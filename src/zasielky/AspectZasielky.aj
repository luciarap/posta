package zasielky;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Aspekt sa pou��va na o�etrovanie v�nimiek pri volan� funkci�
 * 
 * @author Lucia Rap�nov�
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
