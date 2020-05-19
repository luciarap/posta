package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PodacieCisloException extends Exception {
		
		Alert alert = new Alert(AlertType.ERROR);
		
		public PodacieCisloException(String string) { 
			super();
			
		}

		public void ShowAlert() {
			alert.setContentText("Nepsravny format podacieho cisla.");
			alert.show();
			// TODO Auto-generated method stub
			
		}

}
