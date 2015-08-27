package raffa.atlasengine;

import java.awt.AWTError;
import java.awt.Color;
import java.awt.Graphics2D;

public class Panel extends AccessPanel {
	
	Color rgb_border; // Color of the border
	boolean border; // True if the panel has a border
	int[][] pixel; // Array of the pixel drawn in the panel
	
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
	
	private void defaultValue() {
		
		border = false;
		pixel = new int[0][3];
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
		
		if ((x > width || x < 0) || (y > height || y < 0)) {
			// Do nothing
		} else {
			
			int[] pix = {x, y, rgb.getRGB()};
			
			int length = pixel.length;
			
			int[][] pixel_prov = new int[length][3];
			
			for (int i = 0; i < length; i++) {
				for(int j = 0; j < 3; j++)
					pixel_prov[i][j] = pixel[i][j];
			}
			
			length++;
			
			pixel = new int[length][3];
			
			for (int i = 0; i < length - 1; i++) {
				for (int j = 0; j < 3; j++)
					pixel[i][j] = pixel_prov[i][j];
			}
			
			for (int j = 0; j < 3; j++)
				pixel[length - 1][j] = pix[j];
		}
	}

	/*
	 * Override from AccessPanel
	 * 
	 * Draws pixels, border and component added
	 * to this panel
	 */
	
	@Override
	public void paint(Graphics2D g) {
		
		g.rotate(phi, xRot, yRot);
		
		/*
		 * Draw the components
		 */
		
		for (int i = 0; i < comp_added.length; i++) {
			comp_added[i].paint(g);
		}
		
		/*
		 * Draw the pixels basing on the pixel array
		 */
		
		for (int i = 0; i < pixel.length; i++) {
				g.setColor(new Color(pixel[i][2]));
				g.drawLine(x + pixel[i][0], y + pixel[i][0], x + pixel[i][0], y + pixel[i][0]); // Draw a pixel
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
