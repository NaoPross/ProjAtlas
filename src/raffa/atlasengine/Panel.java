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
		
		setBounds(50, 30, 200, 100);
		this.defaultValue();
	}
	
	public Panel(int x, int y, int width, int height) {
		
		setBounds(x, y, width, height);
		this.defaultValue();
	}
	
	public Panel(int x, int y, int width, int height, int zLevel) {
		
		setBounds(x, y, width, height);
		this.defaultValue();
		this.zLevel = zLevel;
	}
	
	/*
	 * Override from AccessPanel
	 * Contains this panel's default values
	 */
	
	@Override
	protected void defaultValue() {
		
		super.defaultValue();
		border = false;
		pixel = new Pixel[0];
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
	 * 
	 * Draws pixels, border and component added
	 * to this panel
	 */
	
	@Override
	public void paintComp(Graphics2D g) {
		
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
		
		/*
		 * Draw the components
		 */
		
		for (int i = 0; i < comp_added.length; i++) {
			comp_added[i].paintComp(g);
		}
		
		g.rotate(-phi, xRot, yRot);
	}
	
	
}
