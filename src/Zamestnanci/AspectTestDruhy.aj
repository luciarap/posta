package Zamestnanci;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public aspect AspectTestDruhy {
	
	Alert alert = new Alert(AlertType.ERROR);
	
	pointcut callDorucit(): call(* Dorucovatel.Dorucit(..));
	
	
	after() throwing (Exception e): callDorucit() {
		alert.setContentText("Chyba: " + e + "\n" + "Nebola zvolena ziadna zasielka na dorucenie");
		alert.show();
		System.out.println("Threw an exception: " + e + "\n" + "Nebola zvolena ziadna zasielka na dorucenie");
	}
	

	

}
