package org.projatlas;

import org.projatlas.GamePanel;

class Game {
	public static void main(String[] args) {
		// Game instance
		Game game = new Game();
		game.run();
	}
	
	public boolean isRunning;
	public boolean gameOver;
	public Window frame;
	public GamePanel gamepanel;

	public Game() {	}

	public void run() {
		
		initVars();

		long sleepTime = 20;

		while (isRunning) {
			gameUpdate();
			//gameRender();

			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) { 
				e.printStackTrace(); 
			}
		}
	}

	public void initVars() {
		
		isRunning = true;
		gameOver = false;
	}

	public void gameUpdate() {

	}
}
