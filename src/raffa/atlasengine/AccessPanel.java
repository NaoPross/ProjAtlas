package raffa.atlasengine;

import java.awt.Graphics2D;

public abstract class AccessPanel {
	
	/*
	 * Commun variable between graphics objects (subclasses)
	 */
	
	public int x, y, width, height, zLevel;
	
	/*
	 * 
	 * return the overlapping level of a component
	 */

	
	public int getZLevel() {
		
		return zLevel;
	}
	
	/*
	 * 
	 * set the overlapping level of a component
	 * Default value = 1
	 */

	
	public void setZLevel(int zLevel) {
		
		this.zLevel = zLevel;
	}
	
	/*
	 * 
	 * set the component bounds
	 */

	
	public void setBounds(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/*
	 * 
	 * set the component location in the main panel
	 */

	
	public void setLocation(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	/*
	 * 
	 * set the component size
	 */

	
	public void setSize(int width, int height) {
		
		this.width = width;
		this.height = height;
	}
	
	public abstract void paintComp(Graphics2D g, MainPanel observer);
	
}
