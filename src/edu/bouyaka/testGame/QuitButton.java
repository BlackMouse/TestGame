package edu.bouyaka.testGame;

import edu.bouyaka.engine.concreted.SpriteButton;

public class QuitButton extends SpriteButton {
	public void leftClick(int x, int y) {
		engine.state = "Quit";
		System.exit(0);
	}

}
