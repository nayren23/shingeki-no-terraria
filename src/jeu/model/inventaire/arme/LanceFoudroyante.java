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
	private int direction ,dirY;
	private Environnement env;
	private boolean droite , gauche;
	private int pv;
	public LanceFoudroyante(int x, int y , Environnement env) {
		super(1,"lance");
		this.coordonneeX = new SimpleIntegerProperty(x);
		this.coordonneeY = new SimpleIntegerProperty(y);
		this.direction= 0;
		this.env = env;
		this.dirY = 0;
		this.pv = 1;
	}	

	public void move () {
		this.coordonneeX.set(coordonneeX.get() + direction);
		this.coordonneeY.set(coordonneeY.get() + dirY);
	}


	public void seDeplace() {

		//
		//		System.out.println("erenn direction " + env.getEren().getDirection());
		//		System.out.println("erenn droite" +droite);
		//		System.out.println("erenn gauceh" +gauche);

		if( env.getEren().getDirection() == 3 ) { // on le fait allez jusqu a gauche puis
			droite = true;
			gauche =false;
		}

		else if(env.getEren().getDirection()  == -3 ) { // on le fait allez jusqu a gauche puis
			droite = false;
			gauche =true;
		}

		if(droite) {
			setDirection(1);
		}

		else if (gauche) {
			setDirection(-1);
		}
		attaque();
		move();


	}

	public void attaque() 	{

		for(int i = 0 ; i< env.getListeTitans().size();i++) {
			if(getX() >= env.getListeTitans().get(i).getX() && verifMort() ==false) {
				System.out.println("\n passage de la mortttt");
				System.out.println("affichage degatss" + this.getDegats());
				env.getListeTitans().get(i).perdrePv(this);
				pv =0;
				//				System.out.println(	"Affichage vie titans "+env.getListeTitans().get(i).PvProperty().getValue());
			}

		}
	}

	public boolean verifMort () {
		boolean mort = false;
		if(pv <= 0) {
			mort =true;
		}
		else {
			mort =false;
			action();
		}
		return mort;

	}
	public void action () {
		//		System.out.println("\n je me deplace");
		seDeplace();

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



