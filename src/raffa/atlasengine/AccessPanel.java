package raffa.atlasengine;

import java.awt.Graphics2D;

public abstract class AccessPanel {
	
	/*
	 * Commun variable between graphics objects
	 */
	
	public int x, y, width, height, zLevel;

	/*
	 * Commun methods between graphics objects
	 */
	
	/*
	 *Set the object bounds
	 */
	
	public void setBounds(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/*
	 * Set the object x and y location
	 */
	
	public void setLocation(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	/*
	 * Set the object size
	 */
	
	public void setSize(int width, int height) {
		
		this.width = width;
		this.height = height;
	}
	
	/*
	 * Set the object overlapping level
	 */
	
	public void setZLevel(int zLevel) {
		
		this.zLevel = zLevel;
	}
	
	public abstract void paintContent(Graphics2D g); // Draw inside the content
	
	public abstract Graphics2D getGraphics();
}
