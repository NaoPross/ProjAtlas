package raffa.atlasengine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite extends BufferedImage implements AccessPanel {

	public int zLevel, x, y, width, height;
	Graphics2D g;
	
	/*
	 * Create a double buffered RGB sprite image
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
	 */
	
	public Sprite(String path) {
		
		super(100, 100, BufferedImage.TYPE_INT_RGB);
		setBounds(0, 0, 100, 100);
		zLevel = 1;
		setImage(path);
		g = this.createGraphics();
	}
	
	/*
	 * Create a sprite image basing on
	 * the file address and the (x, y) location
	 */
	
	public Sprite(String path, int x, int y) {
		
		super(100, 100, BufferedImage.TYPE_INT_RGB);
		setBounds(x, y, 100, 100);
		zLevel = 1;
		setImage(path);
		g = this.createGraphics();
	}
	
	/*
	 * Create a sprite image basing on the file address,
	 * the (x, y) location of the image, the width and the height of the image
	 */
	
	public Sprite(String path, int x, int y, int width, int height) {
		
		super(width, height, BufferedImage.TYPE_INT_RGB);
		setBounds(x, y, width, height);
		zLevel = 1;
		setImage(path);
		g = this.createGraphics();
	}
	
	/*
	 * Update the image from the image file
	 */
	
	public void setImage(String path) {
		
		File file = new File(path);
		try {
			ImageIO.read(file); 		// Input of the image
		} catch (IOException e) {
			System.out.println("IOError: Image file not found\n"); // IO error message
			e.printStackTrace();
		}
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void setZLevel(int zLevel) {
		
		this.zLevel = zLevel;
	}

	@Override
	public void setLocation(int x, int y) {
		
		this.x = x;
		this.y = y;
	}

	@Override
	public void setSize(int width, int height) {
		
		this.width = width;
		this.height = height;
	}

	@Override
	public void paintContent(Graphics2D g) {
		
		g = this.getGraphics();
	}
	
	@Override
	public Graphics2D getGraphics() {
		
		return g;
	}
}
