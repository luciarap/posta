package Posta;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Zamestnanci.Dorucovatel;
import Zamestnanci.Pracovnik;
import Zamestnanci.VeduciPosty;
import Zamestnanci.Zamestnanec;
import hotovost.ManazerHotovosti;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tovary.Noviny;

public class ZamestnanciScreen implements Runnable  {
	


	// ObservableList<String> ZoznamZamestnancov = new ObservableList<String>();
	ObservableList<Zamestnanec> ZoznamZamestnancov = FXCollections.observableArrayList();

	GridPane zamestnanciPane = new GridPane();
	private Button spat = new Button("Sp�");
	private Button vyplata = new Button("Pridel vyplatu");
	// TextArea textArea = new TextArea();
	Label stavHotovosti = new Label();

	Text text = new Text();

	public Scene ZobrazZamestnanciScreen(Scene hlavna, Stage hlavny) throws FileNotFoundException {
		
		FileInputStream female = new FileInputStream("C:\\Users\\lucia\\Desktop\\oop1\\female.png"); 
		FileInputStream male = new FileInputStream("C:\\Users\\lucia\\Desktop\\oop1\\male.png"); 
		Image imageF = new Image(female);
		Image imageM = new Image(male);
		ImageView imageView = new ImageView();
		
		stavHotovosti.setStyle("-fx-font-size: 18px; "
				+ "-fx-font-weight:bold;");

		// zamestnanciPane.add(textArea, 0, 1);
		ComboBox<Zamestnanec> comboBox = new ComboBox<>(ZoznamZamestnancov);
		Label selected = new Label("default item selected");
		// Create action event
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				text.setFont((Font.font("Verdana", 20)));
				
				if (comboBox.getValue().getPohlavie() == "F") {
					imageView.setImage(imageF);
					comboBox.setTranslateY(-100);
				}
				else imageView.setImage(imageM); {
					comboBox.setTranslateY(-100);
				}
				comboBox.setItems(ZoznamZamestnancov);
				// textArea.setText(comboBox.getValue() + " selected");
				if (comboBox.getValue() instanceof Dorucovatel) {
					text.setText("Dorucovatel \nMeno a priezvisko: " + comboBox.getValue().getMeno() + " " + comboBox.getValue().getPriezvisko() + "\n"
							+ "ID: " + comboBox.getValue().getID() + "\n" + "Mzda: " + comboBox.getValue().getMzda());
				}

				if (comboBox.getValue() instanceof Pracovnik) {
					text.setText("Pracovnik \nMeno a priezvisko: " + comboBox.getValue().getMeno() + " " + comboBox.getValue().getPriezvisko() + "\n"
							+  "ID: " + comboBox.getValue().getID() + "\n" + "Mzda: " + comboBox.getValue().getMzda() + "\n"
							+ "Uvazok: " + ((Pracovnik) comboBox.getValue()).getUvazok());
				}
				
				if (comboBox.getValue() instanceof VeduciPosty) {
					text.setText("Veduci posty: " + comboBox.getValue().getMeno() + " " + comboBox.getValue().getPriezvisko() + "\n"
							+  "ID: " + comboBox.getValue().getID() + "\n" + "Mzda: " + comboBox.getValue().getMzda());
				}

				/*
				 * System.out.println("ID: "+ getID()); System.out.println("Meno: " +
				 * getMeno()); System.out.println("Priezvisko: " + getPriezvisko());
				 * System.out.println("Mzda: " + getMzda());
				 * System.out.println("_______________"); );
				 */

				// textfield or something, vypise vsetky udaje o zamestanncoch or something...
			}
		};

		// Set on action
		zamestnanciPane.setPrefSize(600, 300);
		comboBox.setOnAction(event);
		zamestnanciPane.add(comboBox, 0, 0);
		zamestnanciPane.add(text, 0, 0);
		zamestnanciPane.add(imageView, 0, 0);
		imageView.setTranslateX(3);
		imageView.setTranslateY(60);

		text.setTranslateX(200);
		text.setTranslateY(60);
		comboBox.setTranslateX(0);
		comboBox.setTranslateY(0);
		
		

		// ZoznamZamestnancov.
		Zamestnanec dorucovatel1 = new Dorucovatel("Eva", "Benkova", 4579, "F");
		ZoznamZamestnancov.add(dorucovatel1);
		Zamestnanec pracovnik1 = new Pracovnik("Klaudia", "Novakova", 4580, "cely", "F");
		ZoznamZamestnancov.add(pracovnik1);
		Zamestnanec pracovnik2 = new Pracovnik("Peter", "Simko", 4581, "polovicny", "M");
		ZoznamZamestnancov.add(pracovnik2);
		Zamestnanec veduci1 = new VeduciPosty("Jana", "Horvathova", 4578, "F");
		ZoznamZamestnancov.add(veduci1);
		veduci1.add(dorucovatel1);
		veduci1.add(pracovnik2);
		veduci1.add(pracovnik1);
		//veduci1.add(veduci1);
		// veduci1.dostanVyplatu();

		// zamestnanciPane.add(ZoznamZamestnancov, 1, 1);
		// TODO Auto-generated method stub
		VeduciScreen screen = new VeduciScreen();
		zamestnanciPane.add(spat, 0, 0);
		spat.setTranslateX(0);
		spat.setTranslateY(220);
		zamestnanciPane.add(vyplata, 0, 0);
		vyplata.setTranslateX(60);
		vyplata.setTranslateY(220);
		zamestnanciPane.add(stavHotovosti, 0, 0);
		stavHotovosti.setTranslateX(0);
		stavHotovosti.setTranslateY(260);
		// update observable or something
		// zamestnanciPane.add(selected, 0, 5);
		vyplata.setOnAction(e -> {
			/*ZamestnanciScreen m1 = new ZamestnanciScreen();
			Thread t1 = new Thread(m1);
			t1.start(); // to do...*/
			veduci1.dostanVyplatu();
			stavHotovosti.setText("");
			stavHotovosti.setText("Stav hotovosti: " + Double.toString(ManazerHotovosti.getStavHotovosti()));
			
			comboBox.setItems(ZoznamZamestnancov);

			veduci1.info();
			vyplata.setDisable(true);
			vyplata.setStyle("-fx-background-color: #d3d3d3");
			
		});
		spat.setOnAction(e -> {
			stavHotovosti.setText("");
			hlavny.setScene(PostaGUI.veduciScena);
		});

		// comboBox.setItems(ZoznamZamestnancov);
		return new Scene(zamestnanciPane, 600, 400);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread test...");
	}

}
