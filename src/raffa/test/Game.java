package raffa.test;

import raffa.atlasengine.*;

public class Game extends Window {
	
	/*
	 * A try of the instance of the components
	 * in the main panel
	 */
	
	Sprite sfondo;
	Elettrone elettrone;
	Protone protone;
	
	public static void main(String[] args) {
		
		Game frame = new Game();
	}
	
	public Game() {
		
		sfondo = new Sprite("C:\\Users\\Nicola\\Documents\\Documenti_Raffa\\Immagini_montecarlo\\Metodo Montecarlo_1.png");
		
		elettrone = new Elettrone();
		
		protone = new Protone();
		
		panel.setBackGround(sfondo);
		panel.add(elettrone);
		panel.add(protone);
		
		super.isRunning = true;
		super.setVisible(isRunning);
		
		super.run();
	}
	
	@Override
	public void gameLoop() {
		
		elettrone.setLocation(elettrone.x + 3, elettrone.y);
		protone.setLocation(protone.x - 3, protone.y);
		//System.out.println(elettrone.x + "  " + elettrone.y);
	}

}
