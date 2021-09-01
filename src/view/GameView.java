package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.Game;
import model.Card;
import model.State;
import model.Suit;
import utility.ImageLoader;

public class GameView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private View view;
    private JLabel title;
    private JPanel table,dealerPanel,playerPanel;
    private JLabel playerCardLabel[] = new JLabel[6];
    private JLabel dealerCardLabel[] = new JLabel[6];
	private JLabel playerScore, dealerScore;
    private ImageLoader image;
    private JTextArea messageText;
    private JPanel buttonPanel = new JPanel();
    private JButton button[] = new JButton[6];
	private JButton buttonChip[] = new JButton[4];
	private int cardWidth = 150;
	private int cardHeight = 213;
	private Game game;
	private JPanel chips;
	private JLabel balance, bet;
    
	public GameView(View view,Game game,ImageLoader image) {
		super();
		this.game = game;
		this.image = image;
		this.view = view;
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
			dealerPanel.add(dealerCardLabel[i]);
		}	
		this.setTable();
		
		dealerScore = new JLabel();
		dealerScore.setBounds(50,5,200,30);
		dealerScore.setForeground(Color.white);
		dealerScore.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		dealerScore.setText("Dealer : 0");
		
		table.add(dealerScore);
		
		playerScore = new JLabel();
		playerScore.setBounds(50,490,200,30);
		playerScore.setForeground(Color.white);
		playerScore.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		playerScore.setText("Giocatore : 0");
		table.add(playerScore);
	
		this.add(table,BorderLayout.CENTER);
		
		messageText = new JTextArea();
		messageText.setBounds(100,560,670,80);
		messageText.setBackground(null);
		messageText.setForeground(Color.white);
		messageText.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		messageText.setEditable(false);
		messageText.setText("Fai la tua puntatata ------------>");
		messageText.setOpaque(false);
		this.add(messageText);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(920,150,200,300);
		buttonPanel.setBackground(null);
		buttonPanel.setLayout(new GridLayout(6,1));
		buttonPanel.setOpaque(false);
		this.add(buttonPanel);
		
		for(int i = 0; i < 6; i++) {
			button[i] = new JButton();
			button[i].setBackground(null);
			button[i].setForeground(Color.white);
			button[i].setFocusPainted(false);
			button[i].setContentAreaFilled(false);
			button[i].setFont(new Font("Times New Roman", Font.PLAIN, 42));
			button[i].addActionListener(game.actionHandler);
			button[i].setActionCommand(""+i);
			button[i].setVisible(false);
			buttonPanel.add(button[i]);
		}
		
		
		
		this.chips = new JPanel();
		this.chips.setLayout(new GridLayout(2,2));
		this.chips.setBounds(850,400,400,270);
		this.chips.setBackground(new Color(0,81,0));
		for(int i = 0; i < 3; i++) {
			buttonChip[i] = new JButton();
			buttonChip[i].setVisible(true);
			buttonChip[i].setBackground(new Color(0,81,0));
			buttonChip[i].setBorder(null);
			buttonChip[i].setFocusPainted(false);
			buttonChip[i].addActionListener(game.actionHandler);
			buttonChip[i].setActionCommand("chips"+i);
			buttonChip[i].setIcon(this.image.getChipImage()[i]);
			this.chips.add(buttonChip[i]);
		}
		
		this.balance = new JLabel();
		this.balance.setForeground(Color.white);
		this.balance.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		this.balance.setText("Saldo:1000");
		this.chips.add(this.balance);
		
		this.bet = new JLabel();
		this.bet.setForeground(Color.white);
		this.bet.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		this.bet.setText("Puntata:0");
		this.chips.add(this.bet);
		
		this.add(this.chips);
	}
	private void setTable() {
		//set Card
		for(int i = 1;i<3;i++) {
			playerCardLabel[i].setIcon(this.image.getFront());
			playerCardLabel[i].setVisible(true);
			dealerCardLabel[i].setIcon(this.image.getFront());
			dealerCardLabel[i].setVisible(true);
		}
	}
	public void setImage(List<Card> playerHand,List<Card> dealerHand) {
		int cont =0;
		for(Card c : playerHand) {
			cont++;
			if(c.getSuit() == Suit.spades) {
				for(Card ca: this.image.getSpades().keySet()) {
					if(ca.getValues() == c.getValues()) {
						this.playerCardLabel[cont].setIcon(this.image.getSpades().get(ca));
						this.playerCardLabel[cont].setVisible(true);
					}
				}
			}else if(c.getSuit() == Suit.clubs) {
				for(Card ca: this.image.getClubs().keySet()) {
					if(ca.getValues() == c.getValues()) {
						this.playerCardLabel[cont].setIcon(this.image.getClubs().get(ca));
						this.playerCardLabel[cont].setVisible(true);
					}
				}
			}else if(c.getSuit() == Suit.diamods) {
				for(Card ca: this.image.getDiamonds().keySet()) {
					if(ca.getValues() == c.getValues()) {
						this.playerCardLabel[cont].setIcon(this.image.getDiamonds().get(ca));
						this.playerCardLabel[cont].setVisible(true);
					}
				}
			}else {
				for(Card ca: this.image.getHeart().keySet()) {
					if(ca.getValues() == c.getValues()) {
						this.playerCardLabel[cont].setIcon(this.image.getHeart().get(ca));
						this.playerCardLabel[cont].setVisible(true);
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
						this.dealerCardLabel[carte].setIcon(this.image.getSpades().get(ca));
						this.dealerCardLabel[carte].setVisible(true);
					}
				}
			}else if(c.getSuit() == Suit.clubs) {
				for(Card ca: this.image.getClubs().keySet()) {
					if(ca.getValues() == c.getValues()) {
						this.dealerCardLabel[carte].setIcon(this.image.getClubs().get(ca));
						this.dealerCardLabel[carte].setVisible(true);
					}
				}
			}else if(c.getSuit() == Suit.diamods) {
				for(Card ca: this.image.getDiamonds().keySet()) {
					if(ca.getValues() == c.getValues()) {
						this.dealerCardLabel[carte].setIcon(this.image.getDiamonds().get(ca));
						this.dealerCardLabel[carte].setVisible(true);
					}
				}
			}else {
				for(Card ca: this.image.getHeart().keySet()) {
					if(ca.getValues() == c.getValues()) {
						this.dealerCardLabel[carte].setIcon(this.image.getHeart().get(ca));
						this.dealerCardLabel[carte].setVisible(true);
					}
				}
			}
		}
	}
	public void render(int scoreDealer, int scorePlayer, List<Card> playerHand, List<Card> dealerHand, State state, int balance, int bet) {
		switch(state) {
		case win:
			this.resetGame();
			this.playerScore.setText("Giocatore: "+String.valueOf(scorePlayer));
			this.dealerScore.setText("Dealer: "+ String.valueOf(scoreDealer));
			this.setImage(playerHand,dealerHand);
			this.button[0].setVisible(true);
			this.button[0].setText("Rigioca");
			this.messageText.setText("Hai vinto!");
			this.balance.setText("Saldo:"+String.valueOf(balance));
			break;
		case lose:
			this.resetGame();
			
			this.playerScore.setText("Giocatore: "+String.valueOf(scorePlayer));
			this.dealerScore.setText("Dealer: "+ String.valueOf(scoreDealer));
			this.setImage(playerHand,dealerHand);
			this.button[0].setVisible(true);
			this.button[0].setText("Rigioca");
			this.messageText.setText("Hai Perso!");
			this.balance.setText("Saldo:"+String.valueOf(balance));
			break;
		case natural:
			this.resetGame();
			this.playerScore.setText("you: "+String.valueOf(scorePlayer));
			this.dealerScore.setText("Dealer: "+ String.valueOf(scoreDealer));
			this.setImage(playerHand,dealerHand);
			this.button[0].setVisible(true);
			this.button[0].setText("Rigioca");
			this.messageText.setText("Hai fatto blackJack!");
			this.balance.setText("Saldo:"+String.valueOf(balance));
			break;
		case playerTurn:
			this.resetGame();
			this.playerScore.setText("Giocatore: "+String.valueOf(scorePlayer));
			this.dealerScore.setText("Dealer: ?");
			this.setImage(playerHand,dealerHand);
			this.dealerCardLabel[2].setIcon(this.image.getFront());
			this.messageText.setText("Vuoi pescare?");
			this.button[1].setVisible(true);
			this.button[1].setText("Pesca");
			this.button[2].setVisible(true);
			this.button[2].setText("Stai");
			this.balance.setText("Saldo:"+String.valueOf(balance));
			break;
		case dealerTurn:
			this.resetGame();
			this.playerScore.setText("Giocatore: "+String.valueOf(scorePlayer));
			this.dealerScore.setText("Dealer: "+ String.valueOf(scoreDealer));
			this.setImage(playerHand,dealerHand);
			break;
		case drow:	
			this.resetGame();
			this.playerScore.setText("Giocatore: "+String.valueOf(scorePlayer));
			this.dealerScore.setText("Dealer: "+ String.valueOf(scoreDealer));
			this.setImage(playerHand,dealerHand);
			this.messageText.setText("pareggio");
			this.button[0].setVisible(true);
			this.button[0].setText("Rigioca");
			this.balance.setText("Saldo:"+String.valueOf(balance));
			break;
		case broke:
			this.resetGame();
			this.playerScore.setText("Giocatore: "+String.valueOf(scorePlayer));
			this.dealerScore.setText("Dealer: ?");
			this.setImage(playerHand,dealerHand);
			this.messageText.setText("Hai Perso!");		
		
			int n = JOptionPane.showConfirmDialog(null, "Saldo esaurito, vuoi rigiocare?", "ATTENZIONE",
			JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(n == JOptionPane.YES_OPTION) {
				this.game.playAgain();
			}else {
				System.exit(0);
			}
			
			break;
		case nobet:
			this.resetGame();
			this.setTable();
			this.playerScore.setText("Giocatore: "+String.valueOf(scorePlayer));
			this.dealerScore.setText("Dealer: "+ String.valueOf(scoreDealer));
			messageText.setText("non puoi puntare piu di quello che hai");
			this.button[3].setVisible(true);
			this.button[3].setText("Gioca");
			this.balance.setText("Saldo:"+String.valueOf(balance));
			this.bet.setText(String.valueOf("Puntata:"+bet));
			for(int i =0; i<3; i++) {
				this.buttonChip[i].setEnabled(false);
			}
			
			break;
		default:
			this.resetGame();
			this.setTable();
			this.playerScore.setText("Giocatore: "+String.valueOf(scorePlayer));
			this.dealerScore.setText("Dealer: ?");
			messageText.setText("Fai la tua puntatata");
			this.button[3].setVisible(true);
			this.button[3].setText("Gioca");
			this.balance.setText("Saldo:"+String.valueOf(balance));
			this.bet.setText(String.valueOf("Puntata:"+bet));
			for(int i =0; i<3; i++) {
				this.buttonChip[i].setEnabled(true);
			}
			break;
			
		}
	}
	private void resetGame() {

		for(int i = 0; i < 6; i++) {
			this.button[i].setVisible(false);
		}
		for(int j = 1; j < 6; j++) {
			this.playerCardLabel[j].setVisible(false);
			this.dealerCardLabel[j].setVisible(false);
		}
	}
}
