package raffa.atlasengine;

public abstract class AccessPanel implements InterPanel {
	
	/*
	 * Commun variable between graphics objects (subclasses)
	 */
	
	public int x, y, width, height, zLevel;
	
	/*
	 * Methods inherited from InterPanel
	 * They don't have a function in this class
	 */

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(InterPanel I) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBackGround(InterPanel I) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Override from InterPanel
	 * return the overlapping level of a component
	 */

	@Override
	public int getZLevel() {
		
		return zLevel;
	}
	
	/*
	 * Override from InterPanel
	 * set the overlapping level of a component
	 * Default value = 1
	 */

	@Override
	public void setZLevel(int zLevel) {
		
		this.zLevel = zLevel;
	}
	
	/*
	 * Override from InterPanel
	 * set the component bounds
	 */

	@Override
	public void setBounds(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/*
	 * Override from InterPanel
	 * set the component location in the main panel
	 */

	@Override
	public void setLocation(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	/*
	 * Override from InterPanel
	 * set the component size
	 */

	@Override
	public void setSize(int width, int height) {
		
		this.width = width;
		this.height = height;
	}
	
}
