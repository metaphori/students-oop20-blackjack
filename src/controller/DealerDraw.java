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
		if(card.getValues() == Values.one) {
			if(getPointDealer() < 22) {//forse per correttezza bisognerebbe prendere il punteggio fare +11 e controllare che sia minore a 22
				card.setAceOrNot(Values.getValue(14));
			}else if(getPointDealer() > 22 && this.dealerHand.size() < 5) {
				card.setAceOrNot(Values.getValue(1));	
			}
		}
		this.dealerHand.add(card);
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
	
}
