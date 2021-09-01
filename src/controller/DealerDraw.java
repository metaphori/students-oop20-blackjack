package controller;

import java.util.ArrayList;
import java.util.List;

import model.Card;
import model.CardImpl;
import model.Values;


public class DealerDraw implements Draw{
	
	private final static int ACE_VALUE = 11;
	private final static int MAX_DEALER_HAND_SIZE = 6;
	private List<CardImpl> dealerHand  = new ArrayList<CardImpl>();
	private int pointdealer;
	private PickCard pickCard = new PickCard();
	
	public DealerDraw() {
		
	}
	
	@Override
	public void DrawCard() {
		CardImpl card = pickCard.pickedCard();
		if(card.getValues() == Values.one && getPointDealer()+ ACE_VALUE < 22) {
			card.setAceOrNot(Values.getValue(14));
			this.dealerHand.add(card);
		}else if(card.getValues() == Values.one && getPointDealer()+ ACE_VALUE > 22 && this.dealerHand.size() < MAX_DEALER_HAND_SIZE) {
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
	
	public List<CardImpl> getDealerHand(){
		return this.dealerHand;
	}
	
	public void ResetDealer() {
		this.dealerHand.clear();
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
	
	@Override
	public void setNoAce() {	
		for(int i=0;i<this.dealerHand.size();i++) {
			if(this.dealerHand.get(i).getValues().getV() == ACE_VALUE) {
				this.dealerHand.get(i).setAceOrNot(Values.one);
				if(this.getPointDealer() < 21) {
					break;
				}
			}
		}	
	}

	
}
