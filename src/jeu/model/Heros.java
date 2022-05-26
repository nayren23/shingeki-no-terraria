package jeu.model;

import java.util.ArrayList;

import jeu.Parametre;
import jeu.controleur.MouseClick;
import jeu.controleur.MouseMoved;

public class Heros extends Personnage{

	int direction, dirY = -7;
	boolean space = false;
	private MouseMoved sourisCoordonnee;
	private Terrain terrain;
	//changer le type terrain en type environnement
	public Heros(int x, int y, Terrain terrain) {
		super(x, y, 5, 9, terrain);
	}

	@Override
	public void seDeplace(Parametre.DIRECTION d) {
		switch(d) {
		case LEFT:
			setDirection(-3);
			break;

		case RIGHT:
			setDirection(3);
			break;

		case SPACE:
			dirY = -5;
			break;

		default:
			System.out.println("Entrée incorrecte");
			break;
		}
	}

	public void move () {
		if(yProp.get() >= 149) {
			System.out.println(yProp);
			this.xProp.set(xProp.get() + direction);
			if(space == true) {
				this.yProp.set(yProp.get() + dirY);

			}



		}

	}

	public void gravite() {
		if(getY() <= 185)  {

			if(getDirection() == -3) {
				setX(getX() - 2);
				setY(getY() + 2);


			}
			else if (getDirection() == 3){
				setY(getY() + 2);
				setX(getX() + 2);


			}
			else {
				setY(getY() + 2);


			}

		}
	}


	private int clamp (int val1 , int min, int max) {  // Pour borner un chiffre entre 2 valeurs pour pas que l'image s'enleve
		int valeurClamp = val1;

		if(valeurClamp<min) {
			valeurClamp = min;
		}
		else if(valeurClamp>max) {
			valeurClamp= max;
		}
		return valeurClamp;
	}

	@Override
	public void perdrePv() { // en option mettre le nb de pv perdu en param�tre
		int pv = clamp(this.PvProperty().getValue()-1, 0, 9);
		this.PvProperty().setValue(pv);  // -1 pour le heros 
	}

	@Override
	public void augmenterPv() { // en option mettre le nb de pv augmenter en parametre
		int pv = clamp(this.PvProperty().getValue()+1, 0, 9);	
		this.PvProperty().setValue(pv);  // -1 pour le heros 
	}

	public void miner (int numeroTuilesCasser, Terrain terrain) {  // ensuite rajouter l'objet miner dans l'inventaire 
		System.out.println("minage" + numeroTuilesCasser);
		
		//terrain.affichertableau(terrain);  //affichage du tableau pour les test
		terrain.changerTuiles(numeroTuilesCasser,Parametre.changementDuBlocCasser); //changer le 1 en bloc choisit
		//System.out.println("C'est cassee Yes");			
		//terrain.affichertableau(terrain);  //affichage du tableau pour les test
	}

		public void construire(int numeroTuilesCasser, Terrain terrain) {
			System.out.println("minage" + numeroTuilesCasser);
			//terrain.affichertableau(terrain);  //affichage du tableau pour les test

			terrain.changerTuiles(numeroTuilesCasser, Parametre.changementDuBlocConstruit); //changer le 1 en bloc choisit
		//	System.out.println("C'est construit Yes");			

			terrain.affichertableau(terrain);

		}
	//	public void construire(Terrain terrain) {
	//		
	//	}

	//	public boolean estMort(int pv) { // a finir
	//			boolean estMort = false;
	//			
	//			if(pv==0) {
	//				estMort =true;
	//			}
	//			return estMort;
	//			
	//}



	public int getDirection() {
		return this.direction;
	}

	public int setDirection(int i) {
		return this.direction = i;
	}

	public int getDirY() {
		return dirY;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
	}

	public boolean isSpace() {
		return space;
	}

	public void setSpace(boolean space) {
		this.space = space;
	}
}





