package controller;

import java.util.ArrayList;
import java.util.List;

import model.Card;

public class PlayerDraw {

	private List<Card> playerHand = new ArrayList<Card>();
	private PickCard pickCard = new PickCard();
	public PlayerDraw() {
		
	}

	public void DrawCard() {
		this.playerHand.add(pickCard.pickedCard());	
	}
	
	public List<Card> getPlayerHand(){
		return this.playerHand;
	}
}
