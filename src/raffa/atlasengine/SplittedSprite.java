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

	public SplittedSprite(String path) {
		
		super(path);
		sprite_rel = sprite;
		this.setSplittedPart(0, 0, width, height);
	}
	
	@Override
	public void setImage(String path) {
		
		super.setImage(path);
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
		
		if (g != null)
			g.dispose();
		
		g = sprite.createGraphics();
		g.drawImage(sprite_rel, x_rel, y_rel, x_rel + width_rel, y_rel, x_rel, y_rel + height_rel, x_rel + width_rel, y_rel + height_rel, (ImageObserver) sprite);
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
}
