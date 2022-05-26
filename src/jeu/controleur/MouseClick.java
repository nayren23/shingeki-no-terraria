package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.Heros;
import jeu.model.Terrain;
import jeu.vue.TerrainVue;

public class MouseClick implements EventHandler<MouseEvent> {

	private Heros eren;
	public Terrain terrain;
	public TerrainVue terrainVue;
	public static int tailleTuile = 32;
	public static int tailleMapLongueur = 40;  // nombre de tuiles dans une ligne
	public MouseClick(Heros eren, Terrain terrain, TerrainVue terrainVue) {
		this.eren = eren;
		this.terrain = terrain;
		this.terrainVue = terrainVue;
	}

	@Override
	/**
	 * Methodes utiliser pour connaitre les coordonner de d une tuile lorsqu on clique sur la souris
	 */
	public void handle(MouseEvent arg0) {
		
		
		// Pour connaitre la position d une tuile on divise notre taille par la taille de notre tuile
		int x = (int)arg0.getX()/tailleTuile;
		int y = (int)arg0.getY()/tailleTuile;
		int positionTuileDansTableau;
		
		//System.out.println("\nAffichage X" + x+ "Affichage Y"+ y);
		positionTuileDansTableau = (y * tailleMapLongueur  ) + x;
		
		//Gestion du click droit
		if (arg0.getButton() == MouseButton.SECONDARY) {
				eren.casserBloc(positionTuileDansTableau,terrain);
				terrainVue.changementTuileMinage(positionTuileDansTableau,terrain,Parametre.changementDuBlocCasser);// changer et faire une fonction qui actualise juste l'image changé
				//System.out.println("\n positionTuileDansTableau" + positionTuileDansTableau);
		}
		
		//Gestion du click gauche
		else if(arg0.getButton() == MouseButton.PRIMARY) {
			eren.construireTuile(positionTuileDansTableau, terrain);
			terrainVue.changementTuileMinage(positionTuileDansTableau,terrain,Parametre.changementDuBlocConstruit);// changer et faire une fonction qui actualise juste l'image changé
		}
	}

}


