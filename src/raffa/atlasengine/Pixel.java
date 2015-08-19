package raffa.atlasengine;

import java.awt.Color;

public class Pixel {
	
	/*
	 * Create a pixel object with
	 * location and color
	 */
	
	public Color rgb; // Color of the pixel
	public int x, y; // The pixel location

	public Pixel(int x, int y) {
		
		this.x = x;
		this.y = y;
		rgb = Color.black;
	}
	
	public Pixel(int x, int y, Color rgb) {
		
		this.x = x;
		this.y = y;
		this.rgb = rgb;
	}
	
	/*
	 * Set the pixel color
	 */
	
	public void setColor(Color rgb) {
		
		this.rgb = rgb;
	}
	
	/*
	 * Set the pixel location
	 */
	
	public void setLocation(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
}
