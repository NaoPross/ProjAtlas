package raffa.atlasengine;

import java.awt.Graphics2D;

public interface AccessPanel {

	/*
	 * Commun methods between graphics objects
	 */
	
	public abstract void setBounds(int x, int y, int width, int height); // Set the object bounds
	
	public abstract void setLocation(int x, int y); // Set the object x and y location
	
	public abstract void setSize(int width, int height); // Set the object size
	
	public abstract void setZLevel(int zLevel); // Set the object overlapping level
	
	public abstract void paintContent(Graphics2D g); // Draw inside the content
}
