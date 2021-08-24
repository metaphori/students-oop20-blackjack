package view;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Card;

public interface View {
	
	void draw(int scoreDealer,int scorePlayer,List<Card> playerHand,List<Card> dealerHand);
	
	void switchPanel(JPanel windows);
	
	void resetToMenu();
	
	
}
