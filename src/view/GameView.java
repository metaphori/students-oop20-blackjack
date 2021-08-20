package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private View view;
    JLabel title;
    
	public GameView(View view) {
		this.view = view;
		
		this.setBounds(0, 0, 1200, 600);
		this.setOpaque(false);
		
		this.title = new JLabel("BlackJack");
		this.title.setFont(new Font("Book Antiqua", Font.PLAIN,60));
		this.title.setForeground(Color.YELLOW);
		this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(title);
	}

}
