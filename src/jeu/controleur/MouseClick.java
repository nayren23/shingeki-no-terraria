package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.Heros;
import jeu.model.Terrain;
import jeu.model.inventaire.Inventaire;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.outil.Outil;
import jeu.model.inventaire.outil.Pelle;
import jeu.model.inventaire.outil.Pioche;
import jeu.model.inventaire.ressource.Charbon;
import jeu.model.inventaire.ressource.Ciel;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Gaz;
import jeu.model.inventaire.ressource.Pain;
import jeu.model.inventaire.ressource.Terre;
import jeu.vue.TerrainVue;

public class MouseClick implements EventHandler<MouseEvent> {


	private Environnement env;
	private TerrainVue terrainVue;

	public static int tailleTuile = 32;
	public static int tailleMapLongueur = 40;  // nombre de tuiles dans une ligne

	public MouseClick(Environnement env ,TerrainVue terrainVue) {
		this.env = env;
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
		int positionTuileDansTableau = (y * tailleMapLongueur  ) + x;

		Objet objet = this.env.getEren().getObjetHeros();
		int xCase = (int)arg0.getX();
		int yCase = (int)arg0.getY();
		//en fonction de l objet equipe ont fait differentes action creuser ou poser un bloc
		//		System.out.println("Coordonnee eren x" +env.getEren().getX());
		//		System.out.println("Coordonnee eren Y" +env.getEren().getY());
		//		System.out.println("\nAffichage X " + xCase+ " Affichage Y "+ yCase);
		//si pas mort alors peut faire action de la souris
		if(!env.getEren().estMort()) {

			//	(int coordonneeJoueurX, int coordonneeJoueurY , int positionBlocX, int positionBlocY ,int rangeGauche , int rangeDroite , int rangeHaut ,int rangeBas ) {

			if (Parametre.rangePourCasserBloc(env.getEren().getX(), env.getEren().getY(), xCase ,yCase, 30*2, 47*2 , 25*2, 64*2)) {

				Inventaire inv = env.getEren().getInventaireHeros();
				if (objet instanceof Pioche && arg0.getButton() == MouseButton.PRIMARY  ) {
					env.getEren().getInventaireHeros().faireDegatsBloc((Outil) objet, positionTuileDansTableau, env.getTerrain());
					env.getEren().getInventaireHeros().creationBlocCasser((Outil) objet , positionTuileDansTableau);
					terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.changementDuBlocCasser);
				}

				else if(objet instanceof Pelle && arg0.getButton() == MouseButton.PRIMARY) {
					env.getEren().getInventaireHeros().faireDegatsBloc((Outil) objet, positionTuileDansTableau, env.getTerrain());
					env.getEren().getInventaireHeros().creationBlocCasser((Outil) objet , positionTuileDansTableau);
					terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.changementDuBlocCasser);
				}


				//int rangeGauche , int rangeDroite , int rangeHaut ,int rangeBas
				else if(objet instanceof Terre && arg0.getButton() == MouseButton.SECONDARY) {
					Terre terre = new Terre();
					if(this.env.getEren().getInventaireHeros().verifierRessource(terre)) {
						((Terre) objet).poserBloc(positionTuileDansTableau, env.getTerrain(),Parametre.blocTerre);
						terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.blocTerre);

						// Inventaire
						env.getRessources().set(positionTuileDansTableau, terre);
						env.getEren().getInventaireHeros().detruireRessource(terre);
					}
				}

				else if(objet instanceof Fer && arg0.getButton() == MouseButton.SECONDARY) {
					Fer fer = new Fer();
					if(this.env.getEren().getInventaireHeros().verifierRessource(fer)) {
						((Fer) objet).poserBloc(positionTuileDansTableau, env.getTerrain(),Parametre.blocFer);
						terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.blocFer);

						// Inventaire
						env.getRessources().set(positionTuileDansTableau, fer);
						env.getEren().getInventaireHeros().detruireRessource(fer);
					}
				}

				else if(objet instanceof Charbon && arg0.getButton() == MouseButton.SECONDARY) {
					Charbon charbon = new Charbon();
					if(this.env.getEren().getInventaireHeros().verifierRessource(charbon)) {
						((Charbon) objet).poserBloc(positionTuileDansTableau, env.getTerrain(),Parametre.blocCharbon);
						terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.blocCharbon);

						// Inventaire
						env.getRessources().set(positionTuileDansTableau, charbon);
						env.getEren().getInventaireHeros().detruireRessource(charbon);
					}
				}

				else if(objet instanceof Gaz && arg0.getButton() == MouseButton.SECONDARY) {
					Gaz gaz = new Gaz();
					if(this.env.getEren().getInventaireHeros().verifierRessource(gaz)) {
						((Gaz) objet).poserBloc(positionTuileDansTableau, env.getTerrain(),Parametre.blocGaz);
						terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.blocGaz);

						// Inventaire
						env.getRessources().set(positionTuileDansTableau, gaz);
						env.getEren().getInventaireHeros().detruireRessource(gaz);
					}
				}
			}
			else if(objet instanceof Pain) {
				Pain pain = new Pain();
				env.getEren().augmenterPv(pain);
				env.getEren().getInventaireHeros().detruireRessource(pain);
			}
		}
	}
}
