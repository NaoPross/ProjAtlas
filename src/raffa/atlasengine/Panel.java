package raffa.atlasengine;

import java.awt.Color;
import java.awt.Graphics2D;

public class Panel extends AccessPanel {
	
	Color rgb_border; // Color of the border
	boolean border; // True if the panel has a border
	Pixel[] pixel; // Array of the pixel drawn in the panel
	
	/*
	 * Create a panel
	 * Default parameters:
	 * 	x = 50
	 * 	y = 30
	 * 	width = 200
	 * 	height = 100
	 * 	zLevel = 1
	 */
	
	public Panel() {
		
		x = 50;
		y = 30;
		width = 200;
		height = 100;
		zLevel = 1;
		phi = 0;
		xRot = x;
		yRot = y;
		border = false;
		pixel = new Pixel[0];
		comp_added = new AccessPanel[0];
	}
	
	public Panel(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		zLevel = 1;
		phi = 0;
		xRot = x;
		yRot = y;
		border = false;
		pixel = new Pixel[0];
		comp_added = new AccessPanel[0];
	}
	
	public Panel(int x, int y, int width, int height, int zLevel) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.zLevel = zLevel;
		phi = 0;
		xRot = x;
		yRot = y;
		border = false;
		pixel = new Pixel[0];
		comp_added = new AccessPanel[0];
	}
	
	/*
	 * Set a rectangle border to this panel
	 */
	
	public void setBorder(Color rgb) {
		
		border = true;
		this.rgb_border = rgb;
	}
	
	
	
	/*
	 * Add a pixel to the array pixel
	 */
	
	public void drawPixel(int x, int y, Color rgb) {
		
		if (x > width || x < 0) {
			System.out.println("Location x out of panel's bounds");
		} else if (y > height || y < 0) {
			System.out.println("Location y out of panel's bounds");
		} else {
			
			Pixel pix = new Pixel(x, y, rgb);
			
			int length = pixel.length;
			
			Pixel[] pixel_prov = new Pixel[length];
			
			for (int i = 0; i < length; i++)
				pixel_prov[i] = pixel[i];
			
			length++;
			
			pixel = new Pixel[length];
			
			for (int i = 0; i < length; i++)
				pixel[i] = pixel_prov[i];
			
			pixel[length - 1] = pix;
		}
	}

	/*
	 * Override from AccessPanel
	 * Override this method to draw something in
	 * the mainPanel
	 * 
	 * In the overrided method write
	 * super.paintComp(g, observer);
	 * if you want to upload the graphics
	 * component relative to this panel
	 */
	
	@Override
	public void paintComp(Graphics2D g, MainPanel observer) {
		
		g.rotate(phi, xRot, yRot);
		
		/*
		 * Draw the pixels basing on the pixel array
		 */
		
		for (int i = 0; i < pixel.length; i++) {
				g.setColor(pixel[i].rgb);
				g.drawLine(x + pixel[i].x, y + pixel[i].y, x + pixel[i].x, y + pixel[i].y); // Draw a pixel
		}
		
		/*
		 * Draw the border
		 */
		
		if (border) {
			g.setColor(rgb_border);
			g.drawRect(x, y, width, height);
		}
		
		g.rotate(-phi, xRot, yRot);
	}
	
	
}
