package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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
	public void handle(MouseEvent arg0) {

		
		int x = (int)arg0.getX()/tailleTuile;
		int y = (int)arg0.getY()/tailleTuile;

		int positionTuileDansTableau;

		System.out.println("\nAffichage X" + x+ "Affichage Y"+ y);
		positionTuileDansTableau = (y * tailleMapLongueur  ) + x;

		
			eren.miner(positionTuileDansTableau,terrain);
			terrainVue.dessinerTerrain();; // changer et faire une fonction qui actualise juste l'image changé

			System.out.println("\n positionTuileDansTableau" + positionTuileDansTableau);

	}

}


