package raffa.atlasengine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite extends AccessPanel {
	
	Graphics2D g; // The BufferedImage Graphics2D variable
	BufferedImage sprite; // This is the real sprite object
	
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
		
		setBounds(0, 0, 100, 100);
		zLevel = 1;
		setImage(path);
		g = sprite.createGraphics();
	}
	
	/*
	 * Create a sprite image basing on
	 * the file address and the (x, y) location
	 */
	
	public Sprite(String path, int x, int y) {
		
		setBounds(x, y, 100, 100);
		zLevel = 1;
		setImage(path);
		g = sprite.createGraphics();
	}
	
	/*
	 * Create a sprite image basing on the file address,
	 * the (x, y) location of the image, the width and the height of the image
	 */
	
	public Sprite(String path, int x, int y, int width, int height) {
		
		setBounds(x, y, width, height);
		zLevel = 1;
		setImage(path);
		g = sprite.createGraphics();
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
	
	/*
	 * Get the Graphics2D element of this Sprite to
	 * draw in it
	 */
	
	public Graphics2D getGraphics() {
		
		return g;
	}
	
	/*
	 * Override from AccessPanel
	 * Paint this sprite on the main panel
	 * Do not call this method
	 */

	@Override
	public void paintComp(Graphics2D g, MainPanel observer) {
		
		g.drawImage(sprite, this.x, this.y, this.width, this.height , observer);
		System.out.println("Image drawn");
	}
}
