package jeu;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("fenetre_principale.fxml"));
			final Scene scene = new Scene(root,500,400);
			root.requestFocus();
			primaryStage.setTitle("SNT");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			//Savoir les touches
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					System.out.println(event.getCode());
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
