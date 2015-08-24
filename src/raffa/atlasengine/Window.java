package raffa.atlasengine;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;


public class Window extends JFrame implements WindowListener {
	
	/*
	 * Create a window
	 * Default bounds(100, 50, 800, 700)
	 * MainPanel autoinsert in the window
	 */
	
	protected MainPanel panel; // Instance a main window panel
	public static int width, height, frameRate;
	public volatile boolean isRunning, gameOver;

	public Window() {
		
		setLayout(null);
		setBounds(100, 50, 800, 700);
		width = getWidth();
		height = getHeight();
		setPreferredSize(new Dimension(getWidth(), getHeight()));
		setMaximumSize(new Dimension(width, height));
		setResizable(false);
		addWindowListener(this);
		
		createMainPanel();
	}
	
	/*
	 * Create a window with title
	 */
	
	public Window(String title) {										
		
		super(title);
		setLayout(null);
		setBounds(100, 50, 800, 700);
		width = getWidth();
		height = getHeight();
		setPreferredSize(new Dimension(getWidth(), getHeight()));
		setMaximumSize(new Dimension(width, height));
		setResizable(false);
		addWindowListener(this);
		
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
		width = getWidth();
		height = getHeight();
		setPreferredSize(new Dimension(getWidth(), getHeight()));
		setMaximumSize(new Dimension(width, height));
		setResizable(false);
		addWindowListener(this);
		
		createMainPanel();
	}
	
	/*
	 * Create a window with title and bounds
	 */
	
	public Window(String title, int x, int y, int width, int height) {
		
		super(title);
		setLayout(null);
		setBounds(x, y, width, height);
		Window.width = getWidth();
		Window.height = getHeight();
		setPreferredSize(new Dimension(getWidth(), getHeight()));
		setMaximumSize(new Dimension(width, height));
		setResizable(false);
		addWindowListener(this);
		
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
		Window.width = getWidth();
		Window.height = getHeight();
		setPreferredSize(new Dimension(getWidth(), getHeight()));
		setMaximumSize(new Dimension(width, height));
		setResizable(false);
		addWindowListener(this);
		
		createMainPanel();
	}
	
	/*
	 * Istance the main panel
	 */
	
	public MainPanel createMainPanel() {
		
		panel = new MainPanel();
		panel.setPreferredSize(new Dimension(getWidth(), getHeight()));
		Window.frameRate = 60;
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
		
		while(isRunning) {
			//System.out.println("The program is running");
			if (!gameOver) 
				gameLoop();
			panel.update();
		}
	}
	
	/*
	 * Override this method to write the game code
	 */
	
	public void gameLoop() {
		throw new StackOverflowError("Error: You must override the gameLoop method");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		isRunning = false;
		gameOver = false;
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
		//gameOver = false;
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
		//gameOver = true;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
