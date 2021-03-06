package raffa.atlasengine.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import raffa.atlasengine.sprite.Sprite;
import raffa.atlasengine.support.ArrayComponent;

public class MainPanel extends JPanel implements Runnable {
	
	/**
	 * Create a new Thread of the main panel int he window
	 */
	
	private Graphics2D g, bufferGraphics; // Instance the graphics component that draws the others
	private Sprite[] comp_added; // Array of all the components added
	private Sprite background;
	
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
	
	public static volatile long counter; // Count the gameLoop repetitions
	
	/**
	 * Create the double buffered panel the is the content of the window
	 * On this one all the graphics components are written
	 * This is the only serializable panel
	 */
	
	public MainPanel(String title, int x, int y, int width, int height) {
		
		super(null, true); 		// layout = null, doubleBuffer = true
		super.setBackground(null);
		comp_added = new Sprite[0];
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
	 * Set the component zLevel to 0 and
	 * adapt the width and the height to
	 * the main panel
	 * Set it as Background of the main panel
	 */

	public void setBackground(Sprite component) {
		
		component.setBounds(0, 0, Window.width, Window.height);
		this.background = component;
	}
	
	@Override
	public void setBackground(Color color) {
		
		
		Sprite temp = new Sprite();
		Graphics2D g = temp.getGraphics();
		g.setColor(color);
		g.fillRect(0, 0, Sprite.DEFAULT_SIZE, Sprite.DEFAULT_SIZE);
		setBackground(temp);
		
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
		
		if (background != null)
			background.paint(bufferGraphics);
		
		for (int i = 0; i < comp_added.length; i++) {
			if (comp_added[i] !=  null && comp_added[i].visible)
				comp_added[i].paint(bufferGraphics); // Paint the components
			else {
				comp_added = ArrayComponent.removeNullSlots(comp_added);
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
			
			counter++;
		}
		
		System.exit(0);
	}

}
