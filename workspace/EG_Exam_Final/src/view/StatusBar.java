package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class StatusBar extends JPanel{
	public StatusBar() {
		JTextArea jt = new JTextArea("Status Bar");
		add(jt);
	}
}
