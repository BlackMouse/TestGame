package edu.bouyaka.testGame;

import edu.bouyaka.engine.concreted.Button;

public class PlayButton extends Button {
	public void leftClick(int x, int y) {
		engine.state = "Play";
		engine.Interface(1).enable(false);
		engine.Interface(1).setVisible(false);
	}


}
