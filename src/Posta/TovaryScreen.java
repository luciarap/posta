package Posta;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class TovaryScreen {
	
	static ListView ZoznamTovarov = new ListView();
	private static Button pridatTovar = new Button("Pridat Tovar");
	
	static GridPane tovaryPane = new GridPane();


	
	public static Scene Zobraz() {
		
		tovaryPane.add(ZoznamTovarov, 0, 0);
		tovaryPane.add(pridatTovar, 0, 1);
		//tovary = new Scene(tovaryPane, 1000, 1000);
		pridatTovar.setOnAction(e -> {
			System.out.println("Fungujem?");

		});
		return new Scene(tovaryPane, 1000, 1000);
		
	}

}
