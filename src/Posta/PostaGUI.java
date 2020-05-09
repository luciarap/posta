package Posta;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

import Zamestnanci.Dorucovatel;
import Zamestnanci.Pracovnik;
import Zamestnanci.VeduciPosty;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zasielky.Dobierka;
import zasielky.DoporucenyList;
import zasielky.Zasielky;
import Posta.Posta;
import Posta.CheckLogin;

public class PostaGUI extends Application {
	
	private Button Scene2 = new Button("Tovary");
	private Button Scene1 = new Button("Zasielky");
	private Button Logout = new Button("Log Out");
	private Button Zamestnanci = new Button("Zamestnanci");
	private ScrollPane skrol = new ScrollPane();

	Scene tovary;
	Scene zasielky;
	Scene uvod;
	Scene LoginScene;
	Scene skrolScene;
	Scene veduciScena;
	Scene zamestnanci;

	public void start(Stage hlavneOkno) throws Exception {
		
		hlavneOkno.setTitle("Posta");
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
		
		skrol.setContent(Login);

		TovaryScreen tovaryScreen = new TovaryScreen();
		tovary = tovaryScreen.Zobraz();
		Scene2.setOnAction(e -> hlavneOkno.setScene(tovary));
		//poslat stage cez argument

		ZasielkyScreen zasielkyScreen = new ZasielkyScreen();
		zasielky = zasielkyScreen.ZobrazZasielkyScreen(veduciScena, hlavneOkno);
		Scene1.setOnAction(e -> hlavneOkno.setScene(zasielky));
		
		ZamestnanciScreen zamestnanciScreen = new ZamestnanciScreen();
		zamestnanci = zamestnanciScreen.ZobrazZamestnanciScreen(veduciScena, hlavneOkno);
		Zamestnanci.setOnAction(e -> hlavneOkno.setScene(zamestnanci));

		HBox veduciHBox = new HBox();
		veduciHBox.setPadding(new Insets(15, 12, 15, 12));
		veduciHBox.setSpacing(10);
		veduciHBox.setStyle("-fx-background-color:  #5f9ea0;");
		Scene2.setPrefSize(100, 20);
		Scene1.setPrefSize(100, 20);
		Zamestnanci.setPrefSize(130, 20);
		Logout.setPrefSize(100, 20);
		veduciHBox.getChildren().addAll(Scene2, Scene1, Zamestnanci, Logout);
		veduciScena = new Scene(veduciHBox, 500, 400);
		
		buttonLogin.setOnAction(e -> {
			if (txtUserName.getText().toString().equals(CheckLogin.getVeduciUsername())
					&& pf.getText().toString().equals(CheckLogin.getVeduciPassword())) {
				hlavneOkno.setScene(veduciScena);
				hlavneOkno.show();
			} else {
				System.out.println("Chyba");

			}
			txtUserName.setText("");
			pf.setText("");

		});
		
		
		Logout.setOnAction(e -> hlavneOkno.setScene(skrolScene));
		
		skrolScene = new Scene(skrol, 300, 150);
		hlavneOkno.setScene(skrolScene);
		hlavneOkno.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
