package Posta;

import Exceptions.ZleUdajeException;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Táto trieda slúži na zobrazenie úvodnej scény, ak sa prihlási pracovník
 * 
 * @author Lucia Rapánová
 *
 */
public class PracovnikScreen {
	GridPane pane = new GridPane();
	Scene uvod;
	Scene LoginScene;
	Scene PracovnikScena;
	private Button Scene2 = new Button("Tovary");
	private Button Scene1 = new Button("Zasielky");
	private Button Logout = new Button("Log Out");

	/**
	 * Metóda vybuduje scénu pre pracovníka
	 * 
	 * @param hlavny je hlavný Stage, ktorý sa používa
	 * @param login  je predošlá scéna, kde sa užívatelia prihlasujú
	 * @return vytvorenú scénu pre pracovníka
	 * @throws ZleUdajeException pri zle zadaných dátach
	 */
	public Scene zobrazPracovnikScreen(Stage hlavny, Scene login) throws ZleUdajeException {

		TovaryScreen tovaryScreen = new TovaryScreen();
		ZasielkyScreen zasielkyScreen = new ZasielkyScreen();

		/**
		 * kontrola, èi scéna už existuje
		 */
		if (PostaGUI.tovary == null) {
			/**
			 * vytváranie scény
			 */
			PostaGUI.tovary = tovaryScreen.Zobraz(hlavny);
		}
		Scene2.setOnAction(e -> {
			PostaGUI.povod = "pracovnik";
			hlavny.setScene(PostaGUI.tovary);
		});

		/**
		 * kontrola, èi scéna už existuje
		 */
		if (PostaGUI.zasielky == null) {
			/**
			 * vytváranie scény
			 */
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

		return new Scene(PracovnikHBox, 380, 80);
	}

}