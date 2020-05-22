package Posta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import Controllers.ZasielkyController;
import Exceptions.PodacieCisloException;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zasielky.Dobierka;
import zasielky.PoistenyList;
import zasielky.Zasielky;

/**
 * Táto trieda slúži na vybudovanie scény so zásielkami
 * @author Lucia Rapánová
 *
 */
public class ZasielkyScreen implements java.io.Serializable {

	ArrayList<Zasielky> woi = new ArrayList<>();

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
	RadioButton rb3 = new RadioButton("Poisteny list");
	RadioButton invisible = new RadioButton("Invisible");
	ListView listView = new ListView();
	private Button spat = new Button("Spä");
	final Tooltip tooltip = new Tooltip();

	/**
	 * Metóda vybuduje scénu pre zásielky
	 * @param hlavna je hlavná scéna - úvodná obrazovka
	 * @param hlavny je hlavný stage, ktorý sa používa v GUI
	 * @return Metóda vráti novú vytvorenú scénu
	 */
	public Scene ZobrazZasielkyScreen(Scene hlavna, Stage hlavny) {
		alert.setContentText("Nespravne vyplnene udaje. Prosim opravte udaje a skuste to znovu.");

		VeduciPosty posta = new VeduciPosty("", "", 0, "N");
		tooltip.setText("Pri dobierke napiste sumu dobierky, pri poistenom liste vysku poistenia");

		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setMinSize(300, 300);
		pane.setVgap(5);
		pane.setHgap(5);
		rb1.setText("Doporuceny List");
		rb2.setToggleGroup(group);
		rb1.setToggleGroup(group);
		rb3.setToggleGroup(group);
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
		pane.add(rb3, 1, 12);
		pane.add(invisible, 1, 13);
		pane.add(listView, 15, 15);
		pane.add(dorucitZasielku, 0, 14);
		pane.setStyle("-fx-background-color:  linear-gradient( #d3d3d3, #808080); -fx-font-size: 15px;");
		pane.add(spat, 1, 14);
		listView.setPrefSize(500, 700);
		listView.setTranslateX(-30);
		listView.setTranslateY(-500);
		System.out.println(PostaGUI.povod);

		ZasielkyController zasielkyController = new ZasielkyController();

		spat.setOnAction(e -> {
			/**
			 * návrat na predošlú obrazovku, ak je prihlásený vedúci, zobrazí veduciScena,
			 * ak je prihlásený pracovník, zobrazí scénu pre pracovníka
			 */
			if (PostaGUI.povod == "veduci") {
				hlavny.setScene(PostaGUI.veduciScena);
			}

			else if (PostaGUI.povod == "pracovnik")
				hlavny.setScene(PostaGUI.pracovnikScena);

		});

		/**
		 * naèítanie tovaru zo súboru do arraylistu, ktorý si drží zoznam zasielok
		 */
		woi = zasielkyController.nacitajTovar(woi);

		for (int i = 0; i < woi.size(); i++) {
			listView.getItems().add(woi.get(i));
			/**
			 * pridanie tovaru do GUI ListView
			 */
		}
	/**
	 * pri doruèení sa zásielka vymaže zo súboru, z arraylistu aj z listView
	 */
		dorucitZasielku.setOnAction(event -> {
			
			Zasielky itemToRemove = (Zasielky) listView.getSelectionModel().getSelectedItem();
			posta.Dorucit(itemToRemove);
			listView.getItems().remove(itemToRemove);
			woi = zasielkyController.dorucZasielku(woi, itemToRemove);

		});
	/**
	 * zápis zásielok pod¾a vybratého druhu zásielky
	 */
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				RadioButton rb = (RadioButton) group.getSelectedToggle();
				if (rb != null) {
					String s = rb.getText();
					System.out.println("Stlaceny button " + s);
					
					if (s == "Dobierka") {

						zapisZasielku.setOnAction(e -> {

							try {

								try {
									Dobierka dobierka = posta.zapisDobierku(podacieCislo.getText(), meno.getText(),
											priezvisko.getText(), ulica.getText(), Integer.parseInt(cislo.getText()),
											Integer.parseInt(psc.getText()), mesto.getText(),
											Integer.parseInt(suma.getText()), Double.parseDouble(hmotnost.getText()));
									listView.getItems().add(dobierka);
									woi.add(dobierka);
									woi = zasielkyController.ulozZasielku(woi, dobierka);
								} catch (PodacieCisloException ex) {
									ex.ShowAlert();
								}

							} catch (Exception e1) {
								alert.show();
								System.out.println("Chyba" + e1);
							}

						});

					}

					if (s == "Doporuceny List") {

						zapisZasielku.setOnAction(e -> {

							try {

								try {

									Zasielky zasielka = posta.zapisZasielku(podacieCislo.getText(), meno.getText(),
											priezvisko.getText(), ulica.getText(), Integer.parseInt(cislo.getText()),
											Integer.parseInt(psc.getText()), mesto.getText());
									listView.getItems().add(zasielka);
									woi.add(zasielka);
									woi = zasielkyController.ulozZasielku(woi, zasielka);
								} catch (PodacieCisloException ex) {
									ex.ShowAlert();
								}
							} catch (Exception e1) {
								alert.show();
								System.out.println("Chyba" + e1);
							}

						});

					}

					if (s == "Poisteny list") {

						zapisZasielku.setOnAction(e -> {

							try {

								try {
									PoistenyList poistenyList = posta.zapisPL(podacieCislo.getText(), meno.getText(),
											priezvisko.getText(), ulica.getText(), Integer.parseInt(cislo.getText()),
											Integer.parseInt(psc.getText()), mesto.getText(),
											Integer.parseInt(suma.getText()));

									listView.getItems().add(poistenyList);
									woi.add(poistenyList);
									woi = zasielkyController.ulozZasielku(woi, poistenyList);
								} catch (PodacieCisloException ex) {
									ex.ShowAlert();
								}

							} catch (Exception e1) {
								alert.show();
								System.out.println("Chyba" + e1);
							}

						});

					}
				}
			}
		});

		return new Scene(pane, 900, 800);
	}

}
