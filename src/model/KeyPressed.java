package model;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public class KeyPressed implements EventHandler<KeyEvent>{


	private Circle c;

	public KeyPressed(Circle c) {
		this.c = c;


	}

	@Override
	
	//Deplacement
	public void handle(KeyEvent event) {

		switch(event.getCode()) {
		case Q:
			System.out.println("a gauche");

			c.setCenterX(c.getCenterX() - 5);
			
			break;

		case D:
			System.out.println("a droite");
			
			c.setCenterX(c.getCenterX() + 5);

			break;
			
		
		

		default:
		}
	}
}

