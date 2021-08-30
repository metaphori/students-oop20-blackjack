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
import utility.ImageLoader;

public class ViewImpl extends JFrame implements View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	Game game;
	GameView gameV;
	ImageLoader image;

	//private final JPanel main; 
	//private final CardLayout card = new CardLayout();
	//private final List<String> Cards;
	
	public ViewImpl(Game game,ImageLoader image) {
		
		super();
		this.image = image;
		this.gameV = new GameView(this, game,image);
		this.game = game;
		this.setPreferredSize(new Dimension(this.chooseWidthDimension(),this.chooseHeightDimension()));
		this.setTitle("BLACKJACK");
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("icon.jpg")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0,81,0));                   
		this.switchPanel(new MenuView(this,this.game,this.gameV,image));
		this.pack();
		this.setLocationRelativeTo(null);
	}



	private int chooseWidthDimension() {
		int width = SCREEN_WIDTH;
		if(width<=1280) {
			return width;
		}
		 return(width/(3)*2);
	}
	
	private int chooseHeightDimension() {
		int height = SCREEN_HEIGHT;
		if(height<=720) {
			return height;
		}
		 return(height/(3)*2);
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
	public void draw(int scoreDealer, int scorePlayer, List<Card> playerHand, List<Card> dealerHand, State state, int balance, int bet) {
		// TODO Auto-generated method stub
		this.gameV.render(scoreDealer, scorePlayer, playerHand, dealerHand, state, balance, bet);
	}




}
