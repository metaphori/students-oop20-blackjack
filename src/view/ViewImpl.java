package view;

import java.awt.Color;
import java.awt.Dimension;

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
	
	public ViewImpl() {
		super();
		this.main = new JPanel();
		this.main.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setTitle("BLACKJACK");
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("icon.jpg")).getImage());
		this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(true);
		this.getContentPane().setBackground(new Color(0,81,0));
		this.add(main);                    
		this.switchPanel(new MenuView());
		/*this.pack();
		this.setLocationRelativeTo(null);*/
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
		this.getContentPane().removeAll();
		this.getContentPane().invalidate();
		this.getContentPane().add(windows);
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		
		
	}

}
