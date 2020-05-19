package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PodacieCisloException extends Exception {
		
		Alert alert = new Alert(AlertType.ERROR);
		
		public PodacieCisloException(String string) { 
			super();
			
		}

		public void ShowAlert() {
			alert.setContentText("Podacie cislo ma nespravny format alebo uz bolo pouzite. Skontrolujte podacie cislo a skuste to znovu.");
			alert.show();
			// TODO Auto-generated method stub
			
		}

}
