package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.Heros;
import jeu.model.Terrain;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.outil.Outil;
import jeu.model.inventaire.outil.Pelle;
import jeu.model.inventaire.outil.Pioche;
import jeu.model.inventaire.ressource.Fer;
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
		//System.out.println("\nAffichage X " + x+ " Affichage Y "+ y);

		
		Objet objet = this.env.getEren().getObjetHeros();
		//en fonction de l objet equipe ont fait differentes action creuser ou poser un bloc

		if (objet instanceof Pioche && arg0.getButton() == MouseButton.PRIMARY  ) {
			env.getEren().getInventaireHeros().faireDegatsBloc((Outil) objet, positionTuileDansTableau);
			env.getEren().getInventaireHeros().creationBlocCasser((Outil) objet , positionTuileDansTableau);
			terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.changementDuBlocCasser);// changer et faire une fonction qui actualise juste l'image chang�			}

//			((Pioche) objet).faireDegatsBloc(positionTuileDansTableau, env.getTerrain());
//			terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.changementDuBlocCasserPelle); // changer et faire une fonction qui actualise juste l'image changer
		}


		else if(objet instanceof Terre && arg0.getButton() == MouseButton.SECONDARY) {
			((Terre) objet).poserBloc(positionTuileDansTableau, env.getTerrain());
			Terre terre = new Terre();
			env.getRessources().set(positionTuileDansTableau, terre);
			terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.blocHerbe);// changer et faire une fonction qui actualise juste l'image chang�			}
		}

		else if(objet instanceof Fer && arg0.getButton() == MouseButton.SECONDARY) {
			System.out.println("\nAffichage  Je pose bloc ferrr ") ;
			((Fer) objet).poserBloc(positionTuileDansTableau, env.getTerrain());
			Fer fer = new Fer();
			env.getRessources().set(positionTuileDansTableau, fer);
			terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.blocFer);// changer et faire une fonction qui actualise juste l'image chang�			}
		}

		else if(objet instanceof Pelle && arg0.getButton() == MouseButton.PRIMARY) {
			env.getEren().getInventaireHeros().faireDegatsBloc((Outil) objet, positionTuileDansTableau);
			env.getEren().getInventaireHeros().creationBlocCasser((Outil) objet , positionTuileDansTableau);// changer et faire une fonction qui actualise juste l'image chang�
			terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.changementDuBlocCasser);// changer et faire une fonction qui actualise juste l'image chang�			}

		}
	}
}