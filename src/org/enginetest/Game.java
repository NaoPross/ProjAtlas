package org.enginetest;

import java.awt.Color;
import java.awt.Dimension;

import org.atlasengine.*;

public class Game {
	public static void main(String[] args) {
		Window w = new Window("Engine Test Game", new Dimension(800, 800));
		
		BuildPanel mainPanel = new BuildPanel();
		mainPanel.setSize(w.getWidth(), w.getHeight());
		//mainPanel.setBackgroundImage("C:\\Users\\Nicola\\Documents\\Documenti_raffa\\Esperimenti java\\Numeri casuali\\Linear_congruential.png");
		mainPanel.setBackground(Color.BLUE);
		
		BuildPanel red = new BuildPanel(30, 30, 100, 300);
		red.setBackground(Color.RED);
		
		BuildPanel yellow = new BuildPanel(60, 200, 200, 50);
		yellow.setBackground(Color.YELLOW);
		
		BuildPanel green = new BuildPanel(40, 40, 300, 100);
		green.setBackground(Color.GREEN);
		
		mainPanel.add(yellow);
		mainPanel.add(red);
		mainPanel.add(green);
		
		mainPanel.setHierarchy(yellow, 0);
		mainPanel.setHierarchy(red, 1);
		mainPanel.setHierarchy(green, 2);
		
		
		w.add(mainPanel);
		
		w.setVisible(true);
	}
}
