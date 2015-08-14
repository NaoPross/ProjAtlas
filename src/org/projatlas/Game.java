package org.projatlas;

import GamePanel;

class Game {
	public static void main(String[] args) {
		// Game instance
		Game game = new Game();
		game.run();
	}
	
	public boolean isRunning;
	public boolean gameOver;

	public float 

	public Game() {	}

	public void run() {
		initVars();

		long sleepTime = 20;

		while (isRunning) {
			gameUpdate();
			//gameRender();

			Threading.thread.sleep(sleepTime);
		}
	}

	public void initVars() {
		isRunning = true;
		gameOver = false;
	}

	public void gameUpdate() {

	}
}
