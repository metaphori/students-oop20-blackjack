package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Game;
import model.Card;
import model.State;

public class ViewImpl extends JFrame implements View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width / 4*3;
	public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height /6*5;
	Game game;
	GameView gameV;

	//private final JPanel main; 
	//private final CardLayout card = new CardLayout();
	//private final List<String> Cards;
	
	public ViewImpl(Game game) {
		super();
		this.gameV = new GameView(this, game);
		this.game = game;
		this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		this.setTitle("BLACKJACK");
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("icon.jpg")).getImage());
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0,81,0));
		                    
		this.switchPanel(new MenuView(this,this.game,this.gameV));
		//this.pack();
		//this.setLocationRelativeTo(null);
		
	}




	@Override
	public void resetToMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void switchPanel(JPanel windows) {
		// TODO Auto-generated method stub
	
		this.getContentPane().removeAll();
		this.setLayout(new BorderLayout());
		this.add(windows);
		this.setVisible(true);
		
		
		
		
	}




	@Override
	public void draw(int scoreDealer, int scorePlayer, List<Card> playerHand, List<Card> dealerHand, State state) {
		// TODO Auto-generated method stub
		this.gameV.render(scoreDealer, scorePlayer, playerHand, dealerHand, state);
	}




}
