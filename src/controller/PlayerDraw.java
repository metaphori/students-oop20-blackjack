package controller;

import java.util.ArrayList;
import java.util.List;

import model.Card;
import model.CardImpl;
import model.Values;

public class PlayerDraw implements Draw{

	private final static int ACE_VALUE = 11;
	private List<CardImpl> playerHand = new ArrayList<CardImpl>();
	private int pointplayer;
	
	private PickCard pickCard = new PickCard();
	
	public PlayerDraw() {
		
	}
 
	@Override
	public void DrawCard() {
		CardImpl card = pickCard.pickedCard();
		if(card.getValues() == Values.one && getPointPlayer()+ ACE_VALUE < 22) {
			card.setAceOrNot(Values.getValue(14));
		}

		this.playerHand.add(card);
		if(getPointPlayer() > 21) {
			this.setNoAce();
		}
	
	}
	
	public List<CardImpl> getPlayerHand(){
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
	
	@Override
	public void setNoAce() {
		for(int i=0;i<this.playerHand.size();i++) {
			if(playerHand.get(i).getValues().getV() == ACE_VALUE) {
				playerHand.get(i).setAceOrNot(Values.one);
				if(this.getPointPlayer() < 21) {
					break;
				}
			}
		}

	}
	
	
}
