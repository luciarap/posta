package Posta;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;

import Zamestnanci.Dorucovatel;
import Zamestnanci.Pracovnik;
import Zamestnanci.VeduciPosty;
import Zamestnanci.Zamestnanec;
import tovary.Tovary;
import zasielky.DoporucenyList;
import zasielky.Zasielky;
import zasielky.Zasielky.Adresa;

public class Posta {
	

	
	//static ArrayList<Zasielky> ar = new ArrayList<Zasielky>();
	//static ArrayList<Tovary> ar2 = new ArrayList<Tovary>();
	

	public static void main(String[] args) {

		Zamestnanec dorucovatel1 = new Dorucovatel("Eva", "Benkova", 4579);
		Zamestnanec pracovnik1 = new Pracovnik("Klaudia", "Novakova", 4580, "cely");
		Zamestnanec pracovnik2 = new Pracovnik("Peter", "Simko", 4581,"polovicny");
		Zamestnanec veduci1 = new VeduciPosty("Jana", "Horvathova", 4578);
		veduci1.add(dorucovatel1);
		veduci1.add(pracovnik2);
		veduci1.add(pracovnik1);
		veduci1.dostanVyplatu(); //vsetci dostanu vyplatu
		veduci1.info();
	
	}


}
