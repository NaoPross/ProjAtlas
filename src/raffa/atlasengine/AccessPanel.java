package raffa.atlasengine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class AccessPanel {
	
	/*
	 * Commun variable between graphics objects (subclasses)
	 */
	
	public int x, y, width, height, zLevel, xRot, yRot, countMove, countRot;
	protected float phi;
	public boolean move, rotate, visible;
	protected BufferedImage sprite;
	protected AccessPanel[] comp_added;
	protected Graphics2D g;
	
	public AccessPanel() {
		
		x = 0;
		y = 0;
		width = 100;
		height = 100;
		phi = 0;
		zLevel = 1;
		xRot = x;
		yRot = y;
		countMove = 0;
		countRot = 0;
		sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g = sprite.createGraphics();
		move = false;
		rotate = false;
		visible = true;
		comp_added = new AccessPanel[0];
	}
	
	public AccessPanel(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		phi = 0;
		zLevel = 1;
		xRot = x;
		yRot = y;
		countMove = 0;
		countRot = 0;
		sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g = sprite.createGraphics();
		move = false;
		rotate = false;
		visible = true;
		comp_added = new AccessPanel[0];
	}
	
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
		
		if (!move) {
			countMove = 0;
			move = true;
		}
		
		this.x = x;
		this.y = y;
		countMove++;
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
	
	/*
	 * Remove a component from this one
	 */
	
	public void remove(AccessPanel component) {
		
		int length = comp_added.length;
		
		for (int i = 0; i < length; i++) {
			if (comp_added[i] == component)
				comp_added[i] = null;
		}
		
		AccessPanel[] comp_prov = new AccessPanel[length - 1];
		
		int j = 0;
		int w = 0;
		while (w < length - 1) {
			if (comp_added[j] == null)
				j++;
			comp_prov[w] = comp_added[j];
			j++;
			w++;
		}
		
		comp_added = new AccessPanel[length - 1];
		
		for (int i = 0; i < length - 1; i++)
			comp_added[i] = comp_prov[i];
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
		
		if (!rotate) {
			countRot = 0;
			rotate = true;
		}
		phi %= 360;
		this.phi += (float)(phi * Math.PI / 180);
		//System.out.println("Rotation of" + phi + "degrees");
		countRot++;
	}
	
	/*
	 * Rotate a component around a point
	 */
	
	public void rotate(int phi, int xRot, int yRot) {
		
		this.xRot = xRot;
		this.yRot = yRot;
		rotate(phi);
	}
	
	/*
	 * Get the Graphics2D element of this Sprite to
	 * draw in it
	 */
	
	public Graphics2D getGraphics() {
		
		return g;
	}
	
	/*
	 * Modify a pixel of the image
	 */
	
	public void drawPixel(int x, int y, Color rgb) {
		
		int color = rgb.getRGB();
		sprite.setRGB(x, y, color);
	}
	
	public void setBorder(Color rgb) {
		
		g.setColor(rgb);
		g.drawRect(1, 1, width - 2, height - 2);
	}
	
	private void render() {
		
		if (this.sprite == null) {
			this.sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			
			if (this.sprite == null) {
				System.out.println("Sprite not rendered");
				return;
			}
		}
		else {
			if (g != null)
				g.dispose();
			g = sprite.createGraphics();
		}
	}
	
	public void paint(Graphics2D g) {
		
		g.rotate(phi, xRot, yRot);
		
		/*
		 * Draw the components
		 */
		
		render();
		
		for (int i = 0; i < comp_added.length; i++) {
			comp_added[i].paint(this.g);
		}
		
		/*
		 * Draw the sprite image
		 */
		
		g.drawImage(sprite, x, y, width, height , null);
		
		
		g.rotate(-phi, xRot, yRot);
	}
	
}
