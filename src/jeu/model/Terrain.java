package jeu.model;

import java.util.ArrayList;

public class Terrain {

	/**
	 * On ne d�clare qu'une seule fois les bloc qu'on peut miner que l on stocke dans une ArrayList 
	 */
	private ArrayList<Integer>listeBlocMinable;

	public Terrain() {
		this.listeBlocMinable = new ArrayList<Integer>();
		listeBlocMinable(); // on initialise qu'une seule fois
	}

	//-----------------------------------------------------------------------//
	/**
	 * Methode servant a choisir les blocs que l on peut casser sur la map 
	 */
	private void listeBlocMinable()  {
		this.listeBlocMinable.add(0);
		this.listeBlocMinable.add(1);
		this.listeBlocMinable.add(2);
		this.listeBlocMinable.add(3);
		//this.listeBlocMinable.add(4);
		//this.listeBlocMinable.add(5);
		//this.listeBlocMinable.add(6);
	}
	
	//Creer un nouvelle liste pour les bloc ou on peut poser des blocs par dessus les anciens
	//-----------------------------------------------------------------------//

	/**
	 * Tableau qui stocke la map  en int
	 */
	private final int [] terrain ={
			1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 3, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 2, 2, 2, 2,
            5, 5, 2, 2, 2, 5, 2, 2, 5, 2, 2, 2, 3, 2, 2, 2, 3, 2, 2, 2, 2, 3, 2, 2, 3, 2, 2, 2, 2, 3, 2, 2, 2, 3, 2, 2, 3, 2, 3, 2,
            5, 5, 5, 2, 5, 2, 3, 2, 5, 2, 2, 2, 2, 3, 3, 2, 2, 5, 5, 2, 2, 3, 3, 3, 2, 2, 2, 2, 2, 2, 5, 2, 2, 2, 2, 2, 3, 3, 2, 2,
            5, 5, 5, 4, 2, 2, 2, 2, 5, 5, 2, 5, 2, 2, 2, 5, 2, 2, 5, 2, 2, 2, 5, 5, 2, 5, 5, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 2, 2, 5, 5, 2, 2, 2, 2, 2, 2, 2, 2, 5, 2, 2, 2, 2, 5, 2, 2, 4, 2, 2,
            4, 2, 2, 2, 2, 4, 4, 2, 2, 2, 2, 2, 4, 2, 2, 2, 2, 2, 2, 4, 4, 2, 4, 4, 4, 2, 2, 2, 2, 2, 2, 4, 2, 2, 2, 2, 2, 2, 4, 2
	};

	/**
	 * change les tuiles en bloc choisit,
	 * si jamais on veut changer le bloc par lequel on shouaite remplacer les blocs casser allez dans la classe Parametre 
	 * @param numeroTuile que l'on veut changer dans le model
	 */
	public void changerTuiles (int numeroTuile, int blocAChanger) {
		if(listeBlocMinable.contains(terrain[numeroTuile]) && terrain[numeroTuile]!= blocAChanger )  {
			terrain[numeroTuile] = blocAChanger;
			System.out.println("\n �a fonctionne bloc changer");
		}
		//Juste pour des test 
		else if ( terrain[numeroTuile]== blocAChanger ){
			System.out.println("C'est le meme bloc on peut pas changer");
		}
	}

	//---------------------------------------------------------------------------------------//

	/**
	 * Methodes Basiques pour l affichage du terrain pour des test en console
	 * @param terrain que l on shouaite afficher
	 */
	public void affichertableau(Terrain terrain) {
		for (int i = 0 ; i<terrain.longueurterrain(); i++) {
			System.out.print(terrain.getTabTerrain()[i]);
			if(i % 40 == 0) {
				System.out.println();
			}
		}
	}
	
	//---------------------------------------------------------------------------------------//

	/**
	 * 
	 * @return un Terrain dans un tableau de int
	 */
	public  int[] getTabTerrain() {
		return terrain;
	}
	
	//---------------------------------------------------------------------------------------//

	/**
	 *  Methodes Basiques pour connaitre la longueur du terrain
	 * @return
	 */
	public int longueurterrain() {
		return terrain.length;
	}
}