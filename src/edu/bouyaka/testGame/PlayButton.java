package edu.bouyaka.testGame;

import edu.bouyaka.engine.concreted.Button;

public class PlayButton extends Button {
	public void leftClick(int x, int y) {
		engine.state = "play";
		engine.Interface(1).enable(false);
	}


}
