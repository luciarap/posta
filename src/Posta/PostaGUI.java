package Posta;

import java.util.ArrayList;

import Zamestnanci.Dorucovatel;
import Zamestnanci.VeduciPosty;
import Zamestnanci.Zamestnanci;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zasielky.Zasielky;
import Posta.Posta;

public class PostaGUI extends Application  {
	private Button zapisZasielku = new Button("Zapis zasielku");
	private Button dorucitZasielku = new Button("Dorucit zasielku");
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
	RadioButton rb1 = new RadioButton();
	final ToggleGroup group = new ToggleGroup();
	RadioButton rb2 = new RadioButton("Dobierka");
	ListView listView = new ListView();
	
	
	@Override
	
	public void start(Stage hlavneOkno) throws Exception {
		
		hlavneOkno.setTitle("Posta");
		VeduciPosty posta = new VeduciPosty("Ivana", "Kocurikova");
		Dorucovatel dorucovatel3 = new Dorucovatel("Eva", "Benkova");
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setMinSize(300, 300);
		pane.setVgap(5);
		pane.setHgap(5);
		rb1.setText("Doporuceny List");
		rb2.setToggleGroup(group);
		rb1.setToggleGroup(group);
		rb1.setSelected(true);
		//zapisZasielku.setAlignment(Pos.CENTER);
		
		pane.add(meno, 1,0);
		//meno.setVisible(false);
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
		pane.add(rb1, 1, 8);
		pane.add(rb2, 1, 9);
		pane.add(listView, 0, 10);
		pane.add(dorucitZasielku, 0, 11);
		skrol.setContent(pane);		
		
		zapisZasielku.setOnAction(e -> { // lambda vyraz s odvodenim typu z kontextu
			
			Zasielky zasielka = posta.zapisZasielku(podacieCislo.getText(), meno.getText(), priezvisko.getText(), ulica.getText(), Integer.parseInt(cislo.getText()), Integer.parseInt(psc.getText()), mesto.getText());
			listView.getItems().add(zasielka);
			}
		);
		
		dorucitZasielku.setOnAction(event -> {
			 int selectedIdx = listView.getSelectionModel().getSelectedIndex();
			 Zasielky itemToRemove = (Zasielky) listView.getSelectionModel().getSelectedItem();
            //ObservableList selectedIndices = listView.getSelectionModel().getSelectedIndices();
            dorucovatel3.Dorucit(itemToRemove);
            listView.getItems().remove(itemToRemove);
            
        });
		
		
		
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()  
	        { 

				@Override
				public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
					RadioButton rb = (RadioButton)group.getSelectedToggle();
					  
	                if (rb != null) { 
	                    String s = rb.getText(); 
	                    System.out.println("Stlaceny button " + s);
	                    if ( s == "Doporuceny list") {
	                    	//meno.setVisible(true);
	                    	
	                    }
	                    //nemusia byt vsetky vyplnene. bude tam iny konsturktor a textfielkldy mozu ostat prazdne. radio box necham for future references
	                    //namet na exceptions
	                } 
					
				} 
	        }); 

		hlavneOkno.setScene(new Scene(skrol, 1000, 1000)); 
		hlavneOkno.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
