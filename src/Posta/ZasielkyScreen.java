package Posta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Zamestnanci.Dorucovatel;
import Zamestnanci.Pracovnik;
import Zamestnanci.VeduciPosty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zasielky.Dobierka;
import zasielky.Zasielky;

public class ZasielkyScreen implements java.io.Serializable {
	
	ArrayList<Zasielky> woi=new ArrayList<>();
	
	Alert alert = new Alert(AlertType.ERROR);
	GridPane pane = new GridPane();
	private Button zapisZasielku = new Button("Zapis zasielku");
	private Button dorucitZasielku = new Button("Dorucit zasielku");
	private TextField meno = new TextField();
	private TextField priezvisko = new TextField();
	private TextField ulica = new TextField();
	private TextField cislo = new TextField();
	private TextField psc = new TextField();
	private TextField mesto = new TextField();
	private TextField podacieCislo = new TextField();
	private TextField suma = new TextField();
	private TextField hmotnost = new TextField();
	//private ScrollPane skrol = new ScrollPane();
	private Label menoLabel = new Label("Meno: ");
	private Label priezviskoLabel = new Label("Priezvisko: ");
	private Label ulicaLabel = new Label("Ulica: ");
	private Label cisloLabel = new Label("Cislo: ");
	private Label pscLabel = new Label("PSC: ");
	private Label mestoLabel = new Label("Mesto: ");
	private Label podacieCisloLabel = new Label("Podacie cislo: ");
	private Label sumaLabel = new Label("Suma: ");
	private Label hmotnostLabel = new Label("Hmotnost: ");
	RadioButton rb1 = new RadioButton();
	final ToggleGroup group = new ToggleGroup();
	RadioButton rb2 = new RadioButton("Dobierka");
	RadioButton invisible = new RadioButton("Invisible");
	ListView listView = new ListView();
	private Button spat = new Button("Sp‰ù");
	public Scene ZobrazZasielkyScreen(Scene hlavna, Stage hlavny) {
		alert.setContentText("Nespravne vyplnene udaje. Prosim opravte udaje a skuste to znovu.");
		
		VeduciPosty posta = new VeduciPosty("Ivana", "Kocurikova", 4178);
		Dorucovatel dorucovatel3 = new Dorucovatel("Eva", "Benkova", 4179);
		Pracovnik pracovnik = new Pracovnik("Maria", "Kovacova", 4180, "polovicny");
		
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setMinSize(300, 300);
		pane.setVgap(5);
		pane.setHgap(5);
		rb1.setText("Doporuceny List");
		rb2.setToggleGroup(group);
		rb1.setToggleGroup(group);
		invisible.setToggleGroup(group);
		invisible.setSelected(true);
		invisible.setVisible(false);
		
		pane.add(meno, 1, 0);
		pane.add(menoLabel, 0, 0);
		pane.add(priezviskoLabel, 0, 1);
		pane.add(priezvisko, 1, 1);
		pane.add(ulicaLabel, 0, 2);
		pane.add(ulica, 1, 2);
		pane.add(cisloLabel, 0, 3);
		pane.add(cislo, 1, 3);
		pane.add(pscLabel, 0, 4);
		pane.add(psc, 1, 4);
		pane.add(mestoLabel, 0, 5);
		pane.add(mesto, 1, 5);
		pane.add(podacieCisloLabel, 0, 6);
		pane.add(podacieCislo, 1, 6);
		pane.add(suma, 1, 7);
		pane.add(hmotnost, 1, 8);
		pane.add(sumaLabel, 0, 7);
		pane.add(hmotnostLabel, 0, 8);
		pane.add(zapisZasielku, 1, 9);
		pane.add(rb1, 1, 10);
		pane.add(rb2, 1, 11);
		pane.add(invisible, 1, 12);
		pane.add(listView, 0, 12);
		pane.add(dorucitZasielku, 0, 13);
		pane.setStyle("-fx-background-color:  linear-gradient( #d3d3d3, #808080); -fx-font-size: 15px;");
		pane.add(spat, 0, 14);
		listView.setPrefSize(500, 500);
		
		try {
	        FileInputStream fis=new FileInputStream("C:\\Users\\lucia\\doporucenyList.ser");
	        ObjectInputStream ois=new ObjectInputStream(fis);
	        Zasielky wo=null;
	        Zasielky[] woj=new Zasielky[5];

	        //ArrayList<Zasielky> woi=new ArrayList<>();
	        woi = (ArrayList<Zasielky>)ois.readObject();

	        for(int i=0;i<woi.size();i++) {
	        	listView.getItems().add(woi.get(i));
	        }
	} catch (IOException i) {
		System.out.println("CHYBA");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		//spat.setOnAction(e -> hlavny.setScene(hlavna));	
		
		dorucitZasielku.setOnAction(event -> {
			Zasielky itemToRemove = (Zasielky) listView.getSelectionModel().getSelectedItem();
			dorucovatel3.Dorucit(itemToRemove);
			listView.getItems().remove(itemToRemove);
			System.out.println("Fungujem aj tu.");

		});

		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				RadioButton rb = (RadioButton) group.getSelectedToggle();

				if (rb != null) {
					String s = rb.getText();
					System.out.println("Stlaceny button " + s);
					if (s == "Dobierka") {
						zapisZasielku.setOnAction(e -> { // lambda vyraz s odvodenim typu z kontextu
							try {
								Dobierka dobierka = posta.zapisDobierku(podacieCislo.getText(), meno.getText(),
										priezvisko.getText(), ulica.getText(), Integer.parseInt(cislo.getText()),
										Integer.parseInt(psc.getText()), mesto.getText(),
										Integer.parseInt(suma.getText()), Integer.parseInt(hmotnost.getText()));
								listView.getItems().add(dobierka);
								System.out.println("Fungujem aj tu.");
							} catch (Exception e1) {
								alert.show();
								System.out.println("Chyba");
							}
						});

					}

					if (s == "Doporuceny List") {
						
						zapisZasielku.setOnAction(e -> { // lambda vyraz s odvodenim typu z kontextu

							Zasielky zasielka = posta.zapisZasielku(podacieCislo.getText(), meno.getText(),
									priezvisko.getText(), ulica.getText(), Integer.parseInt(cislo.getText()),
									Integer.parseInt(psc.getText()), mesto.getText());
							listView.getItems().add(zasielka);
							woi.add(zasielka);
							
							try {

								//DataInputStream in = new DataInputStream(ft);
						         FileOutputStream fileOut =
						         new FileOutputStream("C:\\Users\\lucia\\doporucenyList.ser");
						         ObjectOutputStream out = new ObjectOutputStream(fileOut);
						         out.writeObject(woi);
						         //out.writeObject(e);
						         out.close();
						         fileOut.close();
						         System.out.printf("Data ulozene");
						      } catch (IOException i) {
						         i.printStackTrace();
						      }
							System.out.println("Fungujem aj tu.");
						});
					
					}
				}
			}
		});
		
	
		return new Scene(pane, 1000, 1000);
		
	}

}
