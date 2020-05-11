package Posta;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class VeduciScreen {
	GridPane pane = new GridPane();
	Scene tovary;
	Scene zasielky;
	Scene uvod;
	Scene LoginScene;
	Scene skrolScene;
	Scene veduciScena;
	Scene zamestnanci;
	private Button Scene2 = new Button("Tovary");
	private Button Scene1 = new Button("Zasielky");
	private Button Logout = new Button("Log Out");
	private Button Zamestnanci = new Button("Zamestnanci");

	public Scene zobrazVeduciScreen(Stage hlavny) {
		
		TovaryScreen tovaryScreen = new TovaryScreen();
		tovary = tovaryScreen.Zobraz();
		Scene2.setOnAction(e -> hlavny.setScene(tovary));
		//poslat stage cez argument

		ZasielkyScreen zasielkyScreen = new ZasielkyScreen();
		zasielky = zasielkyScreen.ZobrazZasielkyScreen(veduciScena, hlavny);
		Scene1.setOnAction(e -> hlavny.setScene(zasielky));
		
		ZamestnanciScreen zamestnanciScreen = new ZamestnanciScreen();
		zamestnanci = zamestnanciScreen.ZobrazZamestnanciScreen(veduciScena, hlavny);
		Zamestnanci.setOnAction(e -> hlavny.setScene(zamestnanci));

		HBox veduciHBox = new HBox();
		veduciHBox.setPadding(new Insets(15, 12, 15, 12));
		veduciHBox.setSpacing(10);
		veduciHBox.setStyle("-fx-background-color:  #5f9ea0;");
		Scene2.setPrefSize(100, 20);
		Scene1.setPrefSize(100, 20);
		Zamestnanci.setPrefSize(130, 20);
		Logout.setPrefSize(100, 20);
		veduciHBox.getChildren().addAll(Scene2, Scene1, Zamestnanci, Logout);
		//veduciScena = new Scene(veduciHBox, 500, 400);
		
		//hlavny.setScene(hlavna);
		// TODO Auto-generated method stub
		return new Scene(veduciHBox, 1000, 1000);
	}

}
