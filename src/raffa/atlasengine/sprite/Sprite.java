package raffa.atlasengine.sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import raffa.atlasengine.support.ArrayComponent;

public class Sprite {
	
	protected Graphics2D g; // The BufferedImage Graphics2D variable
	public int x, y, width, height, zLevel, xRot, yRot, countMove, countRot;
	protected float phi;
	public boolean visible;
	protected Sprite[] comp_added;
	protected ArrayList<Label> label_added;
	protected Color label_color;
	protected Font label_font;
	protected BufferedImage sprite;
	
	public static final int DEFAULT_Z_LEVEL = 0x1;
	public static final int DEFAULT_LOCATION = 0x0;
	public static final int DEFAULT_SIZE = 0x64;
	
	/**
	 * Constructor without parameters
	 */
	
	public Sprite() {
		
		sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.x = DEFAULT_LOCATION;
		this.y = DEFAULT_LOCATION;
		this.width = DEFAULT_SIZE;
		this.height = DEFAULT_SIZE;
		defaultValues();
	}
	
	/**
	 * Constructor with bounds parameters
	 */
	
	public Sprite(int x, int y, int width, int height) {
		
		sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		defaultValues();
	}
	
	/**
	 * Constructor with a image paramenter
	 */
	
	public Sprite(BufferedImage img) {
		
		sprite = img;
		this.x = DEFAULT_LOCATION;
		this.y = DEFAULT_LOCATION;
		this.width = DEFAULT_SIZE;
		this.height = DEFAULT_SIZE;
		defaultValues();
	}
	
	/**
	 * Constructor with image and bounds parameters
	 */
	
	public Sprite(BufferedImage img, int x, int y, int width, int height) {
		
		sprite = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		defaultValues();
	}
	
	/**
	 * Sprite object default values
	 */
	
	private void defaultValues() {
		
		phi = 0;
		zLevel = DEFAULT_Z_LEVEL;
		xRot = x;
		yRot = y;
		countMove = 0;
		countRot = 0;
		visible = true;
		g = sprite.createGraphics();
		comp_added = new Sprite[0];
		label_added = new ArrayList<Label>();
		label_color = Color.black;
		label_font = new Font(Font.SANS_SERIF, Font.ITALIC, 18);
	}
	
	/**
	 * Get tho overlapping level of a component
	 */
	
	public int getZLevel() {
		
		return zLevel;
	}
	
	/**
	 * Set the overlapping level of a component
	 * Default value = 1
	 */

	
	public void setZLevel(int zLevel) {
		
		this.zLevel = zLevel;
	}
	
	/**
	 * Set the component bounds
	 */

	
	public void setBounds(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * draw a string
	 */
	
	public void label(String str, int x, int y) {
		
		Label temp = new Label();
		temp.str = str;
		temp.x = x;
		temp.y = y;
		label_added.add(temp);
	}
	
	/**
	 * set the font and color of the string
	 */
	
	public void labelSettings(Font font, Color color) {
		
		label_font = font;
		label_color = color;
	}
	
	/**
	 * get the label parameters
	 */
	
	public Font getLabelFont() {
		
		return label_font;
	}
	
	public Color getLabelColor() {
		
		return label_color;
	}
	
	/**
	 * set the component location in the main panel
	 */

	
	public void setLocation(int x, int y) {
		
		this.x = x;
		this.y = y;
		countMove++;
	}
	
	/**
	 * Set the component size
	 */

	
	public void setSize(int width, int height) {
		
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Add a component to the panel
	 */
	
	public void add(Sprite component) {
		
		comp_added = ArrayComponent.add(comp_added, component);
		comp_added = ArrayComponent.sort(comp_added);
	}
	
	/**
	 * Remove a specific component from the panel
	 */
	
	public void remove(Sprite component) {
		
		comp_added = ArrayComponent.remove(comp_added, component);
	}
	
	/**
	 * Set the sprite image
	 */
	
	public void setImage(BufferedImage img) {
		
		sprite = img;
	}
	
	/**
	 * Set a component as a background of another component
	 */
	
	public void setBackground(Sprite component) {
		
		component.setZLevel(0);
		component.setBounds(this.x, this.y, this.width, this.height);
		this.add(component);
	}
	
	/**
	 * Rotate a component around its location
	 */
	
	public void rotate(int phi) {
		
		phi %= 360;
		this.phi += (float)(phi * Math.PI / 180);
		countRot++;
	}
	
	/**
	 * Rotate a component around a point
	 */
	
	public void rotate(int phi, int xRot, int yRot) {
		
		this.xRot = xRot;
		this.yRot = yRot;
		rotate(phi);
	}
	
	/**
	 * Modify a pixel of the image
	 */
	
	public void drawPixel(int x, int y, Color rgb) {
		
		int color = rgb.getRGB();
		sprite.setRGB(x, y, color);
	}
	
	/**
	 * crop the image keeping the old dimensions
	 */
	
	public void crop(int x, int y, int width, int height) {
		
		BufferedImage temp = sprite;
		
		sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		g = sprite.createGraphics();
		
		g.drawImage(temp, x, y, x + width, y, x, y + height, x + width, y + height, (ImageObserver) sprite);
	}
	
	/**
	 * Override this method to draw something
	 * in this panel
	 * The components drawn here don't have any priority
	 */
	
	protected void paintIn(Graphics2D g) {
		
	}
	
	/**
	 * Draw the component's
	 */
	
	private void paintPanel() {
		
		paintIn(this.g);
		
		for (int i = 0; i < comp_added.length; i++) {
			comp_added[i].paint(this.g);
		}
		
		g.setFont(label_font);
		g.setColor(label_color);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		for (int i = 0; i < label_added.size(); i++) {
			Label temp = label_added.get(i);
			g.drawString(temp.str, temp.x, temp.y);
		}
		
		label_added.clear();
	}
	
	public void paint(Graphics2D g) {
		
		g.rotate(phi, xRot, yRot);
		
		/**
		 * Render the sprite buffer and draw the components
		 */
		
		paintPanel();
		
		/**
		 * Draw the sprite image
		 */
		
		g.drawImage(sprite, x, y, width, height , null);
		
		
		g.rotate(-phi, xRot, yRot);
	}
	
	/**
	 * Update the image from the image file
	 */
	
	public static BufferedImage fromImage(String path) {
		
		BufferedImage sprite;
		
		try {
			sprite = ImageIO.read(new File(path)); 	// Input from the image file
		} catch (IOException e) {
			System.out.println("Image " + path + " not loaded");
			sprite = null;
		}
		
		return sprite;
	}
	
	public static class Label {
		
		String str;
		int x, y;
	}
}
