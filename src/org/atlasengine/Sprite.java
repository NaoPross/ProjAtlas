package org.atlasengine;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite extends BuildPanel {
	public File imageFile;
	
	public Sprite(File imageFile) {
		this.imageFile = imageFile;
	}
	
	public Image getImage() {
		Image image = null;
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
