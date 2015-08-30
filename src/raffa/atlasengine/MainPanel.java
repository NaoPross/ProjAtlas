package raffa.atlasengine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable {
	
	/**
	 * Create a new Thread of the main panel int he window
	 */
	
	private Graphics2D g, bufferGraphics; // Instance the graphics component that draws the others
	private AccessPanel[] comp_added; // Array of all the components added
	
	/**
	 * The game status:
	 * when isRunning is false the program is stopped and closed
	 * when gameOver is false the animations are stopped but the program is always running
	 */
	
	public static volatile boolean isRunning, gameOver;
	
	protected Window window; // The window that contains the main panel
	public static volatile int sleepTime; // The relative extimated sleepTime for the animations
	private Thread animator;
	
	private Image buffer; // The second buffer of the main panel
	
	/**
	 * Create the double buffered panel the is the content of the window
	 * On this one all the graphics components are written
	 * This is the only serializable panel
	 */
	
	public MainPanel(String title, int x, int y, int width, int height) {
		
		super(null, true); 		// layout = null, doubleBuffer = true
		super.setBackground(null);
		comp_added = new AccessPanel[0];
		isRunning = false;
		animator = null;
		gameOver = false;
		
		window = new Window(title, x, y, width, height);
		this.setPreferredSize(new Dimension(getWidth(), getHeight()));
		sleepTime = 20;
		window.setContentPane(this);
		
	}
	
	@Override
	public void setVisible(boolean isVisible) {
		
		window.setVisible(isVisible); // Recall the method setVisible of Window
	}
	
	@Override
	public void addNotify() {
		
		super.addNotify();
		startGame();
	}
	
	/**
	 * Start the main panel's thread
	 */
	
	private void startGame() {
		
		if (animator == null || !isRunning) {
			animator = new Thread(this);
			animator.start();
		}
	}
	
	public void stopGame() {
		
		isRunning = false; // close the program
	}
	
	/**
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
	
	private void addNullSlot() {
		
		int length = comp_added.length;
		
		AccessPanel[] comp_prov = new AccessPanel[length + 1];
		
		for (int i = 0; i < length; i++)
			comp_prov[i] = comp_added[i];
		
		length++;
		
		comp_added = new AccessPanel[length];
		
		for (int i = 0; i < length; i++)
			comp_added[i] = comp_prov[i];
	}
	
	private void removeNullSlots() {
		
		int countNull = 0;
		
		int length = comp_added.length;
		
		for (int i = 0; i < length; i++) {
			if (comp_added[i] == null)
				countNull++;
		}
		
		length -= countNull;
		
		AccessPanel[] comp_prov = new AccessPanel[length];
		
		int j = 0;
		int w = 0;
		while (w < length) {
			if (comp_added[j] == null)
				j++;
			comp_prov[w] = comp_added[j];
			j++;
			w++;
		}
		
		comp_added = new AccessPanel[length];
		
		for (int i = 0; i < length; i++)
			comp_added[i] = comp_prov[i];
	}
	
	/**
	 * Add a component to the comp_added array and sort it
	 */

	public void add(AccessPanel component) {
		
		addNullSlot();
		
		comp_added[comp_added.length - 1] = component;
		
		sort();
	}
	
	/**
	 * Remove a component from the comp_added array
	 * without making null slots (the array length apadt
	 * on the component number)
	 */
	
	public void remove(AccessPanel component) {
		
		for (int i = 0; i < comp_added.length; i++) {
			if (comp_added[i] == component)
				comp_added[i] = null;
		}
	}
	
	/**
	 * Set the component zLevel to 0 and
	 * adapt the width and the height to
	 * the main panel
	 * Set it as Background of the main panel
	 */

	public void setBackground(AccessPanel component) {
		
		component.setZLevel(0);
		component.setBounds(0, 0, Window.width, Window.height);
		//System.out.println(this.getWidth() + "  " + this.getHeight());
		this.add(component);
	}
	
	/**
	 * Override this method to write tha gameLoop code
	 */
	
	public void gameLoop() {
		throw new StackOverflowError("Error: You must override the gameLoop method");
	}
	
	/**
	 * Update the animations if gameOver is false
	 */
	
	private void update() {
		
		if (!gameOver) 
			gameLoop();
	}
	
	/**
	 * Create the secondo buffer (Image) of the main panel
	 */
	
	private void gameRender() {
		
		if (buffer == null) {
			buffer = createImage(Window.width, Window.height);
			if (buffer == null) {
				System.out.println("Buffer is null");
				return;
			}
		} else {
			bufferGraphics = (Graphics2D) buffer.getGraphics(); // Graphics component of the second buffer
		}
		
		for (int i = 0; i < comp_added.length; i++) {
			if (comp_added[i] !=  null)
				comp_added[i].paint(bufferGraphics); // Paint the components
			else {
				removeNullSlots();
				return;
			}
		}
	}
	
	/**
	 * Paint the second buffer on the first one (the real main panel)
	 */
	
	private void paintScreen() {
		
		try {
			
			g = (Graphics2D) this.getGraphics();
		
			if ((buffer != null) && (g != null))
				g.drawImage(buffer, 0, 0, Window.width, Window.height, null); // Draw the buffer Image (second buffer)
		
			Toolkit.getDefaultToolkit().sync(); // Update the display
			g.dispose();
			
		} catch (Exception e) {
			
			System.out.println("Graphics context error: " + e);
		}
	}
	
	/**
	 * Run the program entering in the animations loop
	 */

	@Override
	public void run() {
		
		long beforeTime, timeDiff, afterTime; // variables to calculate the real timeSleep
		int period;					// The real timeSleep
		
		beforeTime = System.currentTimeMillis();
		
		isRunning = true;
		while(isRunning) {
			
			update(); 		// Update the animations' status
			gameRender();	// Update the graphics components in the second buffer
			paintScreen(); 	// update the main panel
			
			timeDiff = System.currentTimeMillis() - beforeTime;
			period = (int)(sleepTime - timeDiff);
			
			try {
				Thread.sleep(period); // The real sleepTime is based on the computer elaboration time
			} catch (InterruptedException e) {
				beforeTime = System.currentTimeMillis();
			} catch (IllegalArgumentException e) {
				beforeTime = System.currentTimeMillis();
			}
		}
		
		System.exit(0);
	}

}
