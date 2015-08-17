package raffa.atlasengine;

import java.awt.Graphics2D;

public interface InterPanel {
	
	/*
	 * These are the commun methods
	 * of the classes which implement
	 * this interface
	 */

	public abstract void sort();
	
	public abstract void add(InterPanel I);
	
	public abstract void setBackGround(InterPanel I);
	
	public abstract int getZLevel();
	
	public abstract void setZLevel(int zLevel);
	
	public abstract void setBounds(int x, int y, int width, int height);
	
	public abstract void setLocation(int x, int y);
	
	public abstract void setSize(int width, int height);
	
	public abstract void paintComp(Graphics2D g, MainPanel observer);
}
