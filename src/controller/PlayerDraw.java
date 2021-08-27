package controller;

import java.util.ArrayList;
import java.util.List;

import model.Card;
import model.Values;

public class PlayerDraw {

	private List<Card> playerHand = new ArrayList<Card>();
	private int pointplayer;
	private PickCard pickCard = new PickCard();
	
	public PlayerDraw() {}

	public void DrawCard() {
		
		Card card = pickCard.pickedCard();
		if(card.getValues() == Values.one) {
			if(getPointPlayer() < 22) {
				card.setAceOrNot(Values.getValue(14));
			}else if(getPointPlayer() > 22 && this.playerHand.size() < 5) {
				card.setAceOrNot(Values.getValue(1));
			}
		}
		this.playerHand.add(card);	
		
	}
	
	public List<Card> getPlayerHand(){
		return this.playerHand;
	}
	
	public int getPlayerNumberCard() {
		return this.playerHand.size();
	}
	
	public int getPointPlayer() {
		
		this.pointplayer = 0;
		for(Card carta:this.playerHand) {
			this.pointplayer += Values.getValues(carta.getValues());
		}
		return this.pointplayer;
	}
	
}
