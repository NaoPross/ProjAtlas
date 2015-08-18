package raffa.test;

import raffa.atlasengine.*;

public class Game extends Window {
	
	Sprite sfondo;
	Elettrone elettrone;
	Protone protone;
	
	public static void main(String[] args) {
		
		Window frame = new Window();
		frame.setVisible(true);
	}
	
	public Game() {
		
		sfondo = new Sprite("C:\\Users\\Nicola\\Documents\\Documenti_Raffa\\Immagini_montecarlo\\Metodo_Montecarlo_1");
		
		elettrone = new Elettrone();
		
		protone = new Protone();
		
		panel.setBackGround(sfondo);
		panel.add(elettrone);
		panel.add(protone);
		
		run();
	}
	
	@Override
	public void winMain() {
		
		elettrone.setLocation(elettrone.x + 1, elettrone.y - 1);
		System.out.println(elettrone.x + "" + elettrone.y);
	}

}
