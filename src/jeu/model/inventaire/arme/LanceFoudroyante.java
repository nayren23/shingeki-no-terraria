package jeu.model.inventaire.arme;

import java.util.Iterator;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.Personnage;

public class LanceFoudroyante extends Arme{

	private IntegerProperty coordonneeX;
	private IntegerProperty coordonneeY;
	private int direction;
	private Environnement env;

	public LanceFoudroyante(int x, int y , Environnement env) {
		super(1,"lance");
		this.coordonneeX = new SimpleIntegerProperty(x);
		this.coordonneeY = new SimpleIntegerProperty(y);
		this.direction=0;
		this.env = env;

	}	

	public void seDeplace() {



			if( env.getEren().getDirection() == -3 ) { // on le fait allez jusqu a gauche puis
				setDirection(0);  //droite
			}

			else if( env.getEren().getDirection() == 3 ) { // on le fait allez jusqu a gauche puis
				setDirection(2);  //gauche
			}

			if(getDirection() == 0) {
				//			setX(getX()+2);
			}

			else
				setX(getX()-2);
		}
	
	public void attaque() 	{

		for(int i = 0 ; i< env.getListeTitans().size();i++) {
			if(coordonneeX.getValue() == env.getListeTitans().get(i).getX() ) {
				env.getListeTitans().get(i).setPv(coordonneeX);
			}

		}
	}
	public void action () {
//		this.move();
		System.out.println("\n je me deplace");
		seDeplace();
		attaque();

		//		if(!this.collisionDuBas(this.getX(), this.getY())){
		//			if(this.getDirY() < 10) {
		//				this.additionnerDirY(1);
		//			}
		//		}
	}


	public IntegerProperty getCoordonneeX() {
		return coordonneeX;
	}

	
	public int getX() {
		return coordonneeX.getValue();
	}
	
	public int getY() {
		return coordonneeY.getValue();
	}

	public IntegerProperty getCoordonneeY() {
		return coordonneeY;
	}


	public int getDirection() {
		return direction;
	}

	

	public final void setX(int d) {
		this.coordonneeX.setValue(d);
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Environnement getEnv() {
		return env;
	}



}



