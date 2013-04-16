package edu.bouyaka.testGame;

import edu.bouyaka.engine.concreted.Assembly;
import edu.bouyaka.engine.abstracted.Vector;
import edu.bouyaka.engine.concreted.Item;

public class Batiment extends Assembly {

	public Batiment(int n) {
		super(n);

		for (int id = 0; id < n; id++) {
			items[id] = new Item();
			itemsPos[id] = new Vector();
		}

		// Géneration de murs
		for (int id = 0; id < 5; id++) {
			itemsPos[id].setX(id * 30);
			itemsPos[id].setY(0);
			items[id].setSpriteId(5);
		}
		for (int id = 5; id < 11; id++) {
			itemsPos[id].setX((id - 5) * 30);
			itemsPos[id].setY(5 * 30);
			items[id].setSpriteId(5);
		}
		for (int id = 11; id < 16; id++) {
			itemsPos[id].setX(5 * 30);
			itemsPos[id].setY((id - 11) * 30);
			items[id].setSpriteId(5);
		}
		for (int id = 16; id < 21; id++) {
			itemsPos[id].setX(0);
			itemsPos[id].setY((id - 16) * 30);
			items[id].setSpriteId(5);
		}

	}

	public void show() {
		for (int id = 0; id < items.length; id++) {
			items[id].setPos((int) pos.getX() + itemsPos[id].getX(),
					(int) pos.getY() + itemsPos[id].getY());

			items[id].show();
		}
	}

	public void moveDownRight(int n) {
		boolean edgeTouch = false;
		for (int id = 0; id < items.length && !edgeTouch; id++) {
			items[id].moveDownRight(10);
			edgeTouch = items[id].isTouchingEdge();
		}
	}

}
