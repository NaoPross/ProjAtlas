package org.enginetest;

import java.awt.Color;
import java.awt.Dimension;

import org.atlasengine.*;

public class Game {
	public static void main(String[] args) {
		Window w = new Window("Engine Test Game", new Dimension(800, 800));
		
		BuildPanel mainPanel = new BuildPanel();
		mainPanel.setSize(w.getWidth(), w.getHeight());
		//mainPanel.setBackground("C:\\Users\\Nicola\\Documents\\Documenti_raffa\\Esperimenti java\\Numeri casuali\\Linear_congruential.png");
		mainPanel.setBackground(Color.BLUE);
		
		BuildPanel second = new BuildPanel(30, 30, 100, 300);
		second.setBackground(Color.RED);
		second.hierarchy = 1;
		
		BuildPanel third = new BuildPanel(60, 60, 200, 50);
		third.setBackground(Color.YELLOW);
		third.hierarchy = 2;
		
		mainPanel.addComponent(second);
		mainPanel.addComponent(third);
		
		mainPanel.update();
		
		w.add(mainPanel);
		
		w.setVisible(true);
	}
}
