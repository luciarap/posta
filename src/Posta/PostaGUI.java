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
	
	private ScrollPane skrol = new ScrollPane();

	Scene skrolScene;
	Scene veduciScena;
	Scene pracovnikScena;
	Alert alert = new Alert(AlertType.ERROR);

	public void start(Stage hlavneOkno) throws Exception {
		alert.setContentText("Nespravne meno alebo heslo.");
		hlavneOkno.setTitle("Posta");
		GridPane Login = new GridPane();
		Label labelUserName = new Label("Username");
		final TextField txtUserName = new TextField();
		Label lblPassword = new Label("Password");
		final PasswordField pf = new PasswordField();
		Button buttonLogin = new Button("Login");
		
		LoginController loginController = new LoginController();

		Login.add(labelUserName, 0, 0);
		Login.add(txtUserName, 1, 0);
		Login.add(lblPassword, 0, 1);
		Login.add(pf, 1, 1);
		Login.add(buttonLogin, 0, 2);
		
		skrol.setContent(Login);
		
		
		buttonLogin.setOnAction(e -> {
		
			if (loginController.validateUser(txtUserName.getText(),pf.getText()) == "veduci") {
				VeduciScreen veduciScreen = new VeduciScreen();
				try {
					veduciScena = veduciScreen.zobrazVeduciScreen(hlavneOkno);
				} catch (ZleUdajeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				hlavneOkno.setScene(veduciScena);
			}
			
			else if (loginController.validateUser(txtUserName.getText(),pf.getText()) == "pracovnik") {
				PracovnikScreen pracovnikScreen = new PracovnikScreen();
				try {
					pracovnikScena = pracovnikScreen.zobrazPracovnikScreen(hlavneOkno);
				} catch (ZleUdajeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				hlavneOkno.setScene(pracovnikScena);
			}
			else {
				alert.show();
			}
			
			txtUserName.setText("");
			pf.setText("");

		});
		
		skrolScene = new Scene(skrol, 300, 150);
		hlavneOkno.setScene(skrolScene);
		hlavneOkno.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
