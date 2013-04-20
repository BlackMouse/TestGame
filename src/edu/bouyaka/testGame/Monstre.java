package edu.bouyaka.testGame;

import edu.bouyaka.engine.Concrete;
import edu.bouyaka.engine.concreted.Player;

public class Monstre extends Player {
	public void collideTo(Concrete E) {
		if(E.getType()=="Ombre");
		else super.collideTo(E);
	
	}

}
