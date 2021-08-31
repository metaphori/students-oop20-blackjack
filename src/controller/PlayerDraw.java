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
		if(card.getValues() == Values.one && getPointPlayer()+11 < 22) {
			card.setAceOrNot(Values.getValue(14));
			this.playerHand.add(card);
		}else if(card.getValues() == Values.one && getPointPlayer()+11 > 22 && this.playerHand.size() < 6) {
			card.setAceOrNot(Values.getValue(1));	
			this.playerHand.add(card);
			this.setNoAce();
		}else{
			this.playerHand.add(card);
			if(getPointPlayer() > 21) {
				this.setNoAce();
			}
		}	
	}
	
	public List<Card> getPlayerHand(){
		return this.playerHand;
	}
	
	public int getPlayerNumberCard() {
		return this.playerHand.size();
	}
	
	public void ResetPlayer() {
		this.playerHand.clear();
	}
	
	public int getPointPlayer() {
		
		this.pointplayer = 0;
		for(Card carta:this.playerHand) {
			this.pointplayer += Values.getValues(carta.getValues());
		}
		return this.pointplayer;
	}
	
	private void setNoAce() {
		List<Card> playerHandtemp = new ArrayList<Card>();
		int countace = 1;
		for(Card carta: this.playerHand) {
//			if(carta.getValues() == Values.ace && this.playerHand.size() >= 3 && countace ==1 ||countace==2) {
//				carta.setAceOrNot(Values.getValue(1));
//				playerHandtemp.add(carta);
//				countace++;
//			}else 
				if(carta.getValues() == Values.ace && countace == 3 || countace == 5) {
				carta.setAceOrNot(Values.getValue(1));
				playerHandtemp.add(carta);
				countace++;
			}else {
				playerHandtemp.add(carta);
			}
			countace++;
		}
		this.playerHand.clear();
		this.playerHand = playerHandtemp;
	}
	
	
}
