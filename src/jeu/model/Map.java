package jeu.model;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;

public class Map {

	private int[] terrain;
	private ArrayList<Personnage> personnages;
	
	public Map (int[] terrain,ArrayList<Personnage> personnages) {
		this.terrain = terrain;
		this.personnages = personnages;
	}
	
}
