package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewImpl extends JFrame implements View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int SCREEN_WIDTH =1200;
	public static final int SCREEN_HEIGHT =900;

	private final JPanel main; 
	private final CardLayout card = new CardLayout();
	private final List<String> Cards;
	
	public ViewImpl() {
		super();
		this.main = new JPanel();
		this.main.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.Cards = new ArrayList<>();
		this.setTitle("BLACKJACK");
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("icon.jpg")).getImage());
		this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(true);
		this.getContentPane().setBackground(new Color(0,81,0));
		this.add(main);                    
		this.switchPanel(new MenuView(this));
		//this.pack();
		//this.setLocationRelativeTo(null);
		this.setVisible(true);
	}


	@Override
	public void draw(JLabel[] playerCardLabel, JLabel[] dealerCardLabel) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void resetToMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void switchPanel(JPanel windows) {
		// TODO Auto-generated method stub
		this.setLayout(new BorderLayout());
		this.add(windows,BorderLayout.CENTER);
		
		
		
		
	}

}
