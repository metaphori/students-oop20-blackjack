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
		this.playerHand.add(pickCard.pickedCard());	
		
	}
	
	public List<Card> getPlayerHand(){
		return this.playerHand;
	}
	
	public int getPlayerNumberCard() {
		return this.playerHand.size();
	}
	
	public int getPointPlayer() {
		
		for(Card carta:this.playerHand) {
			this.pointplayer += Values.getValues(carta.getValues());
		}
		return this.pointplayer;
		
	}
}
