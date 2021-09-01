package view;

import java.util.List;
import javax.swing.JPanel;

import model.CardImpl;
import model.State;

public interface View {
	
	void draw(int scoreDealer,int scorePlayer,List<CardImpl> playerHand,List<CardImpl> dealerHand,State state, int balance, int bet);
	
	void switchPanel(JPanel windows);
	
	
	
}
