package Zamestnanci;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public aspect AspectTestDruhy {
	
	Alert alert = new Alert(AlertType.ERROR);
	
	pointcut callDorucit(): call(* Dorucovatel.Dorucit(..));

	pointcut callodpisZasielky(): call(* Dorucovatel.odpisZasielky(..));
	
	pointcut calldostanVyplatu(): call(* Dorucovatel.odpisZasielky(..));
	
	pointcut calloadd(): call(* Dorucovatel.odpisZasielky(..));
	
	after() throwing (Exception e): callDorucit() {
		alert.setContentText("Chyba: " + e + "\n" + "Nebola zvolena ziadna zasielka na dorucenie");
		alert.show();
		System.out.println("Threw an exception: " + e + "\n" + "Nebola zvolena ziadna zasielka na dorucenie");
	}
	
	after() throwing (Exception e): callodpisZasielky() {
		alert.setContentText("Chyba: " + e + "\n" + "Nebola zvolena ziadna zasielka");
		alert.show();
		System.out.println("Threw an exception: " + e + "\n" + "Nebola zvolena ziadna zasielka na dorucenie");
	}
	
	after() throwing (Exception e): calldostanVyplatu() {
		alert.setContentText("Chyba: " + e + "\n" + "nespravna volba, vyplata sa neda pridelit");
		alert.show();
		System.out.println("Threw an exception: " + e + "\n" + "Nebola zvolena ziadna zasielka na dorucenie");
	}
	
	after() throwing (Exception e): calloadd() {
		alert.setContentText("Chyba: " + e + "\n" + "nespravna volba, nebolo vykonane pridanie");
		alert.show();
		System.out.println("Threw an exception: " + e + "\n" + "Nebola zvolena ziadna zasielka na dorucenie");
	}

}
