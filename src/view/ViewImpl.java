package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.Game;
import model.CardImpl;
import model.State;
import utility.ImageLoader;
/**
 * 
 * 
 *
 */
public class ViewImpl extends JFrame implements View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width/(3)*2;
	private static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height/(3)*2;
	private GraphicsDevice gd = this.getGraphicsConfiguration().getDevice();
	
	private Game game;
	private GameView gameV;
	/**
	 * 
	 * @param game
	 * @param image
	 */
	public ViewImpl(Game game,ImageLoader image) {
		
		super();
		this.gameV = new GameView(this, game,image);
		this.game = game;
		this.setPreferredSize(new Dimension(gd.getDefaultConfiguration().getBounds().getSize()));
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("BLACKJACK");
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("icon.jpg")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLayout(null);
		//this.setResizable(false);
		this.getContentPane().setBackground(new Color(0,81,0));                   
		this.switchPanel(new MenuView(this,this.game,this.gameV,image));
		this.pack();
		this.setLocationRelativeTo(null);
	}


/**
 * this method chooses the width based on the screen resolution
 */
	private int chooseWidthDimension() {
		int width = SCREEN_WIDTH;
		if(width<=1280) {
			return width;
		}
		 return(width/(3)*2);
	}
	/**
	 * this method chooses the height based on the screen resolution
	 */
	private int chooseHeightDimension() {
		int height = SCREEN_HEIGHT;
		if(height<=720) {
			return height;
		}
		 return(height/(3)*2);
	}

	@Override
	public void switchPanel(JPanel windows) {
		this.getContentPane().removeAll();
		this.setLayout(new BorderLayout());
		this.add(windows,BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		
	}




	@Override
	public void draw(int scoreDealer, int scorePlayer, List<CardImpl> playerHand, List<CardImpl> dealerHand, State state, int balance, int bet) {
		this.gameV.render(scoreDealer, scorePlayer, playerHand, dealerHand, state, balance, bet);
	}




}
