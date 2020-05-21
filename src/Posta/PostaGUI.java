package Posta;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import Exceptions.ZleUdajeException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Simulácia poštového systému.
 * Táto trieda je hlavné GUI, odkia¾ sa púša aplikácia
 * @author Lucia Rapánová
 *
 */
public class PostaGUI extends Application {
	
	private ScrollPane skrol = new ScrollPane();

	Scene skrolScene;
	static Scene veduciScena;
	static Scene pracovnikScena;
	Alert alert = new Alert(AlertType.ERROR);
	static Scene tovary;
	static Scene zasielky;
	static Scene zamestnanci;
	static String povod;
	
	/**
	 * @param hlavneOkno je jeden hlavný stage, ktorý sa púša v aplikácii
	 * @see LoginController#validateUser(String username, String password) vyhodnocovanie používate¾ských údajov
	 */
	public void start(Stage hlavneOkno) throws Exception {
		FileInputStream inputstream = new FileInputStream("obrazky\\letter.png"); 
		Image image = new Image(inputstream);
		ImageView imageView = new ImageView(image);
	    imageView.setFitHeight(46); 
	    imageView.setFitWidth(82); 
	    imageView.setPreserveRatio(true);  
	    /**
	     * sú to globálne premenné kvôli tomu, aby sa dalo zisti, èi boli tieto scény už vytvorené, alebo ich treba vytvori (pri odhlásení používate¾a)
	     * 
	     */
		tovary = null;
		zasielky = null;
		veduciScena = null;
		pracovnikScena = null;
		zamestnanci = null;
	
		VeduciScreen veduciScreen = new VeduciScreen();
		PracovnikScreen pracovnikScreen = new PracovnikScreen();
		
		alert.setContentText("Nespravne meno alebo heslo.");
		hlavneOkno.setTitle("Posta");
		GridPane Login = new GridPane();
		Login.setStyle("-fx-background-color:  #ffffff;");
		Login.setPrefSize(350, 200);
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
		Login.add(txtUserName, 0, 0);
		Login.add(lblPassword, 0, 0);
		Login.add(pf, 0, 0);
		Login.add(buttonLogin, 0, 2);
		Login.add(imageView, 0, 0);
		
		imageView.setTranslateX(140);
		imageView.setTranslateY(5);
		
		labelUserName.setTranslateX(25);
		labelUserName.setTranslateY(50);
		txtUserName.setTranslateX(100);
		txtUserName.setTranslateY(50);
		
		lblPassword.setTranslateX(25);
		lblPassword.setTranslateY(85);
		pf.setTranslateX(100);
		pf.setTranslateY(85);
		
		buttonLogin.setTranslateX(140);
		buttonLogin.setTranslateY(90);
		
		skrol.setContent(Login);
		
		buttonLogin.setOnAction(e -> {
		
			if (loginController.validateUser(txtUserName.getText(),pf.getText()) == "veduci") {
				
				if (veduciScena == null) { 
					try {
						veduciScena = veduciScreen.zobrazVeduciScreen(hlavneOkno, skrolScene);
					} catch (ZleUdajeException e1) {
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}

				hlavneOkno.setScene(veduciScena);
			}
			
			else if (loginController.validateUser(txtUserName.getText(),pf.getText()) == "pracovnik") {
				
				if (pracovnikScena == null) { 
				
				try {
					pracovnikScena = pracovnikScreen.zobrazPracovnikScreen(hlavneOkno, skrolScene);
				} catch (ZleUdajeException e1) {
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
		
		skrolScene = new Scene(skrol, 350, 200);
		hlavneOkno.setScene(skrolScene);
		hlavneOkno.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
