package jeu;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import jeu.model.Environnement;
import jeu.model.Heros;
import jeu.model.Terrain;
import jeu.model.inventaire.Inventaire;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.arme.Epee;
import jeu.model.inventaire.outil.Hache;
import jeu.model.inventaire.ressource.Bois;
import jeu.model.inventaire.ressource.Charbon;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Pain;
import jeu.model.inventaire.ressource.Terre;

public class SntTest {

    private Terrain terrain;
    private Environnement env;
    private Heros eren = new Heros(terrain, env);

    @Test 
    public final void perdreVieTest () {
        this.eren.perdrePv();
        assertEquals(eren.getPv(), 8, "test perdre un pv");
        this.eren.perdrePv();
        assertEquals(eren.getPv(), 7);
        this.eren.perdrePv();
        assertEquals(eren.getPv(), 6);
        this.eren.setPv(0);
        this.eren.perdrePv();
        assertEquals(eren.getPv(), 0, "test si on peut perdre pv malgre pv a 0");
        
    }

    @Test
    public  final void gagnerVieTest() {
        Pain pain = new Pain();
        Inventaire inv = new Inventaire(env);
        inv.ajouterDansInventaire(pain);
        
        this.eren.augmenterPv(pain);
        
        assertEquals(eren.getPv(), 9, "test vie full donc gagne pas pv");
        
        this.eren.setPv(1);
        this.eren.setInventaireHeros(inv);

        this.eren.augmenterPv(pain);
        assertEquals(eren.getPv(), 2,"test possible gagner vie");
    }

//    @Test
//    public final void changementTuileTest() {
//        this.terrain.changerTuiles(3, 200);
//        assertEquals(1, 3);
//    }
    
    @Test
  public final void testAjouterDansInventaire () {
    	Epee e = new Epee();
    	Hache hache = new Hache(env);
    	
    	ArrayList<Objet> l = new ArrayList<>();
    	l.add(hache);
    	l.add(e);
    	
    	Inventaire inv = new Inventaire(env);
    	
    	inv.ajouterDansInventaire(hache);
    	inv.ajouterDansInventaire(e);
    	
    	assertEquals(inv.getInventaire(), l, "test quand l'objet est ajoute");
    	
    }
  
	//Pour que ca marche il faut mettre en commentaire les deux premieres lignes de la fonction detruireObjet
	//car on ne verifie que si l'objet envoye en parametre se supprime ou non
    
  /*  @Test
    public final void testDetruireObjet() {
    	Epee e = new Epee();
    	Hache hache = new Hache(env);
    	
    	ArrayList<Objet> l = new ArrayList<>();
    	l.add(hache);
    	l.add(e);
    	l.remove(1);
    	
    	Inventaire inv = new Inventaire(env);
    	
    	inv.ajouterDansInventaire(hache);
    	inv.ajouterDansInventaire(e);
    	inv.detruireObjet(e);
    	
    	assertEquals(inv.getInventaire(), l);

    }
    */
    
    @Test
    public final void testDetruireRessource() {
    	Inventaire inv = new Inventaire(env);
    	Terre terre = new Terre ();
    	Bois bois = new Bois();
    	inv.ajouterDansInventaire(bois);
    	inv.ajouterDansInventaire(terre);
    	
    	this.eren.setInventaireHeros(inv);
    	this.eren.getInventaireHeros().detruireRessource(bois);
    	
    	Inventaire invApresDestruction = new Inventaire(env);
    	invApresDestruction.ajouterDansInventaire(terre);
    	System.out.println(this.eren.getInventaireHeros().getInventaire());

    	assertEquals(this.eren.getInventaireHeros().getInventaire(), invApresDestruction.getInventaire(), "test destruction ressource");    	
    }
    
    @Test
    public final void testConstructionErwin() {
    	Bois bois = new Bois();
    	Fer fer = new Fer();
    	bois.incrementerRessource();
    	fer.setNbRessource(10);
    	
    	Inventaire inv = new Inventaire(env);
    	inv.ajouterDansInventaire(bois);
    	inv.ajouterDansInventaire(fer);
    	
    	Objet o = new Epee();
    	
    	this.eren.setInventaireHeros(inv);
    	
    	assertTrue("test quand il y a les ressources necessaires", this.eren.getInventaireHeros().constructionErwin(o, bois, fer));
    	
    	Inventaire invRessourcesManquantes = new Inventaire(env);
    	Bois bois2 = new Bois();
    	Fer fer2 = new Fer();
    	invRessourcesManquantes.ajouterDansInventaire(bois2);
    	invRessourcesManquantes.ajouterDansInventaire(fer2);
    	
    	this.eren.setInventaireHeros(invRessourcesManquantes);
    	
    	assertFalse("test quand il n'y a pas assez de ressources", this.eren.getInventaireHeros().constructionErwin(o, bois2, fer2));
    }
    
    @Test
    public final void testInteractionArmin() {
    	Bois bois = new Bois();
    	Charbon charbon = new Charbon();
    	bois.setNbRessource(20);
    	charbon.setNbRessource(10);
    	
    	Inventaire inv = new Inventaire(env);
    	inv.getInventaire().add(charbon);
    	inv.getInventaire().add(bois);
    	
    	this.eren.setInventaireHeros(inv);
    	
    	
    	inv.interactionArmin(charbon, bois);
    	
    	assertEquals(inv.interactionArmin(charbon, bois), false, "test achat bateau");
    }
  
  
  
}