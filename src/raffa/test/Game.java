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
		frame.setVisible(true);
	}
	
	public Game() {
		
		sfondo = new Sprite("C:\\Users\\Nicola\\Documents\\Documenti_Raffa\\Immagini_montecarlo\\Metodo Montecarlo_1.png");
		
		elettrone = new Elettrone();
		
		protone = new Protone();
		
		panel.setBackGround(sfondo);
		panel.add(elettrone);
		panel.add(protone);
		
		super.run();
	}
	
	@Override
	public void winMain() {
		
		elettrone.setLocation(elettrone.x + 1, elettrone.y - 1);
		System.out.println(elettrone.x + "" + elettrone.y);
	}

}
