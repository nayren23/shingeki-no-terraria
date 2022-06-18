package jeu.model.inventaire.arme;

import java.util.Iterator;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.Collisions;
import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.Personnage;

public class LanceFoudroyante extends Arme{

	private IntegerProperty coordonneeX;
	private IntegerProperty coordonneeY;
	private int direction ,dirY;
	private Environnement env;
	private boolean droite , gauche;
	private IntegerProperty pv;
	
	private boolean lanceAvance;
	
	public LanceFoudroyante(int x, int y , Environnement env) {
		super(2,"lance");
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

		
//				System.out.println("erenn direction " + env.getEren().getDirection());
//				System.out.println("erenn droite" +droite);
//				System.out.println("erenn gauceh" +gauche);

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
//		System.out.println("Direction eren" +env.getEren().getDirection());

	}

	public void attaque() {
		int i=0;
		while (i<env.getListeTitans().size()) {
			if(	Parametre.rangeTitan(getX(),getY(), env.getListeTitans().get(i).getX(), env.getListeTitans().get(i).getY(), 10,60)) {
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
			collisions();
	}


	
	//////////////////////////////////////////////////////
	
	
	public  void collisions () {
		int x = this.coordonneeX.get();
		int y = this.coordonneeX.get();
		
		if (collisionDeDroite(x,y) == true || collisionDeGauche(x,y) == true) {
//			pv.set(pv.getValue()-1);
		}
		collisionDuHaut(x,y);
		collisionDuBas(x,y);
	}
	
	//permet de verifier la collision du haut avec le personnage en prenant le x du personnage et le y
		//verification avec la collision sur le bloc du haut soit y - la difference avec le bloc du haut et met donc la direction du Y a 0 si il y a collision
		public void collisionDuHaut (int x,int y) {
			if (Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x + 17, y - Parametre.diffBlocDessu ), env) || Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x + 17, y - Parametre.diffBlocDessu),env)) {
				this.setDirY(0);
			}
		}


		//permet de verifier la collision du bas avec le personnage en prenant le x du personnage et le y
		//Verification avec de pixel en y  avec ici y et y + 1
		public boolean collisionDuBas (int x,int y) {
			if (Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x + 12 ,y+1),env) || Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x + 12, y+1),env)) {
				if (Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x + 12 ,y),env) || Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x + 12, y),env)) {
					this.coordonneeY.set(this.coordonneeY.get() - Parametre.forceGravite);

				}
				if (this.getDirY() > 0  || this.getDirY()==-1) {
					this.setDirY(0);
					
				}
				return true;
			}
			else {
				return false;
			}
		}


		public boolean collisionDeDroite (int x,int y) {
				boolean bloque = false;
			if (Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x + Parametre.largeurPersonnage, y - Parametre.hauteurPersonnage),env) || Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x + Parametre.largeurPersonnage, y - 1),env)) {
				this.coordonneeX.set(x - this.direction);
				bloque = true;
			}
			if (Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x + Parametre.largeurPersonnage, y - Parametre.hauteurPersonnage),env) || Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x +  Parametre.largeurPersonnage, y - 1),env)) {
				this.coordonneeX.set(this.coordonneeX.get() - 1);
				bloque= true;

			}
			return bloque;
			
		}


		public boolean collisionDeGauche (int x,int y) {
			boolean bloque = false;

			if (Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x + 9, y - Parametre.hauteurPersonnage),env) || Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x + 9, y -1),env)) {
				this.coordonneeX.set(x - this.direction);
				bloque = true;
			}
			if (Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x + 9, y - Parametre.hauteurPersonnage),env) || Collisions.verificationDeCollisions(Collisions.coordoonneTuile(x + 9, y-1),env)) {
				this.coordonneeX.set(this.coordonneeX.get() + 1);
				bloque= true;
			}
			return bloque;
		}

	
	
	
	
	////////////////////////////////////////////////////
	
	
	public boolean isLanceAvance() {
		return lanceAvance;
	}

	public void setLanceAvance(boolean lanceAvance) {
		this.lanceAvance = lanceAvance;
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
	
	public final void setY(int d) {
		this.coordonneeY.setValue(d);
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Environnement getEnv() {
		return env;
	}

	public IntegerProperty getPv() {
		return pv;
	}

	public void setPv(IntegerProperty pv) {
		this.pv = pv;
	}

	public int getDirY() {
		return dirY;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
	}




}



