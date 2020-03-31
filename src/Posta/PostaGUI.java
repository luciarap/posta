package Posta;

import java.util.ArrayList;

import Zamestnanci.VeduciPosty;
import Zamestnanci.Zamestnanci;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zasielky.Zasielky;

public class PostaGUI extends Application  {
	private Button zapisZasielku = new Button("Zapis zasielku");
	private TextField meno = new TextField();
	private TextField priezvisko = new TextField();
	private TextField ulica = new TextField();
	private TextField cislo = new TextField();
	private TextField psc = new TextField();
	private TextField mesto = new TextField();
	private TextField podacieCislo = new TextField();
	private ScrollPane skrol = new ScrollPane();
	private Label menoLabel = new Label("Meno: ");
	private Label priezviskoLabel = new Label("Priezvisko: ");
	private Label ulicaLabel = new Label("Ulica: ");
	private Label cisloLabel = new Label("Cislo: ");
	private Label pscLabel = new Label("PSC: ");
	private Label mestoLabel = new Label("Mesto: ");
	private Label podacieCisloLabel = new Label("Podacie cislo: ");
	
	
	
	
	
	@Override
	
	public void start(Stage hlavneOkno) throws Exception {
		
		hlavneOkno.setTitle("Posta");
		VeduciPosty posta = new VeduciPosty("Ivana", "Kocurikova");
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setMinSize(300, 300);
		pane.setVgap(5);
		pane.setHgap(5);
		//zapisZasielku.setAlignment(Pos.CENTER);
		
		pane.add(meno, 1,0);
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
		pane.add(zapisZasielku, 1, 7);
		skrol.setContent(pane);		
		
		zapisZasielku.setOnAction(e -> { // lambda vyraz s odvodenim typu z kontextu
			posta.zapisZasielku(podacieCislo.getText(), meno.getText(), priezvisko.getText(), ulica.getText(), Integer.parseInt(cislo.getText()), Integer.parseInt(psc.getText()), mesto.getText());
			}
		);

		hlavneOkno.setScene(new Scene(skrol, 500, 300)); 
		hlavneOkno.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
