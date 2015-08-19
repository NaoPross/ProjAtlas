package raffa.test;

import raffa.atlasengine.*;

public class Game extends Window {
	
	/*
	 * A try of the instance of the components
	 * in the main panel
	 */
	
	Sprite sfondo, atlas, ghosteon;
	Elettrone elettrone;
	Protone protone;
	
	public static void main(String[] args) {
		
		Game frame = new Game();
	}
	
	public Game() {
		
		sfondo = new Sprite("C:\\Users\\Nicola\\Desktop\\Vogelberg.png");
		
		elettrone = new Elettrone();
		
		protone = new Protone();
		
		
		atlas = new Sprite("C:\\Users\\Nicola\\Desktop\\Atlas2.png");
		atlas.setBounds(40, 30, 300, 600);
		atlas.zLevel = 1;
		
		
		ghosteon = new Sprite("C:\\Users\\Nicola\\Desktop\\Ghosteon.png");
		ghosteon.setBounds(260, 200, 300, 250);
		ghosteon.zLevel = 2;
		
		
		panel.setBackground(sfondo);
		panel.add(elettrone);
		panel.add(protone);
		panel.add(atlas);
		panel.add(ghosteon);
		
		super.isRunning = true;
		super.setVisible(isRunning);
		
		super.run();
	}
	
	@Override
	public void gameLoop() {
		
		elettrone.setLocation(elettrone.x + 3, elettrone.y);
		protone.setLocation(protone.x - 3, protone.y);
		atlas.rotate(2, atlas.x + 150, atlas.y + 300);
		//System.out.println(elettrone.x + "  " + elettrone.y);
	}

}
