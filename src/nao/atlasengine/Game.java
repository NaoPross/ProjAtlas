package nao.atlasengine;

import nao.atlasengine.*;

import java.util.*;

public class Game {
	// Static methods and variables
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	// Main method
	public static void main(String[] args) {
		Game game = new Game();
		Window frame = new Window("AtlasEngine Demo - Nao", new Dimension(WIDTH, HEIGHT));
		game.start();
	}
	
	// Volatile booleans, to be able to use them in the GameCanvas
	public volatile boolean isRunning, gameOver;
	public STATE gameState;
	
	public enum STATE {
		MENU, GAME, PAUSE	
	}
	
	// Game instanciation
	public Game() {
		this.isRunning = true;
	}
	
	// Game start
	public void start() {
		if (gameState == STATE.MENU) {
			// Unimplemented
		} else if (gameState == STATE.GAME) {
			long sleepTime = System.nanoTime();
			
			// Game's MainLoop
			while (this.gameOver) {
				Thread.sleep(sleepTime);
			}
		}	
	}
}
