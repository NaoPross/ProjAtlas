package raffa.atlasengine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite extends AccessPanel {
	
	public Graphics2D g; // The BufferedImage Graphics2D variable
	
	/*
	 * Create a mechanic for a BufferedImage
	 * that is instanced
	 * basing on the file address
	 * 
	 * Create also a Graphics2D parameter
	 * to paint into the image
	 * 
	 * Default parameters:
	 * 	x = 0
	 * 	y = 0
	 * 	width = 100
	 * 	height = 100
	 * 	zLevel = 1
	 * 
	 * The real sprite object is obtained
	 * calling tha variable (BufferedImage sprite)
	 */
	
	public Sprite(String path) {
		
		setImage(path);
	}
	
	/*
	 * Create a sprite image basing on
	 * the file address and the (x, y) location
	 */
	
	public Sprite(String path, int x, int y) {
		
		setLocation(x, y);
		setImage(path);
	}
	
	/*
	 * Create a sprite image basing on the file address,
	 * the (x, y) location of the image, the width and the height of the image
	 */
	
	public Sprite(String path, int x, int y, int width, int height) {
		
		super(x, y, width, height);
		setImage(path);
	}
	
	/*
	 * Update the image from the image file
	 */
	
	public void setImage(String path) {
		
		File file = new File(path);
		sprite = null;
		try {
			sprite = ImageIO.read(file); 		// Input of the image
		} catch (IOException e) {
			System.out.println("IOError: Image file not found\n"); // IO error message
			e.printStackTrace();
		}
	}
}
