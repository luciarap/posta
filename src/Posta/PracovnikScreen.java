package Posta;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PracovnikScreen {
	GridPane pane = new GridPane();
	//static Scene tovary;
	//static Scene zasielky;
	Scene uvod;
	Scene LoginScene;
//	Scene skrolScene;
	Scene PracovnikScena;
//	Scene zamestnanci;
	private Button Scene2 = new Button("Tovary");
	private Button Scene1 = new Button("Zasielky");
	private Button Logout = new Button("Log Out");

	public Scene zobrazPracovnikScreen(Stage hlavny, Scene login) throws ZleUdajeException {

		TovaryScreen tovaryScreen = new TovaryScreen();
		ZasielkyScreen zasielkyScreen = new ZasielkyScreen();
		
		
		if (PostaGUI.tovary == null) {
			PostaGUI.tovary = tovaryScreen.Zobraz();
		}
		Scene2.setOnAction(e -> hlavny.setScene(PostaGUI.tovary));
		
		
		if (PostaGUI.zasielky == null) {
			PostaGUI.zasielky = zasielkyScreen.ZobrazZasielkyScreen(PracovnikScena, hlavny);
		}
		Scene1.setOnAction(e -> {
			PostaGUI.povod = "pracovnik";
			hlavny.setScene(PostaGUI.zasielky);
		});

		HBox PracovnikHBox = new HBox();
		PracovnikHBox.setPadding(new Insets(15, 12, 15, 12));
		PracovnikHBox.setSpacing(10);
		PracovnikHBox.setStyle("-fx-background-color:  #e6e6fa;");
		Scene2.setPrefSize(100, 20);
		Scene1.setPrefSize(100, 20);
		Logout.setPrefSize(100, 20);
		PracovnikHBox.getChildren().addAll(Scene2, Scene1, Logout);
		
		Logout.setOnAction(e -> hlavny.setScene(login));
		
		//Logout.setOnAction(e -> hlavny.setScene(skrolScene));
		//veduciScena = new Scene(veduciHBox, 500, 400);
		
		//hlavny.setScene(hlavna);
		// TODO Auto-generated method stub
		return new Scene(PracovnikHBox, 500, 400);
	}

}