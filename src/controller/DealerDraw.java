package controller;

import java.util.ArrayList;
import java.util.List;
import model.Card;
import model.Values;


public class DealerDraw {
	
	private List<Card> dealerHand  = new ArrayList<Card>();
	private int pointdealer;
	private PickCard pickCard = new PickCard();
	
	public DealerDraw() {}
	
	public void DrawCard() {
		Card card = pickCard.pickedCard();
		if(card.getValues() == Values.one && getPointDealer()+11 < 22) {
			card.setAceOrNot(Values.getValue(14));
			this.dealerHand.add(card);
		}else if(card.getValues() == Values.one && getPointDealer()+11 > 22 && this.dealerHand.size() < 6) {
			card.setAceOrNot(Values.getValue(1));	
			this.dealerHand.add(card);
			this.setNoAce();
		}else{
			this.dealerHand.add(card);
			if(getPointDealer() > 21) {
				this.setNoAce();
			}
		}
	}
	
	public List<Card> getDealerHand(){
		return this.dealerHand;
	}
	
	public int getDealerNumberCard() {
		return this.dealerHand.size();
	}
	
	public int getPointDealer() {
		this.pointdealer = 0;
		for(Card carta: this.dealerHand){
			this.pointdealer += Values.getValues(carta.getValues());
		}
		return this.pointdealer;
	}
	
	private void setNoAce() {
		List<Card> playerHandtemp = new ArrayList<Card>();
		int countace = 1;
		for(Card carta: this.dealerHand) {
			if(carta.getValues() == Values.ace && countace == 3 || countace == 5) {
				carta.setAceOrNot(Values.getValue(1));
				playerHandtemp.add(carta);
				countace++;
			}else {
				playerHandtemp.add(carta);
			}
			countace++;
		}
		this.dealerHand.clear();
		this.dealerHand = playerHandtemp;
		
	}

	
}
