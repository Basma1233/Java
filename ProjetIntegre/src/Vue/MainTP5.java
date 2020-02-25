
package Vue;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

public class MainTP5 extends Application {

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) {

		try
		{
	        primaryStage.setTitle("Gestion ?cole");
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainTP5.class.getResource("Projection.fxml"));  // koi????????????????????????????????????
            Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();

			// Quitter l'application avec les combinaisons CTRL+W
			final KeyCombination keyComb1 = new KeyCodeCombination(KeyCode.W,KeyCombination.CONTROL_DOWN);
			scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler() {

				@Override
				public void handle(Event event) {
					if (keyComb1.match((KeyEvent) event)) {
						primaryStage.close();
					}
				}
			});

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
