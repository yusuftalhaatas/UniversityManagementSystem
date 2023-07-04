package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Load the FXML file
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("MainPage.fxml"));
			
			// Create the scene with the loaded root and set its dimensions
			Scene scene = new Scene(root, 600, 400);
			
			// Add the application.css stylesheet to the scene
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Set the scene to the primary stage and display it
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// Launch the JavaFX application
		launch(args);
	}
}
