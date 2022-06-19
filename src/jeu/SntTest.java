package jeu;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import jeu.model.Environnement;
import jeu.model.Heros;
import jeu.model.Terrain;
import jeu.model.inventaire.ressource.Pain;

public class SntTest {

    private Terrain terrain;
    private Environnement env;
    private Heros eren = new Heros(0, 0, terrain, env);

    @Test 
    public final void perdreVieTest () {
        this.eren.perdrePv();
        assertEquals(eren.getPv(), 8);
        this.eren.perdrePv();
        assertEquals(eren.getPv(), 7);
        this.eren.perdrePv();
        assertEquals(eren.getPv(), 6);
    }

    @Test
    public  final void gagnerVieTest() {
        this.eren.setPv(1);
        System.out.println(   this.eren.getPv());
        Pain pain = new Pain();

        this.eren.augmenterPv(pain);
        System.out.println(   this.eren.getPv());

        assertEquals(eren.getPv(), 1);
        this.eren.augmenterPv(pain);
        assertEquals(eren.getPv(), 3);
        this.eren.augmenterPv(pain);
        assertEquals(eren.getPv(), 4);
    }

//    @Test
//    public final void changementTuileTest() {
//        this.terrain.changerTuiles(3, 200);
//        assertEquals(1, 3);
//    }
}