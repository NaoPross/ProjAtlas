package raffa.atlasengine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.sun.org.apache.xml.internal.utils.CharKey;

public class Label extends AccessPanel {
	
	/*
	 * This class draws a string in a panel
	 */
	
	public String text; // The String that has to be drawn
	public Font type; // The Font type of the string
	int size; // The Font size of the string
	public Color rgb;
	
	public Label(String text) {
		
		this.text = text;
		rgb = Color.BLACK;
		size = 10;
		type = new Font(Font.SANS_SERIF, Font.PLAIN, size);
		paintString();
	}
	
	public Label(String text, int x, int y) {
		
		this.text = text;
		this.setLocation(x, y);
		rgb = Color.BLACK;
		size = 10;
		type = new Font(Font.SANS_SERIF, Font.PLAIN, size);
		paintString();
	}
	
	public Label(String text, int x, int y, int size) {
		
		this.text = text;
		this.size = size;
		type = new Font(Font.SANS_SERIF, Font.PLAIN, size);
		this.setLocation(x, y);
		rgb = Color.BLACK;
		paintString();
	}
	
	public Label(String text, int x, int y, Font type) {
		
		this.text = text;
		this.type = type;
		this.setLocation(x, y);
		rgb = Color.BLACK;
		size = 10;
		paintString();
	}
	
	/*
	 * Contains this label's default values
	 */
	
	private void paintString() {
		
		if (g != null)
			g.dispose();
		g = sprite.createGraphics();
		g.setFont(type);
		g.drawString(text, 1, 1);
	}
	
	/*
	 * Set the string
	 */
	
	public void setText(String text) {
		
		this.text = text;
		paintString();
	}
	
	/*
	 * Set the Font type
	 */
	
	public void setFont(String font, int style, int size) {
		
		this.size = size;
		type = new Font(font, style, size);
		paintString();
	}
	
	/*
	 * Set the Font size
	 */
	
	public void setSize(int size) {
		
		this.size = size;
		String font = type.getFontName();
		int style = type.getStyle();
		type = new Font(font, style, size);
		paintString();
	}
	
	public void setColor(Color rgb) {
		
		this.rgb = rgb;
		paintString();
	}
}
