package raffa.test;

import java.awt.Color;

import raffa.atlasengine.*;
import raffa.atlasengine.frame.MainPanel;
import raffa.atlasengine.sprite.Sprite;
import raffa.atlasengine.support.Audio;

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
		
		lab = new Sprite(30, 20, 200, 80);
		
		audio = new Audio("./L'addio di Nancy.wav", true);
		audio.setVolume(Audio.VOLUME_MEDIUM);
		
		elettrone = new Elettrone();
		
		protone = new Protone();
		
		atlas = new Sprite(Sprite.fromImage("./Atlas2.png"), 40, 30, 300, 600);
		atlas.zLevel = 1;
		
		
		ghosteon = new Sprite(Sprite.fromImage("./Ghosteon.png"), 260, 200, 300, 250);
		ghosteon.zLevel = 2;
		
		
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
		
		lab.label("Atlas engine try  " + ghosteon.countRot, 20, 40, Sprite.DEFAULT_LABEL_FONT.deriveFont(25), lab_rgb);
		
		elettrone.setLocation(elettrone.x + 3, elettrone.y);
		protone.setLocation(protone.x - 1, protone.y);
		atlas.rotate(1, atlas.x + atlas.width / 2, atlas.y + atlas.height / 2);
		
		if (instance) {
			int phi = ghosteon.countRot / 2;
			if (ghosteon.countRot > 250) {
				remove(ghosteon);
				instance = false;
			}
			ghosteon.rotate(phi, ghosteon.x + 150, ghosteon.y + 150);
			ghosteon.setSize((int)(ghosteon.width * 0.995), (int)(ghosteon.height * 0.995));
			ghosteon.setLocation(ghosteon.x + 2, ghosteon.y - 1);
		}
		
		String pr = String.valueOf(protone.countMove);
		protone.label(pr, protone.width / 5, protone.height / 2);
	}

}
