package raffa.atlasengine;

import java.awt.Graphics2D;

public abstract class AccessPanel {
	
	/*
	 * Commun variable between graphics objects (subclasses)
	 */
	
	public int x, y, width, height, zLevel, xRot, yRot;
	public float phi;
	AccessPanel[] comp_added;
	
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
	
	/*
	 * Add a component in another one adapting
	 * it in the container's bounds
	 */
	
	public void add(AccessPanel component) {
		
		if (component.x > width || component.y > height || (component.x < 0 && component.width < - component.x) || (component.y < 0 && component.width < - component.y)) {
			System.out.println("Component out of panel's bounds");
		} else {
			
			if (component.x < 0 && component.width > - component.x) {
				component.x = 0;
			} else if (component.y < 0 && component.height > - component.y){
				component.y = 0;
			} else if (component.width > width - component.x) {
				component.width = width - component.x;
			} else if (component.height > height - component.y) {
				component.height = height - component.y;
			}
			
			component.x += this.x;
			component.y += this.y;
		
			int length = comp_added.length;
		
			AccessPanel[] comp_prov = new AccessPanel[length + 1];
		
			for (int i = 0; i < length; i++)
				comp_prov[i] = comp_added[i];
		
			length++;
		
			comp_added = new AccessPanel[length];
		
			for (int i = 0; i < length; i++)
				comp_added[i] = comp_prov[i];
		
			comp_added[length - 1] = component;
		
			sort();
		}
	}
	
	/*
	 * Sort the array comp_added basing on
	 * the zLevel of each one
	 */
	
	public void sort() {
		
		boolean flag = false;
		
		for (int i = 0; i < comp_added.length; i++) {
			
			for(int j = 0; j < comp_added.length - 1; j++) {
				
				if(comp_added[j].getZLevel() > comp_added[j+1].getZLevel()) {
					AccessPanel k = comp_added[j];
                			comp_added[j] = comp_added[j+1];
               				comp_added[j+1] = k;
                    			flag = true;
                		}
			}
			
			if (!flag) break;
		}
	}
	
	/*
	 * Set a component as a background of another component
	 */
	
	public void setBackground(AccessPanel component) {
		
		component.setZLevel(0);
		component.setBounds(this.x, this.y, this.width, this.height);
		//System.out.println(this.getWidth() + "  " + this.getHeight());
		this.add(component);
	}
	
	/*
	 * Rotate a component around its location
	 */
	
	public void rotate(int phi) {
		
		phi %= 360;
		this.phi += (float)(phi * Math.PI / 180);
		//System.out.println("Rotation of" + phi + "degrees");
	}
	
	/*
	 * Rotate a component around a point
	 */
	
	public void rotate(int phi, int xRot, int yRot) {
		
		this.xRot = xRot;
		this.yRot = yRot;
		rotate(phi);
	}
	
	public abstract void paintComp(Graphics2D g, MainPanel observer);
	
}
