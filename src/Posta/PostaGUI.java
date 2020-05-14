package Posta;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PostaGUI extends Application {
	
	private ScrollPane skrol = new ScrollPane();

	Scene skrolScene;
	static Scene veduciScena;
	static Scene pracovnikScena;
	Alert alert = new Alert(AlertType.ERROR);
	static Scene tovary;
	static Scene zasielky;
	static Scene zamestnanci;

	public void start(Stage hlavneOkno) throws Exception {
		tovary = null;
		zasielky = null;
		veduciScena = null;
		pracovnikScena = null;
		zamestnanci = null;
		
		//hlavneOkno.getIcons().add(new Image(("file:letter.png")));
		
		VeduciScreen veduciScreen = new VeduciScreen();
		PracovnikScreen pracovnikScreen = new PracovnikScreen();
		
		
		alert.setContentText("Nespravne meno alebo heslo.");
		hlavneOkno.setTitle("Posta");
		GridPane Login = new GridPane();
		//Login.setStyle("-fx-background-color:  #6a5acd;");
		Label labelUserName = new Label("Username");
		labelUserName.setFont((Font.font("Times New Roman", 15)));
		final TextField txtUserName = new TextField();
		Label lblPassword = new Label("Password");
		lblPassword.setFont((Font.font("Times New Roman", 15)));
		final PasswordField pf = new PasswordField();
		Button buttonLogin = new Button("Login");
		buttonLogin.setFont((Font.font("Times New Roman", 15)));
		
		LoginController loginController = new LoginController();

		Login.add(labelUserName, 0, 0);
		Login.add(txtUserName, 1, 0);
		Login.add(lblPassword, 0, 1);
		Login.add(pf, 1, 1);
		Login.add(buttonLogin, 0, 2);
		
		skrol.setContent(Login);
		
		
		buttonLogin.setOnAction(e -> {
		
			if (loginController.validateUser(txtUserName.getText(),pf.getText()) == "veduci") {
				
				if (veduciScena == null) {
					try {
						veduciScena = veduciScreen.zobrazVeduciScreen(hlavneOkno,skrolScene);
					} catch (ZleUdajeException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
					// TODO Auto-generated catch block

				hlavneOkno.setScene(veduciScena);
			}
			
			else if (loginController.validateUser(txtUserName.getText(),pf.getText()) == "pracovnik") {
				
				if (pracovnikScena == null) {
				
				try {
					pracovnikScena = pracovnikScreen.zobrazPracovnikScreen(hlavneOkno,skrolScene);
				} catch (ZleUdajeException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
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
