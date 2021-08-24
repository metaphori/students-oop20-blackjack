package controller;

import java.util.ArrayList;
import java.util.List;
import model.Card;


public class DealerDraw {
	
	private List<Card> dealerHand  = new ArrayList<Card>();
	private int dealerNumberCard;
	private int dealerValueInHands;
	private PickCard pickCard = new PickCard();
	
	public DealerDraw() {

	}
	
	public void DrawCard() {
		this.dealerNumberCard++;
		//this.dealerhand.setDilerhand(pickCard.pickedCard());
		this.dealerHand.add(pickCard.pickedCard());
	}
	
	public int getDealerNumberCard() {
		return dealerNumberCard;
	}
	
	public int getDealerValueInHands() {
//		Set<Card> listdealerHands = dealerHand.getDilerhand();
//		
//		for(Card carta: listdealerHands) {
//			this.dealerValueInHands += Values.getValues(carta.getValues());
//		}
//		return dealerValueInHands;
		return 0;
	}
	
	public List<Card> getDealer(){
		return this.dealerHand;
	}

}
