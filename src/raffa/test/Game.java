package raffa.test;

import java.awt.Color;

import raffa.atlasengine.*;
import raffa.atlasengine.frame.MainPanel;
import raffa.atlasengine.sprite.Sprite;
import raffa.atlasengine.support.Audio;
import raffa.atlasengine.support.Data;

public class Game extends MainPanel {
	
	/*
	 * A try of the instance of the components
	 * in the main panel
	 */
	
	Sprite sfondo, atlas, ghosteon, lab;
	Elettrone elettrone;
	Protone protone;
	boolean instance = true;
	Audio audio;
	
	public static final Color lab_rgb = new Color(20, 40, 80);
	
	public static void main(String[] args) {
		
		Game frame = new Game();
	}
	
	public Game() {
		
		super("Test grafico", 100, 50, 1000, 650);
		sfondo = new Sprite(Sprite.fromImage("./Vogelberg.png"));
		
		lab = new Sprite(30, 20, 350, 80);
		
		audio = new Audio("./L'addio di Nancy.wav", true);
		audio.setVolume(Audio.VOLUME_MEDIUM);
		
		elettrone = new Elettrone();
		
		protone = new Protone();
		
		atlas = new Sprite(Sprite.fromImage("./Atlas2.png"), 40, 30, 300, 600);
		atlas.setZLevel(1);
		
		
		ghosteon = new Sprite(Sprite.fromImage("./Ghosteon.png"), 260, 200, 300, 250);
		ghosteon.setZLevel(2);
		
		
		this.setBackground(sfondo);
		this.add(lab);
		this.add(elettrone);
		this.add(protone);
		this.add(atlas);
		this.add(ghosteon);
		
		super.setVisible(true);
		
		super.run();
	}
	
	@Override
	public void gameLoop() {
		
		lab.label("Atlas engine try  " + Data.getTime()[0] + "  " + Data.getTime()[1] + "  " + Data.getTime()[2] + "  " + Data.getTime()[3],
				20, 40, Sprite.DEFAULT_LABEL_FONT.deriveFont(30), lab_rgb);
		
		elettrone.move(3, 0);
		
		if (elettrone.getCountMove() > 200)
			remove(elettrone);
		
		if ((protone.getCountMove() / 300) % 2 == 0)
			protone.move(-1, 0);
		else
			protone.move(1, 0);
		
		protone.rotate(2, protone.getX() + protone.getWidth() / 2, protone.getY() + protone.getHeight() / 2);
		
		atlas.rotate(1, atlas.getX() + atlas.getWidth() / 2, atlas.getX() + atlas.getHeight() / 2);
		
		if (instance) {
			int phi = ghosteon.getCountRot() / 2;
			if (ghosteon.getCountRot() > 250) {
				remove(ghosteon);
				instance = false;
			}
			ghosteon.rotate(phi, ghosteon.getX() + 150, ghosteon.getY() + 150);
			ghosteon.grow(0.995f, 0.995f);
			ghosteon.move(2, -1);
		}
		
		String pr = String.valueOf(protone.getCountMove());
		protone.label(pr, protone.getWidth() / 5, protone.getHeight() / 2);
	}

}
