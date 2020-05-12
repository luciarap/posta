package Posta;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PracovnikScreen {
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

	public Scene zobrazPracovnikScreen(Stage hlavny) throws ZleUdajeException {
		
		TovaryScreen tovaryScreen = new TovaryScreen();
		tovary = tovaryScreen.Zobraz();
		Scene2.setOnAction(e -> hlavny.setScene(tovary));
		//poslat stage cez argument

		ZasielkyScreen zasielkyScreen = new ZasielkyScreen();
		zasielky = zasielkyScreen.ZobrazZasielkyScreen(veduciScena, hlavny);
		Scene1.setOnAction(e -> hlavny.setScene(zasielky));

		HBox PracovnikHBox = new HBox();
		PracovnikHBox.setPadding(new Insets(15, 12, 15, 12));
		PracovnikHBox.setSpacing(10);
		PracovnikHBox.setStyle("-fx-background-color:  #e6e6fa;");
		Scene2.setPrefSize(100, 20);
		Scene1.setPrefSize(100, 20);
		Logout.setPrefSize(100, 20);
		PracovnikHBox.getChildren().addAll(Scene2, Scene1, Logout);
		
		//Logout.setOnAction(e -> hlavny.setScene(skrolScene));
		//veduciScena = new Scene(veduciHBox, 500, 400);
		
		//hlavny.setScene(hlavna);
		// TODO Auto-generated method stub
		return new Scene(PracovnikHBox, 500, 400);
	}

}