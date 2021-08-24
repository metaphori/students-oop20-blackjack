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
		this.dealerHand.add(pickCard.pickedCard());
	}
	
	public List<Card> getDealerHand(){
		return this.dealerHand;
	}
	
	public int getDealerNumberCard() {
		return this.dealerHand.size();
	}
	
	public int getPointDealer() {

		for(Card carta: this.dealerHand){
			this.pointdealer += Values.getValues(carta.getValues());
		}
		return this.pointdealer;
	}
	
}
