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
	public Color rgb;
	
	public Label(String text) {
		
		this.text = text;
		rgb = Color.BLACK;
		height = 10;
		type = new Font(Font.SANS_SERIF, Font.PLAIN, height);
		sprite = null;
	}
	
	public Label(String text, int x, int y) {
		
		this.text = text;
		this.setLocation(x, y);
		rgb = Color.BLACK;
		height = 10;
		type = new Font(Font.SANS_SERIF, Font.PLAIN, height);
		sprite = null;
	}
	
	public Label(String text, int x, int y, int size) {
		
		this.text = text;
		this.height = size;
		type = new Font(Font.SANS_SERIF, Font.PLAIN, size);
		this.setLocation(x, y);
		rgb = Color.BLACK;
		sprite = null;
	}
	
	public Label(String text, int x, int y, Font type) {
		
		this.text = text;
		this.type = type;
		this.setLocation(x, y);
		rgb = Color.BLACK;
		height = 10;
		sprite = null;
	}
	
	/*
	 * Contains this label's default values
	 */
	
	@Override
	public void paint(Graphics2D g) {
		
		g.rotate(phi, xRot, yRot);
		
		/*
		 * Draw the string
		 */
		
		g.setColor(rgb);
		g.setFont(type);
		g.drawString(text, x, y);
		
		g.rotate(-phi, xRot, yRot);
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
		
		this.height = size;
		type = new Font(font, style, size);
	}
	
	/*
	 * Set the Font size
	 */
	
	public void setSize(int height) {
		
		this.height = height;
		type = type.deriveFont((float)height);
	}
	
	public void setColor(Color rgb) {
		
		this.rgb = rgb;
	}
}
