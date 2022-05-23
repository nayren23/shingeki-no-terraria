package jeu.controleur;

import javafx.beans.value.ObservableValue;

public class ObservateurPv implements ChangeListener<Number> {

	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		System.out.println("« changement obs1");
		
	}

}
