package edu.bouyaka.testGame;

import edu.bouyaka.engine.concreted.SpriteButton;

public class PlayButton extends SpriteButton {
	public void leftClick(int x, int y) {
		engine.state = "Play";
		engine.Interface(1).enable(false);
		engine.Interface(1).setVisible(false);
	}
}
