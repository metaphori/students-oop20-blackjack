package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Card;
import model.Suit;
import model.Values;
import utility.ImageLoader;

public class GameView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private View view;
    JLabel title;
    JPanel table,dealerPanel,playerPanel;
    JLabel playerCardLabel[] = new JLabel[6];
	JLabel dealerCardLabel[] = new JLabel[6];
    JLabel playerScore, dealerScore;
    ImageLoader image = new ImageLoader();
    JTextArea messageText;
    JPanel buttonPanel = new JPanel();
	JButton button[] = new JButton[6];
	int cardWidth = 150;
	int cardHeight = 213;
	//Suit suit;
	//Values values;
    
    
	public GameView(View view) {
		super();
		image.findImages();
		this.view = view;
		this.setBounds(0, 0, 1200, 900);
		this.setOpaque(false);
		this.setLayout(null);
		
		/*this.title = new JLabel("BlackJack");
		this.title.setFont(new Font("Book Antiqua", Font.PLAIN,90));
		this.title.setForeground(Color.YELLOW);
		this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(title);*/
		
		table = new JPanel();
		table.setBackground(Color.DARK_GRAY);
		table.setBounds(50,50,850,600);
		table.setLayout(null);
		table.setVisible(true);
		
		
		dealerPanel = new JPanel();
		dealerPanel.setBounds(100,120,cardWidth*5,cardHeight);
		dealerPanel.setBackground(null);
		dealerPanel.setOpaque(false);
		dealerPanel.setLayout(new GridLayout(1,5));
		dealerPanel.setVisible(true);
		this.add(dealerPanel);
				
		playerPanel = new JPanel();
		playerPanel.setBounds(100,370,cardWidth*5,cardHeight);
		playerPanel.setOpaque(false);
		playerPanel.setLayout(new GridLayout(1,5));
		playerPanel.setVisible(true);
		this.add(playerPanel);

		for(int i = 1; i < 6; i++) {
			playerCardLabel[i] = new JLabel();
			playerCardLabel[i].setVisible(true);
			Card card = new Card(Suit.spades,Values.one);
			if(!this.image.getSpades().isEmpty()) {
				//System.out.print("c'è");
				//ImageIcon image1 = new ImageIcon();
				//image1 = this.image.GetSpades().get(card);
				//for (Card key : this.image.getSpades().keySet()) {
			      // ImageIcon value =  this.image.getSpades().get(key);
			        //playerCardLabel[i].setIcon(value);
			    //}
				playerCardLabel[i].setIcon(this.setImage());
			}
			//playerCardLabel[i].setIcon(this.image.GetSpades().entr
			//playerCardLabel[i].setIcon(this.image.getFront().get(0));
			playerPanel.add(playerCardLabel[i]);
		}
		for(int i = 1; i < 6; i++) {
			dealerCardLabel[i] = new JLabel();
			dealerCardLabel[i].setVisible(true);
			dealerCardLabel[i].setIcon(this.image.getFront());
			dealerPanel.add(dealerCardLabel[i]);
		}	
		
		dealerScore = new JLabel();
		dealerScore.setBounds(50,10,200,50);
		dealerScore.setForeground(Color.white);
		dealerScore.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		dealerScore.setText("Dealer : 0");
		table.add(dealerScore);
		
		playerScore = new JLabel();
		playerScore.setBounds(50,540,200,50);
		playerScore.setForeground(Color.white);
		playerScore.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		playerScore.setText("You : 0");
		table.add(playerScore);
	
		this.add(table,BorderLayout.CENTER);
		
		messageText = new JTextArea();
		messageText.setBounds(230,680,720,100);
		messageText.setBackground(null);
		messageText.setForeground(Color.DARK_GRAY);
		messageText.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		messageText.setEditable(false);
		messageText.setText("Hai vinto");
		this.add(messageText);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(920,340,200,300);
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
			//button[i].addActionListener(game.aHandler);
			button[i].setActionCommand(""+i);
			button[i].setVisible(true);
			buttonPanel.add(button[i]);
		}		
	}
	public ImageIcon setImage() {
		ImageIcon value = null;
		for (Card key : this.image.getDiamonds().keySet()) {
	        value =  this.image.getDiamonds().get(key);
	        return value;
	    }
		return value;
	}

}
