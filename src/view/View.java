package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Card;
import model.State;

public interface View {
	
	void draw(int scoreDealer,int scorePlayer,List<Card> playerHand,List<Card> dealerHand,State state, int balance, int bet);
	
	void switchPanel(JPanel windows);
	
	void resetToMenu();
	
	
}
