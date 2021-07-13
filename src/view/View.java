package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public interface View {
	
	void draw(JLabel playerCardLabel[],JLabel dealerCardLabel[]);
	
	void switchPanel(JPanel windows);
	
	void resetToMenu();
	
	
}
