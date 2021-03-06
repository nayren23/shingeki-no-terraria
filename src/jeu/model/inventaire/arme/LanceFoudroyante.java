package jeu.model.inventaire.arme;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.Parametre;
import jeu.model.Environnement;

public class LanceFoudroyante extends Arme{

	private IntegerProperty coordonneeX;
	private IntegerProperty coordonneeY;
	private int direction ,dirY;
	private Environnement env;
	private boolean droite , gauche;
	private IntegerProperty pv;
	private boolean lanceAvance;

	public LanceFoudroyante(int x, int y , Environnement env) {
		super(2,"lance",100,1);
		this.coordonneeX = new SimpleIntegerProperty(x);
		this.coordonneeY = new SimpleIntegerProperty(y);
		this.direction= 0;
		this.env = env;
		this.dirY = 0;
		this.pv = new SimpleIntegerProperty(1);
		this.lanceAvance = false;

		/**
		 * listener qui ecoute les coordonneer du joueur pour mettre les bonne coordonner a la lance en X
		 */
		env.getEren().xProperty().addListener((obs,old,newP) -> {
			this.setX((int)newP);

		}
				);

		/**
		 * listener qui ecoute les coordonneer du joueur pour mettre les bonne coordonner a la lance en Y
		 */
		env.getEren().yProperty().addListener((obs,old,newP) -> {
			this.setY((int)old);

		}
				);

	}	

	public void move () {
		this.coordonneeX.set(coordonneeX.get() + direction);
		this.coordonneeY.set(coordonneeY.get() + dirY);
	}


	public void seDeplace(  ) {


		if( env.getEren().getDirectionActuelle() == 3  ) { // on le fait allez jusqu a gauche puis
			droite = true;
			gauche =false;
		}

		else if(env.getEren().getDirectionActuelle()  == -3) { // on le fait allez jusqu a gauche puis
			droite = false;
			gauche =true;
		}

		if(droite) {
			setDirection(4);
			Parametre.lanceFoudroyante.playSound();

		}

		else if (gauche) {
			setDirection(-4);
			Parametre.lanceFoudroyante.playSound();

		}

	}

	public void attaque() {
		int i=0;
		while (i<env.getListeTitans().size()) {
			if(	Parametre.rangeTitan(getX(),getY(), env.getListeTitans().get(i).getX(), env.getListeTitans().get(i).getY(), 10,10)) {
				env.getListeTitans().get(i).perdrePv(this);
				pv.set(pv.getValue()-1);
			}
			i++;
		}
	}

	
	public boolean estMort () {
		boolean mort = false;
		if (this.pv.getValue()<=0) {
			mort = true;
			env.getEren().getInventaireHeros().detruireObjet(this);
		}

		else {
			mort =false;
			action();
		}
		return mort;
	}
	
	
	public void action () {
		seDeplace();
		move();
		attaque();
		
	}




	////////////////////Getters////////////////////////////////

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
	
	public Environnement getEnv() {
		return env;
	}

	public IntegerProperty getPv() {
		return pv;
	}
	
	public int getDirY() {
		return dirY;
	}
	
	public boolean isLanceAvance() {
		return lanceAvance;
	}

	////////////////////Setters////////////////////////////////

	
	public void setLanceAvance(boolean lanceAvance) {
		this.lanceAvance = lanceAvance;
	}

	public final void setX(int d) {
		this.coordonneeX.setValue(d);
	}

	public final void setY(int d) {
		this.coordonneeY.setValue(d);
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setPv(IntegerProperty pv) {
		this.pv = pv;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
	}

}



