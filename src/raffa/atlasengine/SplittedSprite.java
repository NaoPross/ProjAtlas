package raffa.atlasengine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class SplittedSprite extends Sprite {
	
	/**
	 * Create a special sprite that can show a part
	 * of the real sprite image
	 */
	
	public int x_rel, y_rel, width_rel, height_rel; // bounds (relative) of the visible part of the sprite
	public BufferedImage sprite_rel; // Relative sprite that contains the splitted image
	public Graphics2D g_rel; // Graphics2D context of the relative sprite

	public SplittedSprite(String path) {
		
		super(path);
		sprite_rel = sprite;
		this.setSplittedPart(0, 0, width, height);
	}
	
	/**
	 * Set the visible part of the real image
	 */
	
	public void setSplittedPart(int x_rel, int y_rel, int width_rel, int height_rel) {
		
		this.x_rel = x_rel;
		this.y_rel = y_rel;
		this.width_rel = width_rel;
		this.height_rel = height_rel;
		
		if (g_rel != null)
			g_rel.dispose();
		
		g_rel = sprite_rel.createGraphics();
		g_rel.drawImage(sprite, x_rel, y_rel, x_rel + width_rel, y_rel, x_rel, y_rel + height_rel, x_rel + width_rel, y_rel + height_rel, (ImageObserver) sprite_rel);
	}
	
	/**
	 * Split the real image in parts with the same width and height,
	 * than you can select which one you show on the relative sprite
	 */
	
	public int split(int parts, int selection) {
		
		int width = this.width / parts;
		int height = this.height / parts;
		int x = width * selection;
		int y = 0;
		while (x < parts) {
			y++;
			x -= parts;
		}
		this.setSplittedPart(x, y, width, height);
		return (int) Math.pow(parts, 2);
	}
	
	@Override
	public void paint(Graphics2D g) {
		
		g.rotate(phi, xRot, yRot);
		
		/*
		 * Draw the relative sprite image
		 */
		
		g.drawImage(sprite_rel, x, y, width, height , null);
		
		/*
		 * Draw the components
		 */
		
		for (int i = 0; i < comp_added.length; i++) {
			comp_added[i].paint(g);
		}
		
		
		g.rotate(-phi, xRot, yRot);
	}
}
