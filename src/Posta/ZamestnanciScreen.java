package Posta;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ZamestnanciScreen {
	
	GridPane pane = new GridPane();
	private Button spat = new Button("Spä");

	public Scene ZobrazZamestnanciScreen(Scene hlavna, Stage hlavny) {
		// TODO Auto-generated method stub
		VeduciScreen screen = new VeduciScreen();
		pane.add(spat, 0, 0);
		spat.setOnAction(e -> {
			screen.zobrazVeduciScreen(hlavna, hlavny);
			return;

		});
		return new Scene(pane, 1000, 1000);
		
	}

}
