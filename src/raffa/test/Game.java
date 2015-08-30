package raffa.test;

import java.awt.Color;

import raffa.atlasengine.*;

public class Game extends MainPanel {
	
	/*
	 * A try of the instance of the components
	 * in the main panel
	 */
	
	Sprite sfondo, atlas, ghosteon;
	Elettrone elettrone;
	Protone protone;
	boolean instance = true;
	Audio audio;
	
	public static void main(String[] args) {
		
		Game frame = new Game();
	}
	
	public Game() {
		
		super("Test grafico", 100, 50, 1000, 650);
		sfondo = new Sprite("./Vogelberg.png");
		
		audio = new Audio();
		audio.load("./L'addio di Nancy.wav");
		audio.play(0, true);
		
		elettrone = new Elettrone();
		
		protone = new Protone();
		protone.setBorder(Color.BLACK);
		
		
		atlas = new Sprite("./Atlas2.png");
		atlas.setBounds(40, 30, 300, 600);
		atlas.zLevel = 1;
		
		
		ghosteon = new Sprite("./Ghosteon.png");
		ghosteon.setBounds(260, 200, 300, 250);
		ghosteon.zLevel = 2;
		
		
		this.setBackground(sfondo);
		this.add(elettrone);
		this.add(protone);
		this.add(atlas);
		this.add(ghosteon);
		
		super.setVisible(true);
		
		super.run();
	}
	
	@Override
	public void gameLoop() {
		
		elettrone.setLocation(elettrone.x + 3, elettrone.y);
		protone.setLocation(protone.x - 3, protone.y);
		atlas.rotate(1, atlas.x + 150, atlas.y + 300);
		
		if (instance) {
			int phi = ghosteon.countRot / 10;
			if (ghosteon.countRot > 250) {
				remove(ghosteon);
				instance = false;
			}
			ghosteon.rotate(phi, ghosteon.x + 150, ghosteon.y + 150);
			ghosteon.setSize((int)(ghosteon.width * 0.99), (int)(ghosteon.height * 0.99));
			ghosteon.setLocation(ghosteon.x + 2, ghosteon.y - 1);
		}
		//System.out.println(elettrone.x + "  " + elettrone.y);
	}

}
