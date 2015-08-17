package raffa.atlasengine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements MouseListener, KeyListener {
	
	Graphics2D g; // Instance the graphics component that draws the others
	Sprite[] img_added; // Array of the sprites added to this panel
	Panel[] panel_added; // Array of the other panels added to this panel
	
	/*
	 * Create the double buffered main window panel
	 * On this one all the graphics components are written
	 * This is the only serializable panel
	 */
	
	public MainPanel() {
		
		super(null, true);
		super.setBackground(null);
		
		/*
		 *  Add serializable interfaces
		 */
		
		addMouseListener(this);
		addKeyListener(this);
	}
	
	/*
	 * Add a sprite the this panel
	 */
	
	public void add(Sprite sprite) {
		
		int length = img_added.length;
		
		Sprite[] img_prov = new Sprite[length];
		
		for (int i = 0; i < length; i++)
			img_prov[i] = img_added[i];
		
		length++;
		
		img_added = new Sprite[length];
		
		for (int i = 0; i < length; i++)
			img_added[i] = img_prov[i];
		
		img_added[length - 1] = sprite;
		
		sortSprite();
	}
	
	/*
	 *  Add an other panel to this one
	 *  without create a new thread
	 */
	
	public void add(Panel panel) {
		
		int length = panel_added.length;
		
		Panel[] panel_prov = new Panel[length];
		
		for (int i = 0; i < length; i++)
			panel_prov[i] = panel_added[i];
		
		length++;
		
		panel_added = new Panel[length];
		
		for (int i = 0; i < length; i++)
			panel_added[i] = panel_prov[i];
		
		panel_added[length - 1] = panel;
		
		sortPanel();
	}
	
	public void setBackground(Sprite img) {
		
		img.setZLevel(0);
		img.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(img);
	}
	
	public void setBackground(Panel panel) {
		
		panel.setZLevel(0);
		panel.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(panel);
	}
	
	/*
	 * Basing on the zLevel variable of
	 * each Sprite, sort the array img_added
	 */
	
	private void sortSprite() {
		
		boolean flag = false;
		
		for (int i = 0; i < img_added.length; i++) {
			
			for(int j = 0; j < img_added.length - 1; j++) {
				
				if(img_added[j].zLevel > img_added[j+1].zLevel) {
					
                    Sprite k = img_added[j];
                    img_added[j] = img_added[j+1];
                    img_added[j+1] = k;
                    flag = true;
                }
			}
			
			if (!flag) break;
		}
	}
	
	/*
	 * Basing on the zLevel variable of
	 * each panel, sort the array panel_added
	 */
	
	private void sortPanel() {
		
		boolean flag = false;
		
		for (int i = 0; i < panel_added.length; i++) {
			
			for(int j = 0; j < panel_added.length - 1; j++) {
				
				if(panel_added[j].zLevel > panel_added[j+1].zLevel) {
					
                    Panel k = panel_added[j];
                    panel_added[j] = panel_added[j+1];
                    panel_added[j+1] = k;
                    flag = true;
                }
			}
			
			if (!flag) break;
		}
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		
		super.paintComponent(graphics);
		
		g = (Graphics2D) graphics;
		
		/*
		 * Draw the images following
		 * the img_added order
		 */
		
		for (int i = 0; i < img_added.length; i++) {
			g.drawImage(img_added[i].sprite, img_added[i].x, img_added[i].y, img_added[i].width, img_added[i].height, this);
		}
		
		/*
		 * Draw the panels following
		 * the panel_added order
		 */
		
		for (int i = 0; i < panel_added.length; i++) {
			panel_added[i].paintContent(g);
		}
	}
	
	/*
	 * Update the animations
	 * Run the program
	 */
	
	public void update() {
		
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println("Error: Main panel Thread sleep failed\n");
			e.printStackTrace();
		}
		repaint(); // update the graphics components
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
