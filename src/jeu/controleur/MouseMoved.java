package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseMoved implements EventHandler<MouseEvent> {

	public static int tailleTuile = 32;
	public static int tailleMapLongueur = 40;  // nombre de tuiles dans une ligne

	
	public MouseMoved() {
		}

	@Override
	public void handle(MouseEvent event) {
		int x = (int)event.getX()/tailleTuile;
		int y = (int)event.getY()/tailleTuile;
		
		int positionTuileDansTableau;

			System.out.println("\nAffichage X" + x+ "Affichage Y"+ y);
			
			positionTuileDansTableau = (y * tailleMapLongueur  ) + x;
			System.out.println("\n positionTuileDansTableau" + positionTuileDansTableau);
			}
	
	
	
	}



