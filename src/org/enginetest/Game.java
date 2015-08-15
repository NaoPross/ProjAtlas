package org.enginetest;

import java.awt.Dimension;

import org.atlasengine.GamePanel;
import org.atlasengine.MenuPanel;
import org.atlasengine.States;
import org.atlasengine.Window;

public class Game {
	
	public static void main(String[] args) {	
		Game g = new Game();
		g.start();
	}
	
	private int WIDTH = 800;
	private int HEIGHT = 600;
	
	private Window frame;
	private GamePanel gamePanel;
	private MenuPanel menuPanel;
	
	// This variable is used to determine which Panel to show
	private States gameState;
	private boolean gameOver, isRunning;
	
	public Game() {
		// Create a frame and some panels
		frame = new Window("Atlas Project - Game Engine Test", new Dimension(WIDTH, HEIGHT));
		menuPanel = new MenuPanel();
		gamePanel = new GamePanel();
		
		// Add the panels to the CardLayout
		frame.addMenuPanel(menuPanel);
		frame.addGamePanel(gamePanel);
		
		// Show the window
		frame.showWindow();
		// Start the game
		this.isRunning = true;
		this.gameOver = false;
		this.gameState = States.MENU;
	}
	
	public void start() {
		// Program's mainloop
		while (this.isRunning) {
			
			if (this.gameState == States.MENU) {
				// Menu Screen
				frame.showScreen(States.GAMEPANEL);		
			} else if (this.gameState == States.GAME) {
				
				long sleepTime;
				sleepTime = 10;
				
				// Game's mainloop
				while (this.gameOver) {
					
					try {
						Thread.sleep(sleepTime);				
					} catch (InterruptedException e) {
						e.printStackTrace(); 
					}
				}
			}
		}
	}
}

