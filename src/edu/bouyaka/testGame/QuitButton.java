package edu.bouyaka.testGame;

import edu.bouyaka.engine.concreted.Button;

public class QuitButton extends Button {
	public void leftClick(int x, int y) {
		engine.state = "quitted";
		engine.Interface(1).enable(false);
		System.exit(0);
	}
}
