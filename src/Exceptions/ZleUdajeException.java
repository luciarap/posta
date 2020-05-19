package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ZleUdajeException extends Exception {
	
	Alert alert = new Alert(AlertType.ERROR);
	
	public ZleUdajeException(String string) { 
		super();
		
	}

	public void ShowAlert() {
		alert.setContentText("Nespravne vyplnene udaje. Prosim opravte udaje a skuste to znovu. Pre tip prejdite mysou po textovom poli Druh.");
		alert.show();
		// TODO Auto-generated method stub
		
	}
}
