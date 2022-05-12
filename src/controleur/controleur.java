package controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import model.KeyPressed;
import model.Terrain1;

public class controleur implements Initializable{


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		constructionMap();
		Circle c = creeCercle();
		this.BorderPaneId.getChildren().add(c);


		BorderPaneId.addEventHandler(KeyEvent.KEY_PRESSED,new KeyPressed(c));
		BorderPaneId.addEventHandler(KeyEvent.KEY_RELEASED,new KeyPressed(c) );

	}

	@FXML
	private TilePane tuilesFond;
	@FXML
	private BorderPane BorderPaneId;


	//Construction de la map
	public void constructionMap() {


		tuilesFond.getChildren().clear();
		for(int cases = 0; cases < Terrain1.terrain.length ; cases++) {
			ImageView img;
			switch(Terrain1.terrain[cases]) {

			case 53 :
				img = new ImageView(new Image("/image/ciel.png"));
				break;

			case 192 :
				img = new ImageView(new Image("/image/terre.png"));
				break;

			default : 
				img = null;
				break;

			}

			tuilesFond.getChildren().add(img);

		}
	}



	public Circle creeCercle() {
		Circle c;
		c = new Circle(15);
		c.setCenterX(200);
		c.setCenterY(225);
		return c;

	}

}









