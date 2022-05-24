package jeu.model;

import javafx.animation.TranslateTransition;
import javafx.beans.property.IntegerProperty;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import jeu.Parametre;
import jeu.controleur.KeyPressed;
import jeu.vue.HeroVue;

public class Heros extends Personnage{

	int direction, dirY = -7;
	boolean space = false;

	//changer le type terrain en type environnement
	public Heros(int x, int y, Terrain terrain) {
		super(x, y, 5, 6, terrain);


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
