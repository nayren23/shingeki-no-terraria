package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jeu.Parametre;
import jeu.model.Heros;
import jeu.model.Terrain;
import jeu.model.inventaire.arme.Pelle;
import jeu.model.inventaire.arme.Pioche;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Terre;
import jeu.vue.TerrainVue;

public class MouseClick implements EventHandler<MouseEvent> {

	private Heros eren;
	public Terrain terrain;
	public TerrainVue terrainVue;
	
	public Pelle pelle;
	public Terre terre;
	public Fer fer;
	public Pioche pioche;
	public static int tailleTuile = 32;
	public static int tailleMapLongueur = 40;  // nombre de tuiles dans une ligne

	public MouseClick(Heros eren, Terrain terrain, TerrainVue terrainVue) {
		this.eren = eren;
		this.terrain = terrain;
		this.terrainVue = terrainVue;
		this.pelle = new Pelle();
		this.terre = new Terre();
		this.fer = new Fer();
		this.pioche = new Pioche();

	}

	@Override
	/**
	 * Methodes utiliser pour connaitre les coordonner de d une tuile lorsqu on clique sur la souris
	 */
	public void handle(MouseEvent arg0) {


		// Pour connaitre la position d une tuile on divise notre taille par la taille de notre tuile
		int x = (int)arg0.getX()/tailleTuile;
		int y = (int)arg0.getY()/tailleTuile;
		int positionTuileDansTableau = (y * tailleMapLongueur  ) + x;
		//System.out.println("\nAffichage X " + x+ " Affichage Y "+ y);

		int objet = this.eren.getObjetHeros().getIdObjet();
		//en fonction de l objet equipe ont fait differentes action creuser ou poser un bloc
		switch (objet) {

		case 12: 
			if(arg0.getButton() == MouseButton.SECONDARY) {
				terre.poserBloc(positionTuileDansTableau, terrain);
				terrainVue.changementTuileMinage(positionTuileDansTableau,terrain,Parametre.blocHerbe);// changer et faire une fonction qui actualise juste l'image changé			}
			}
			break;

		case 1:
			if (arg0.getButton() == MouseButton.PRIMARY) {
				pioche.creuser(positionTuileDansTableau,terrain);
				terrainVue.changementTuileMinage(positionTuileDansTableau,terrain,Parametre.changementDuBlocCasserPelle); // changer et faire une fonction qui actualise juste l'image changï¿½
				//System.out.println("\n positionTuileDansTableau " + positionTuileDansTableau);
			}

		case 7: 
			if(arg0.getButton() == MouseButton.SECONDARY) {
				fer.poserBloc(positionTuileDansTableau, terrain);
				terrainVue.changementTuileMinage(positionTuileDansTableau,terrain,Parametre.blocFer);// changer et faire une fonction qui actualise juste l'image changé			}
			}
			break;
		case 3:
			if (arg0.getButton() == MouseButton.PRIMARY) {
				pelle.creuser(positionTuileDansTableau,terrain);
				terrainVue.changementTuileMinage(positionTuileDansTableau,terrain,Parametre.changementDuBlocCasserPelle); // changer et faire une fonction qui actualise juste l'image changï¿½
				//System.out.println("\n positionTuileDansTableau " + positionTuileDansTableau);
			}
			break;

		}
	}

}




