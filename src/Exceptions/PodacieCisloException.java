package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Trieda, ktorá dedí Exception Hádže chybu, ak bolo nesprávne vyplnené podacie
 * èíslo
 * 
 * @author Lucia Rapánová
 *
 */
public class PodacieCisloException extends Exception {

	private static final long serialVersionUID = 1L;
	Alert alert = new Alert(AlertType.ERROR);

	public PodacieCisloException(String string) {
		super();

	}

	/**
	 * Metóda vypíše na obrazovku chybu
	 */
	public void ShowAlert() {
		alert.setContentText(
				"Podacie cislo ma nespravny format alebo uz bolo pouzite. Skontrolujte podacie cislo a skuste to znovu.");
		alert.show();
		// TODO Auto-generated method stub

	}

}
