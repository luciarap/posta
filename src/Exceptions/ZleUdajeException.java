package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * Trieda, ktorá dedí Exception
 * Hádže chybu, ak boli nesprávne vyplnené údaje o druhu tovaru
 * @author lucia
 *
 */
public class ZleUdajeException extends Exception {
	
	private static final long serialVersionUID = 1L;
	Alert alert = new Alert(AlertType.ERROR);
	
	public ZleUdajeException(String string) { 
		super();
		
	}
/**
 * Metóda vypíše na obrazovku chybu
 */
	public void ShowAlert() {
		alert.setContentText("Nespravne vyplnene udaje. Prosim opravte udaje a skuste to znovu. Pre tip prejdite mysou po textovom poli Druh.");
		alert.show();
		// TODO Auto-generated method stub
		
	}
}
