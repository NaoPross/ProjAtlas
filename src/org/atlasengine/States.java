package org.atlasengine;

/***
 * @author NaoPross,
 * From Oracle Docs:
 * An enum type is a special data type that enables for a variable to be a set of predefined constants.
 * 
 * This enum contains the GameStates
 */

public enum States {
	// Game States, game is running, paused, ... 
	GAME, PAUSE, MENU,
	// Window States, which panel to show on the JFrame
	GAMEPANEL, MENUPANEL
}
