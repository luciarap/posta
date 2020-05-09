package Posta;

import Zamestnanci.Dorucovatel;
import Zamestnanci.Pracovnik;
import Zamestnanci.VeduciPosty;
import Zamestnanci.Zamestnanec;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tovary.Noviny;

public class ZamestnanciScreen implements Runnable {
	
	static ListView ZoznamZamestnancov = new ListView();
	
	GridPane zamestnanciPane = new GridPane();
	private Button spat = new Button("Spä");
	private Button vyplata = new Button("Pridel vyplatu");
	

	public Scene ZobrazZamestnanciScreen(Scene hlavna, Stage hlavny)  {
		
 
		 
		ZoznamZamestnancov.setPrefSize(500, 250);
		Zamestnanec dorucovatel1 = new Dorucovatel("Eva", "Benkova", 4579);
		ZoznamZamestnancov.getItems().add(dorucovatel1);
		Zamestnanec pracovnik1 = new Pracovnik("Klaudia", "Novakova", 4580, "cely");
		ZoznamZamestnancov.getItems().add(pracovnik1);
		Zamestnanec pracovnik2 = new Pracovnik("Peter", "Simko", 4581,"polovicny");
		ZoznamZamestnancov.getItems().add(pracovnik2);
		Zamestnanec veduci1 = new VeduciPosty("Jana", "Horvathova", 4578);
		veduci1.add(dorucovatel1);
		veduci1.add(pracovnik2);
		veduci1.add(pracovnik1);
		//veduci1.dostanVyplatu(); 
		
		
		zamestnanciPane.add(ZoznamZamestnancov, 1, 1);
		// TODO Auto-generated method stub
		VeduciScreen screen = new VeduciScreen();
		zamestnanciPane.add(spat, 0, 2);
		zamestnanciPane.add(vyplata, 0, 3);
		vyplata.setOnAction(e -> {
			ZamestnanciScreen m1 = new ZamestnanciScreen();  
			Thread t1 =new Thread(m1); 
			t1.start(); //to do...
			veduci1.dostanVyplatu(); 
			veduci1.info();  
		});
		spat.setOnAction(e -> {
			screen.zobrazVeduciScreen(hlavna, hlavny);
			return;

		});
		return new Scene(zamestnanciPane, 1000, 1000);
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread test...");  
	}

}
