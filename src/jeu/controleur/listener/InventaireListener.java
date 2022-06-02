package jeu.controleur.listener;

import javafx.collections.ListChangeListener;
import jeu.model.inventaire.Inventaire;
import jeu.model.inventaire.Objet;
import jeu.vue.inventaire.InventaireVue;

public class InventaireListener {

	public InventaireListener(InventaireVue invVue, Inventaire inv) {
		inv.getInventaire().addListener(new ListChangeListener<Objet>() {
			@Override
			public void onChanged(Change<? extends Objet> c) {
				while (c.next()) 
					if (c.wasAdded() || c.wasRemoved() || c.wasUpdated()) 
						invVue.mettreAJourInventaire();
			}
		});
	}

}