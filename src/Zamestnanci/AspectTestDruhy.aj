package Zamestnanci;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Aspekt sa používa na ošetrovanie výnimiek pri volaní funkcií
 * 
 * @author Lucia Rapánová
 *
 */
public aspect AspectTestDruhy {

	Alert alert = new Alert(AlertType.ERROR);

	pointcut callDorucit(): call(* Zamestnanec.Dorucit(..));

	pointcut callodpisZasielky(): call(* Zamestnanec.odpisZasielky(..));

	pointcut calldostanVyplatu(): call(* Zamestnanec.dostanVyplatu(..));

	pointcut calladd(): call(* Zamestnanec.add(..));

	after() throwing (Exception e): callDorucit() {
		alert.setContentText("Chyba: " + e + "\n" + "Nebola zvolena ziadna zasielka na dorucenie");
		alert.show();
		System.out.println("Threw an exception: " + e + "\n" + "Nebola zvolena ziadna zasielka na dorucenie");
	}

	after() throwing (Exception e): callodpisZasielky() {
		alert.setContentText("Chyba: " + e + "\n" + "Nebola zvolena ziadna zasielka");
		alert.show();
		System.out.println("Threw an exception: " + e);
	}

	after() throwing (Exception e): calldostanVyplatu() {
		alert.setContentText("Chyba: " + e + "\n" + "nespravna volba, vyplata sa neda pridelit");
		alert.show();
		System.out.println("Threw an exception: " + e);
	}

	after() throwing (Exception e): calladd() {
		alert.setContentText("Chyba: " + e + "\n" + "nespravna volba, nebolo vykonane pridanie");
		alert.show();
		System.out.println("Threw an exception: " + e);
	}

}
