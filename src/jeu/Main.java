package jeu;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/jeu/vue/fenetre_principale.fxml"));
			final Scene scene = new Scene(root,1280,702);
			root.requestFocus();
			primaryStage.setTitle("Shingeki No Terraria");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.getIcons().add(new Image("jeu/image/Eren1.png"));
			primaryStage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
