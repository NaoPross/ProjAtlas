package raffa.atlasengine;

import java.awt.Color;

public class Pixel {
	
	public Color rgb;
	public int x, y;

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
}
