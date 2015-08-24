package raffa.atlasengine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Label extends AccessPanel {
	
	/*
	 * This class draws a string in a panel
	 */
	
	public String text; // The String that has to be drawn
	public Font type; // The Font type of the string
	int size; // The Font size of the string
	public Color rgb;
	
	public Label(String text, int x, int y) {
		
		this.text = text;
		type = new Font(Font.SANS_SERIF, Font.PLAIN, 10);
		this.x = x;
		this.y = y;
		phi = 0;
		xRot = x;
		yRot = y;
		rgb = Color.BLACK;
		instance = true;
	}
	
	public Label(String text, int x, int y, int size) {
		
		this.text = text;
		this.size = size;
		type = new Font(Font.SANS_SERIF, Font.PLAIN, size);
		this.x = x;
		this.y = y;
		phi = 0;
		xRot = x;
		yRot = y;
		rgb = Color.BLACK;
		instance = true;
	}
	
	public Label(String text, int x, int y, Font type) {
		
		this.text = text;
		this.type = type;
		this.x = x;
		this.y = y;
		phi = 0;
		xRot = x;
		yRot = y;
		rgb = Color.BLACK;
		instance = true;
	}
	
	/*
	 * Set the string
	 */
	
	public void setText(String text) {
		
		this.text = text;
	}
	
	/*
	 * Set the Font type
	 */
	
	public void setFont(String font, int style, int size) {
		
		this.size = size;
		type = new Font(font, style, size);
	}
	
	/*
	 * Set the Font size
	 */
	
	public void setSize(int size) {
		
		this.size = size;
		String font = type.getFontName();
		int style = type.getStyle();
		type = new Font(font, style, size);
	}
	
	public void setColor(Color rgb) {
		
		this.rgb = rgb;
	}

	@Override
	public void paintComp(Graphics2D g) {
		
		g.rotate(phi, xRot, yRot);
		
		g.setColor(rgb);
		g.setFont(type);
		g.drawString(text, x, y);
		
		g.rotate(-phi, xRot, yRot);
	}

}
