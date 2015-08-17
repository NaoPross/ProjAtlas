package raffa.atlasengine;

import java.awt.Graphics2D;

public class Panel extends AccessPanel {
	
	protected Graphics2D g;
	
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
	}
	
	public Panel(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		zLevel = 1;
	}
	
	public Panel(int x, int y, int width, int height, int zLevel) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.zLevel = zLevel;
	}
	
	/*
	 * Override this method in the
	 * subclasses to paint in the panel
	 */
	
	@Override
	public void paintContent(Graphics2D g) {
		
		this.g = g;
	}
	
	/*
	 * Return the graphics component of the panel
	 */
	
	@Override
	public Graphics2D getGraphics() {
		
		return g;
	}
}
