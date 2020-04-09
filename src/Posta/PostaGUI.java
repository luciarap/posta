package Posta;

import java.io.IOException;

import java.util.ArrayList;
import Zamestnanci.Dorucovatel;
import Zamestnanci.Pracovnik;
import Zamestnanci.VeduciPosty;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zasielky.Dobierka;
import zasielky.DoporucenyList;
import zasielky.Zasielky;
import Posta.Posta;
import Posta.CheckLogin;

public class PostaGUI extends Application {
	private Button zapisZasielku = new Button("Zapis zasielku");
	private Button dorucitZasielku = new Button("Dorucit zasielku");
	private Button Scene2 = new Button("Tovary");
	private Button Scene1 = new Button("Zasielky");
	private TextField meno = new TextField();
	private TextField priezvisko = new TextField();
	private TextField ulica = new TextField();
	private TextField cislo = new TextField();
	private TextField psc = new TextField();
	private TextField mesto = new TextField();
	private TextField podacieCislo = new TextField();
	private TextField suma = new TextField();
	private TextField hmotnost = new TextField();
	private ScrollPane skrol = new ScrollPane();
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
	ListView ZoznamTovarov = new ListView();
	private Button pridatTovar = new Button("Pridat Tovar");

	Alert alert = new Alert(AlertType.ERROR);
	Scene tovary;
	Scene zasielky;
	Scene uvod;
	Scene Login;

	public void start(Stage hlavneOkno) throws Exception {

		hlavneOkno.setTitle("Posta");
		VeduciPosty posta = new VeduciPosty("Ivana", "Kocurikova", 4178);
		Dorucovatel dorucovatel3 = new Dorucovatel("Eva", "Benkova", 4179);
		Pracovnik pracovnik = new Pracovnik("Maria", "Kovacova", 4180, "polovicny");
		GridPane tovaryPane = new GridPane();
		GridPane pane = new GridPane();
		GridPane uvodVeduciPane = new GridPane();

		GridPane Login = new GridPane();
		Label labelUserName = new Label("Username");
		final TextField txtUserName = new TextField();
		Label lblPassword = new Label("Password");
		final PasswordField pf = new PasswordField();
		Button buttonLogin = new Button("Login");

		Login.add(labelUserName, 0, 0);
		Login.add(txtUserName, 1, 0);
		Login.add(lblPassword, 0, 1);
		Login.add(pf, 1, 1);
		Login.add(buttonLogin, 0, 2);

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
		alert.setContentText("Nespravne vyplnene udaje. Prosim opravte udaje a skuste to znovu.");

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

		uvodVeduciPane.add(Scene1, 0, 0);
		uvodVeduciPane.add(Scene2, 0, 1);

		tovaryPane.add(ZoznamTovarov, 0, 0);
		tovaryPane.add(pridatTovar, 0, 1);

		skrol.setContent(Login);

		Scene2.setOnAction(e -> hlavneOkno.setScene(tovary));
		tovary = new Scene(tovaryPane, 1000, 1000);

		Scene1.setOnAction(e -> hlavneOkno.setScene(zasielky));
		zasielky = new Scene(pane, 1000, 1000);

		/*buttonLogin.setOnAction(e -> hlavneOkno.setScene(uvod));
		uvod = new Scene(uvodPane, 1000, 1000);*/

		buttonLogin.setOnAction(e -> {
			if (txtUserName.getText().toString().equals(CheckLogin.getVeduciUsername())
					&& pf.getText().toString().equals(CheckLogin.getVeduciPassword())) {
				hlavneOkno.setScene(new Scene(uvodVeduciPane, 1000, 1000));
				hlavneOkno.show();
			} else {
				alert.show();

			}
			txtUserName.setText("");
			pf.setText("");

		});
	
		dorucitZasielku.setOnAction(event -> {
			Zasielky itemToRemove = (Zasielky) listView.getSelectionModel().getSelectedItem();
			dorucovatel3.Dorucit(itemToRemove);
			listView.getItems().remove(itemToRemove);

		});

		pridatTovar.setOnAction(e -> {

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
						});
					}
				}
			}
		});

		hlavneOkno.setScene(new Scene(skrol, 300, 150));
		hlavneOkno.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
