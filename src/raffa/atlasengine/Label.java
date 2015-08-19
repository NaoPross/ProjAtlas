package raffa.atlasengine;

import java.awt.Font;
import java.awt.Graphics2D;

public class Label extends AccessPanel {
	
	/*
	 * This class draws a string in a panel
	 */
	
	public String text; // The String that has to be drawn
	public Font type; // The Font type of the string
	int size; // The Font size of the string
	
	public Label(String text) {
		
		this.text = text;
		type = new Font(Font.SANS_SERIF, Font.PLAIN, 10);
	}
	
	public Label(String text, int size) {
		
		this.text = text;
		this.size = size;
		type = new Font(Font.SANS_SERIF, Font.PLAIN, size);
	}
	
	public Label(String text, Font type) {
		
		this.text = text;
		this.type = type;
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

	@Override
	public void paintComp(Graphics2D g, MainPanel observer) {
		
		g.setFont(type);
		g.drawString(text, x, y);
	}

}
