package nao.atlasengine;

import javax.swing.*;

class Window extends JFrame {
		public Window(String title, Dimendion d) {
			setTitle(title);
			setMinimumSize(d);
			setMaximumSize(d);
			setResizable(false);
		}
		
		public void show() {
			
		}
}