package tovary;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public aspect AspectTovary {
	
	Alert alert = new Alert(AlertType.ERROR);
	
	pointcut callPredatTovar(): call(* Tovary.predatTovar(..));
	
	pointcut callobjednatTovar(): call(* Tovary.predatTovar(..));
	
	
	
	after() throwing (Exception e): callPredatTovar() {
		alert.setContentText("Chyba: " + e + "\n" + "Neboli zvolene ziadne udaje.");
		alert.show();
		System.out.println("Threw an exception: " + e + "\n" + "Nebola zvolena ziadna zasielka na dorucenie");
	}
	
	after() throwing (Exception e): callobjednatTovar() {
		alert.setContentText("Chyba: " + e + "\n" + "Neboli zvolene ziadne udaje.");
		alert.show();
		System.out.println("Threw an exception: " + e + "\n" + "Nebola zvolena ziadna zasielka na dorucenie");
	}

}
