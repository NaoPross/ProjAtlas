package raffa.atlasengine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements MouseListener, KeyListener {
	
	Graphics2D g; // Instance the graphics component that draws the others
	AccessPanel[] comp_added; // Array of all the components added
	
	/*
	 * Create the double buffered main window panel
	 * On this one all the graphics components are written
	 * This is the only serializable panel
	 */
	
	public MainPanel() {
		
		super(null, true);
		super.setBackground(null);
		comp_added = new AccessPanel[0];
		
		/*
		 *  Add serializable interfaces
		 */
		
		addMouseListener(this);
		addKeyListener(this);
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		
		super.paintComponent(graphics);
		
		g = (Graphics2D) graphics;
		
		/*
		 * Paint all the components added
		 */
		for (int i = 0; i < comp_added.length; i++) {
			try {
				comp_added[i].paintComp(g, this);
				System.out.println("Drawn a component");
			} catch (NullPointerException e) {}
		}
	}
	
	/*
	 * Run and update the animations
	 */
	
	public void update() {
		
		try {
			Thread.sleep(100);
			System.out.println("Thread has sleeped 100");
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
	
	/*
	 * Override from InterPanel
	 * Sort the comp_added array basing
	 * on the zLevel variable of each component
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
	 * Override from InterPanel
	 * Add a component to the comp_added array and sort it
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
	 * 
	 * Set the component zLevel to 0 and
	 * adapt the width and the height to
	 * the main panel
	 * Set it as Background of the main panel
	 */

	public void setBackGround(AccessPanel component) {
		
		component.setZLevel(0);
		component.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(component);
	}

}
