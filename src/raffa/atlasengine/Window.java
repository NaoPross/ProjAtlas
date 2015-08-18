package raffa.atlasengine;

import java.awt.Dimension;

import javax.swing.JFrame;



public class Window extends JFrame {
	
	/*
	 * Create a window
	 * Default bounds(100, 50, 800, 700)
	 * MainPanel autoinsert in the window
	 */
	
	protected MainPanel panel; // Instance a main window panel

	public Window() {
		
		setLayout(null);
		setBounds(100, 50, 800, 700);
		setPreferredSize(new Dimension(getWidth(), getHeight()));
		
		createMainPanel();
	}
	
	/*
	 * Create a window with title
	 */
	
	public Window(String title) {										
		
		super(title);
		setLayout(null);
		setBounds(100, 50, 800, 700);
		setPreferredSize(new Dimension(getWidth(), getHeight()));
		
		createMainPanel();
	}																	
	
	/*
	 * Create a window with title and a sprite image icon
	 */
	
	public Window(String title, Sprite img) {
		
		super(title);
		setIconImage(img.sprite);
		setLayout(null);
		setBounds(100, 50, 800, 700);
		setPreferredSize(new Dimension(getWidth(), getHeight()));
		
		createMainPanel();
	}
	
	/*
	 * Create a window with title and bounds
	 */
	
	public Window(String title, int x, int y, int width, int height) {
		
		super(title);
		setLayout(null);
		setBounds(x, y, width, height);
		setPreferredSize(new Dimension(getWidth(), getHeight()));
		
		createMainPanel();
	}
	
	/*
	 * Create a window with title, bounds and a sprite image icon
	 */
	
	public Window(String title, int x, int y, int width, int height, Sprite img) {
		
		super(title);
		setIconImage(img.sprite);
		setLayout(null);
		setBounds(x, y, width, height);
		setPreferredSize(new Dimension(getWidth(), getHeight()));
		
		createMainPanel();
	}
	
	/*
	 * Istance the main panel
	 */
	
	public MainPanel createMainPanel() {
		
		panel = new MainPanel();
		panel.setPreferredSize(new Dimension(getWidth(), getHeight()));
		setContentPane(panel);
		return panel;
	}
	
	/*
	 * Return the istance of the main panel
	 */
	
	public MainPanel getMainPanel() {
		
		return panel;
	}
	
	/*
	 * Enter the program in a loop
	 */
	
	public void run() {
		
		while(isActive()) {
			System.out.println("The program is running");
			winMain();
			panel.update();
		}
	}
	
	/*
	 * Override this method to write the game code
	 */
	
	public void winMain() {
		System.out.println("The override doesn't work");
	}

}
