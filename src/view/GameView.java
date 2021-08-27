package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.Game;
import model.Card;
import model.State;
import model.Suit;
import model.Values;
import utility.ImageLoader;

public class GameView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private View view;
    JLabel title;
    JPanel table,dealerPanel,playerPanel;
    JLabel playerCardLabel[] = new JLabel[6];
	JLabel dealerCardLabel[] = new JLabel[6];
    JLabel playerScore, dealerScore;
    ImageLoader image;
    JTextArea messageText;
    JPanel buttonPanel = new JPanel();
	JButton button[] = new JButton[6];
	int cardWidth = 150;
	int cardHeight = 213;
	private Game game;
	//Suit suit;
	//Values values;
    
    
	public GameView(View view,Game game,ImageLoader image) {
		super();
		this.game = game;
		this.image = image;
		this.view = view;
		//this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));;
		this.setOpaque(false);
		this.setLayout(null);
		table = new JPanel();
		table.setBackground(Color.DARK_GRAY);
		table.setBounds(25,25,800,525);
		table.setLayout(null);
		table.setVisible(true);
		
		
		dealerPanel = new JPanel();
		dealerPanel.setBounds(55,70,cardWidth*5,cardHeight);
		dealerPanel.setBackground(null);
		dealerPanel.setOpaque(false);
		dealerPanel.setLayout(new GridLayout(1,5));
		dealerPanel.setVisible(true);
		this.add(dealerPanel);
				
		playerPanel = new JPanel();
		playerPanel.setBounds(55,300,cardWidth*5,cardHeight);
		playerPanel.setOpaque(false);
		playerPanel.setLayout(new GridLayout(1,5));
		playerPanel.setVisible(true);
		this.add(playerPanel);

		for(int i = 1; i < 6; i++) {
			playerCardLabel[i] = new JLabel();
			playerCardLabel[i].setVisible(true);
			playerPanel.add(playerCardLabel[i]);
		}
		
		for(int i = 1; i < 6; i++) {
			dealerCardLabel[i] = new JLabel();
			dealerCardLabel[i].setVisible(true);
			//dealerCardLabel[i].setIcon(this.image.getFront());
			dealerPanel.add(dealerCardLabel[i]);
		}	
		
		dealerScore = new JLabel();
		dealerScore.setBounds(50,0,200,50);
		dealerScore.setForeground(Color.white);
		dealerScore.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		dealerScore.setText("Dealer : 0");
		table.add(dealerScore);
		
		playerScore = new JLabel();
		playerScore.setBounds(50,480,200,50);
		playerScore.setForeground(Color.white);
		playerScore.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		playerScore.setText("You : 0");
		table.add(playerScore);
	
		this.add(table,BorderLayout.CENTER);
		
		messageText = new JTextArea();
		messageText.setBounds(100,560,670,80);
		messageText.setBackground(null);
		messageText.setForeground(Color.DARK_GRAY);
		messageText.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		messageText.setEditable(false);
		messageText.setText("Hai vinto");
		this.add(messageText);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(920,250,200,300);
		buttonPanel.setBackground(null);
		buttonPanel.setLayout(new GridLayout(6,1));
		this.add(buttonPanel);
		
		for(int i = 0; i < 6; i++) {
			button[i] = new JButton();
			button[i].setBackground(null);
			button[i].setForeground(Color.DARK_GRAY);
			button[i].setFocusPainted(false);
			button[i].setBorder(null);
			button[i].setFont(new Font("Times New Roman", Font.PLAIN, 42));
			button[i].addActionListener(game.actionHandler);
			button[i].setActionCommand(""+i);
			button[i].setVisible(false);
			buttonPanel.add(button[i]);
		}		
	}
	public void setImage(List<Card> playerHand,List<Card> dealerHand) {
		int cont =0;
		ImageIcon value = null;
		for(Card c : playerHand) {
			cont++;
			if(c.getSuit() == Suit.spades) {
				for(Card ca: this.image.getSpades().keySet()) {
					if(ca.getValues() == c.getValues()) {
						//System.out.print("funzia");
						//value = this.image.getSpades().get(ca);
						this.playerCardLabel[cont].setIcon(this.image.getSpades().get(ca));
					}
				}
			}else if(c.getSuit() == Suit.clubs) {
				for(Card ca: this.image.getClubs().keySet()) {
					if(ca.getValues() == c.getValues()) {
						//System.out.print("funzia");
						this.playerCardLabel[cont].setIcon(this.image.getClubs().get(ca));
					}
				}
			}else if(c.getSuit() == Suit.diamods) {
				for(Card ca: this.image.getDiamonds().keySet()) {
					if(ca.getValues() == c.getValues()) {
						//System.out.print("funzia");
						this.playerCardLabel[cont].setIcon(this.image.getDiamonds().get(ca));
					}
				}
			}else {
				for(Card ca: this.image.getHeart().keySet()) {
					if(ca.getValues() == c.getValues()) {
						//System.out.print("funzia");
						this.playerCardLabel[cont].setIcon(this.image.getHeart().get(ca));
					}
				}
			}
			
		}
			
			
			
		int carte = 0;
		for(Card c : dealerHand) {
			carte++;
			if(c.getSuit() == Suit.spades) {
				for(Card ca: this.image.getSpades().keySet()) {
					if(ca.getValues() == c.getValues()) {
						//System.out.print("funzia");
						//value = this.image.getSpades().get(ca);
						this.dealerCardLabel[carte].setIcon(this.image.getSpades().get(ca));
					}
				}
			}else if(c.getSuit() == Suit.clubs) {
				for(Card ca: this.image.getClubs().keySet()) {
					if(ca.getValues() == c.getValues()) {
						//System.out.print("funzia");
						this.dealerCardLabel[carte].setIcon(this.image.getClubs().get(ca));
					}
				}
			}else if(c.getSuit() == Suit.diamods) {
				for(Card ca: this.image.getDiamonds().keySet()) {
					if(ca.getValues() == c.getValues()) {
						//System.out.print("funzia");
						this.dealerCardLabel[carte].setIcon(this.image.getDiamonds().get(ca));
					}
				}
			}else {
				for(Card ca: this.image.getHeart().keySet()) {
					if(ca.getValues() == c.getValues()) {
						//System.out.print("funzia");
						this.dealerCardLabel[carte].setIcon(this.image.getHeart().get(ca));
					}
				}
			}
		}
	}
	public void render(int scoreDealer, int scorePlayer, List<Card> playerHand, List<Card> dealerHand, State state) {
		switch(state) {
		case win:
		
		case lose:
			
		case natural:
			this.resetButton();
			this.setImage(playerHand,dealerHand);
			this.playerScore.setText("you: "+String.valueOf(scorePlayer));
			this.dealerScore.setText("Dealer: "+ String.valueOf(scoreDealer));
			//this.dealerCardLabel[2].setIcon(this.image.getFront());
			this.button[0].setVisible(true);
			this.button[0].setText("Rigioca");
			this.messageText.setText("Hai fatto blackJack!");
			break;
		case playerTurn:
			this.setImage(playerHand,dealerHand);
			this.playerScore.setText("you: "+String.valueOf(scorePlayer));
			this.dealerScore.setText("Dealer: ?");
			this.dealerCardLabel[2].setIcon(this.image.getFront());
			this.messageText.setText("Vuoi pescare?");
			this.button[1].setVisible(true);
			this.button[1].setText("Pesca");
			this.button[2].setVisible(true);
			this.button[2].setText("Stai");
			break;
		case dealerTurn:
			this.resetButton();
			this.setImage(playerHand,dealerHand);
			this.playerScore.setText("you: "+String.valueOf(scorePlayer));
			this.dealerScore.setText("Dealer: "+ String.valueOf(scoreDealer));
		case drow:	
			
		default:
			this.setImage(playerHand,dealerHand);
			this.playerScore.setText("you: "+String.valueOf(scorePlayer));
			this.dealerScore.setText("Dealer: ?");
			this.dealerCardLabel[2].setIcon(this.image.getFront());
			this.messageText.setText("Vuoi pescare?");
			this.button[1].setVisible(true);
			this.button[1].setText("Pesca");
			this.button[2].setVisible(true);
			this.button[2].setText("Stai");
			
			
		}
	}
	private void resetButton() {
		for(int i = 0; i < 6; i++) {
			this.button[i].setVisible(false);
		}
	}
}
