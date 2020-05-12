package Posta;

import Zamestnanci.VeduciPosty;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import tovary.Casopisy;
import tovary.Noviny;
import tovary.Pohladnice;
import tovary.Tovary;
import tovary.Znamky;
import tovary.Zoznamy;
import tovary.Zreby;
import zasielky.Dobierka;
import zasielky.Zasielky;

public class TovaryScreen {

	
	static ListView ZoznamTovarov = new ListView();
	private static Button pridatTovar = new Button("Pridat Tovar");
	private static Button predatTovar = new Button("Predat Tovar");
	private static Button Spat = new Button("Sp�");
	static Label zoznamLabel = new Label("Tovary");
	static Label znamkyLabel = new Label("Znamky");
	static Label zrebyLabel = new Label("Zreby");
	static Label pohladniceLabel = new Label("Pohladnice");
	static Label novinyLabel = new Label("Noviny");
	static Label casopisyLabel = new Label("Casopisy");
	
	static Label nazovLabel = new Label("Nazov");
	static Label pocetLabel = new Label("Pocet");
	static Label druhLabel = new Label("Druh");
	
	static Label pocetKsLabel = new Label("Pocet kusov na predaj");
	static TextField pocetTxt = new TextField();
	
	static TextField nazovZnamkyTxt = new TextField();
	static TextField pocetZnamkyTxt = new TextField();
	static TextField druhZnamkyTxt = new TextField();
	
	static TextField nazovZrebyTxt = new TextField();
	static TextField pocetZrebyTxt = new TextField();
	static TextField druhZrebyTxt = new TextField();
	
	static TextField nazovPohladniceTxt = new TextField();
	static TextField pocetPohladniceTxt = new TextField();
	static TextField druhPohladniceTxt = new TextField();
	
	static TextField nazovNovinyTxt = new TextField();
	static TextField pocetNovinyTxt = new TextField();
	static TextField druhNovinyTxt = new TextField();
	
	static TextField nazovCasopisyTxt = new TextField();
	static TextField pocetCasopisyTxt = new TextField();
	static TextField druhCasopisyTxt = new TextField();
	
	private static Button pridatZnamky = new Button("Pridat znamky");
	private static Button pridatZreby = new Button("Pridat zreby");
	private static Button pridatPohladnice = new Button("Pridat pohladnice");
	private static Button pridatCasopisy = new Button("Pridat casopisy");
	private static Button pridatNoviny = new Button("Pridat noviny");
	static GridPane tovaryPane = new GridPane();
	
	

	public static Scene Zobraz() throws ZleUdajeException  {
		Zoznamy<Object> zoznam = new Zoznamy<Object>();
		ZoznamTovarov.setPrefSize(400, 400);
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText("Nespravne vyplnene udaje. Prosim opravte udaje a skuste to znovu.");
		
		tovaryPane.setStyle("-fx-background-color: linear-gradient( #d3d3d3, #808080); -fx-font-size: 15px;");
		zoznamLabel.setStyle("-fx-font-size: 18px; "
				+ "-fx-font-weight:bold;");
		//tovaryPane.add(ZoznamTovarov, 0, 0);
		tovaryPane.add(znamkyLabel, 0, 1);
		tovaryPane.add(zrebyLabel, 0, 2);
		tovaryPane.add(pohladniceLabel, 0, 3);
		tovaryPane.add(novinyLabel, 0, 4);
		tovaryPane.add(casopisyLabel, 0, 5);
		
		tovaryPane.add(nazovZnamkyTxt, 1, 1);
		tovaryPane.add(pocetZnamkyTxt, 2, 1);
		tovaryPane.add(druhZnamkyTxt, 3, 1);
		
		tovaryPane.add(nazovZrebyTxt, 1, 2);
		tovaryPane.add(pocetZrebyTxt, 2, 2);
		tovaryPane.add(druhZrebyTxt, 3, 2);
		
		tovaryPane.add(nazovPohladniceTxt, 1, 3);
		tovaryPane.add(pocetPohladniceTxt, 2, 3);
		tovaryPane.add(druhPohladniceTxt, 3, 3);
		
		tovaryPane.add(nazovNovinyTxt, 1, 4);
		tovaryPane.add(pocetNovinyTxt, 2, 4);
		tovaryPane.add(druhNovinyTxt, 3, 4);
		
		tovaryPane.add(nazovCasopisyTxt, 1, 5);
		tovaryPane.add(pocetCasopisyTxt, 2, 5);
		tovaryPane.add(druhCasopisyTxt, 3, 5);
		
		tovaryPane.add(nazovLabel, 1, 0);
		tovaryPane.add(pocetLabel, 2, 0);
		tovaryPane.add(druhLabel, 3, 0);
		
		tovaryPane.add(pridatZnamky, 4, 1);
		tovaryPane.add(pridatZreby, 4, 2);
		tovaryPane.add(pridatPohladnice, 4, 3);
		tovaryPane.add(pridatNoviny, 4, 4);
		tovaryPane.add(pridatCasopisy, 4, 5);
		
		tovaryPane.add(ZoznamTovarov, 0, 7);
		tovaryPane.add(predatTovar, 0, 9);
		tovaryPane.add(pocetTxt, 1, 8);
		tovaryPane.add(pocetKsLabel, 0, 8);
		
		predatTovar.setOnAction(e -> {
			Tovary itemToRemove = (Tovary) ZoznamTovarov.getSelectionModel().getSelectedItem();
			try {
				itemToRemove.predatTovar(itemToRemove, Integer.parseInt(pocetTxt.getText()));
			} catch (NumberFormatException e1) {
				System.out.println("Chyba");
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ZleUdajeException e1) {
				System.out.println("Chyba");
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				System.out.println("Chyba");
			}
			
			ZoznamTovarov.getItems().remove(itemToRemove);
			ZoznamTovarov.getItems().add(itemToRemove);
			
			// text field pocet
		});
		
		pridatZnamky.setOnAction(e -> {
			Znamky znamky = new Znamky (nazovZnamkyTxt.getText(),Integer.parseInt(pocetZnamkyTxt.getText()), druhZnamkyTxt.getText());
			zoznam.add(znamky);
			
			ZoznamTovarov.getItems().add(znamky);
			System.out.println("Fungujem aj tu.");
		});
		
		pridatZreby.setOnAction(e -> {
			Zreby zreby = null;
			//try {
				try {
					zreby = new Zreby (nazovZrebyTxt.getText(), Integer.parseInt(pocetZrebyTxt.getText()), druhZrebyTxt.getText());
					zoznam.add(zreby);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ZleUdajeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			//}  catch (ZleUdajeException e1) {
			//	alert.show();
				// TODO Auto-generated catch block
			//	e1.printStackTrace();
			//	return;
		//	}
			if (zreby.isValid() == true) ZoznamTovarov.getItems().add(zreby);
			else alert.show();
			
			
			
		});
		
		pridatPohladnice.setOnAction(e -> {
			Pohladnice pohladnice = new Pohladnice (nazovPohladniceTxt.getText(), Integer.parseInt(pocetPohladniceTxt.getText()), druhPohladniceTxt.getText());
			ZoznamTovarov.getItems().add(pohladnice);
			zoznam.add(pohladnice);
		});
		
		pridatCasopisy.setOnAction(e -> {
			Casopisy casopisy = new Casopisy (nazovCasopisyTxt.getText(), Integer.parseInt(pocetCasopisyTxt.getText()), druhCasopisyTxt.getText());
			ZoznamTovarov.getItems().add(casopisy);
			zoznam.add(casopisy);
		});
		
		pridatNoviny.setOnAction(e -> {
			Noviny noviny = new Noviny (nazovNovinyTxt.getText(), Integer.parseInt(pocetNovinyTxt.getText()), druhNovinyTxt.getText());
			ZoznamTovarov.getItems().add(noviny);
			zoznam.add(noviny);
		});
			
		//tovaryPane.add(pridatTovar, 0, 1);
		//tovary = new Scene(tovaryPane, 1000, 1000);
		pridatTovar.setOnAction(e -> {
			System.out.println("Fungujem?");

		});
		
		zoznam.print();
		return new Scene(tovaryPane, 1000, 700);
		
	}

}
