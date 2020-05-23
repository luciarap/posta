package Posta;

import Exceptions.ZleUdajeException;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * T�to trieda sl��i na zobrazenie �vodnej sc�ny, ak sa prihl�si pracovn�k
 * 
 * @author Lucia Rap�nov�
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
	 * Met�da vybuduje sc�nu pre pracovn�ka
	 * 
	 * @param hlavny je hlavn� Stage, ktor� sa pou��va
	 * @param login  je predo�l� sc�na, kde sa u��vatelia prihlasuj�
	 * @return vytvoren� sc�nu pre pracovn�ka
	 * @throws ZleUdajeException pri zle zadan�ch d�tach
	 */
	public Scene zobrazPracovnikScreen(Stage hlavny, Scene login) throws ZleUdajeException {

		TovaryScreen tovaryScreen = new TovaryScreen();
		ZasielkyScreen zasielkyScreen = new ZasielkyScreen();

		/**
		 * kontrola, �i sc�na u� existuje
		 */
		if (PostaGUI.tovary == null) {
			/**
			 * vytv�ranie sc�ny
			 */
			PostaGUI.tovary = tovaryScreen.Zobraz(hlavny);
		}
		Scene2.setOnAction(e -> {
			PostaGUI.povod = "pracovnik";
			hlavny.setScene(PostaGUI.tovary);
		});

		/**
		 * kontrola, �i sc�na u� existuje
		 */
		if (PostaGUI.zasielky == null) {
			/**
			 * vytv�ranie sc�ny
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