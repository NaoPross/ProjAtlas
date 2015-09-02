package raffa.atlasengine;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;


public class Window extends JFrame implements WindowListener, KeyListener {
	
	/*
	 * Create a window
	 */
	
	public static volatile int x, y, width, height;																	
	
	/*
	 * Create a window with title and bounds
	 */
	
	public Window(String title, int x, int y, int width, int height) {
		
		super(title);
		setLayout(null);
		setBounds(x, y, width, height);
		
		Window.x = x;
		Window.y = y;
		Window.width = getWidth();
		Window.height = getHeight();
		
		setPreferredSize(new Dimension(getWidth(), getHeight()));
		setMaximumSize(new Dimension(width, height));
		setResizable(false);
		setFocusable(true);
		addKeyListener(this);
		addWindowListener(this);
	}
	
	/*
	 * Add the window interface 
	 */

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		MainPanel.isRunning = false;  // isRunning is set to false when window is closed
		MainPanel.gameOver = true; // gameOver is set to true when window is closed
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
		MainPanel.gameOver = true; // gameOver is set to true when the window is iconified
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
		MainPanel.gameOver = false; // gameOver is set to false when the window is deiconified
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_F4)
			System.exit(1);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
