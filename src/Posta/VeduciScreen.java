package Posta;

import java.io.FileNotFoundException;

import Exceptions.ZleUdajeException;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * T�to trieda sl��i na zobrazenie �vodnej sc�ny, ak sa prihl�si ved�ci po�ty
 * 
 * @author Lucia Rao�nov�
 *
 */
public class VeduciScreen {
	GridPane pane = new GridPane();

	Scene uvod;
	Scene LoginScene;

	private Button Scene2 = new Button("Tovary");
	private Button Scene1 = new Button("Zasielky");
	private Button Logout = new Button("Log Out");
	private Button Zamestnanci = new Button("Zamestnanci");

	/**
	 * Met�da vybuduje sc�nu pre menu ved�ceho po�ty
	 * 
	 * @param hlavny je hlavn� stage, ktor� sa pou��va v GUI
	 * @param login  je sc�na s prihlasovacou obrazovkou
	 * @return vr�ti nov� vytvoren� sc�nu pre menu Ved�ceho po�ty
	 * @throws ZleUdajeException     ak nastala chyba pri vyp��an� �dajov
	 * @throws FileNotFoundException ak nastala chyba pri na��tavan� s�borov
	 */
	public Scene zobrazVeduciScreen(Stage hlavny, Scene login) throws ZleUdajeException, FileNotFoundException {

		ZasielkyScreen zasielkyScreen = new ZasielkyScreen();
		TovaryScreen tovaryScreen = new TovaryScreen();
		ZamestnanciScreen zamestnanciScreen = new ZamestnanciScreen();

		if (PostaGUI.tovary == null) {
			PostaGUI.tovary = tovaryScreen.Zobraz(hlavny);
		}
		Scene2.setOnAction(e -> {
			PostaGUI.povod = "veduci";
			hlavny.setScene(PostaGUI.tovary);
		});

		if (PostaGUI.zasielky == null) {
			PostaGUI.zasielky = zasielkyScreen.ZobrazZasielkyScreen(PostaGUI.veduciScena, hlavny);
		}
		Scene1.setOnAction(e -> {
			PostaGUI.povod = "veduci";
			hlavny.setScene(PostaGUI.zasielky);
		});

		if (PostaGUI.zamestnanci == null) {
			PostaGUI.zamestnanci = zamestnanciScreen.ZobrazZamestnanciScreen(PostaGUI.veduciScena, hlavny);
		}
		Zamestnanci.setOnAction(e -> hlavny.setScene(PostaGUI.zamestnanci));

		HBox veduciHBox = new HBox();
		veduciHBox.setPadding(new Insets(15, 12, 15, 12));
		veduciHBox.setSpacing(10);
		veduciHBox.setStyle("-fx-background-color:  #5f9ea0;");
		Scene2.setPrefSize(100, 20);
		Scene1.setPrefSize(100, 20);
		Zamestnanci.setPrefSize(130, 20);
		Logout.setPrefSize(100, 20);
		veduciHBox.getChildren().addAll(Scene2, Scene1, Zamestnanci, Logout);

		Logout.setOnAction(e -> hlavny.setScene(login));

		return new Scene(veduciHBox, 500, 80);
	}

}
