package edu.bouyaka.testGame;

import edu.bouyaka.engine.Concrete;
import edu.bouyaka.engine.concreted.Player;

public class Humain extends Player {
	public Humain() {
		super();
		type = "humain";
	}

	public void collideTo(Concrete E) {
		if (E.getType() == "ombre") {

			if (pos.getY() - E.pos.getY() > 0 && pos.getX() - E.pos.getX() < 0) {
				moveLeft(2);
				moveDown(2);

			} else if (pos.getY() - E.pos.getY() > 0
					&& pos.getX() - E.pos.getX() > 0) {
				moveRight(2);
				moveDown(2);

			} else if (pos.getY() - E.pos.getY() < 0
					&& pos.getX() - E.pos.getX() < 0) {
				moveLeft(2);
				moveUp(2);

			} else if (pos.getY() - E.pos.getY() < 0
					&& pos.getX() - E.pos.getX() > 0) {
				moveRight(2);
				moveUp(2);

			}
		}
	}
}
