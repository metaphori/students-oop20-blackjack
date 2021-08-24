package controller;

import java.util.Random;
import model.Card;
import model.Suit;
import model.Values;

public class PickCard {
	
	private Card cardpicked;
	private Random random = new Random();
	
	public PickCard() {
		
	}
	
	public Card pickedCard() {
		
		int pickedCardNum = random.nextInt(4)+1;
		int pickedCardValue = random.nextInt(13)+1;		
//		spade 0
//		club 1 
//		diamons 2 
//		heart 3
		switch (pickedCardNum) {
		case 1://spade
			this.cardpicked = new Card(Suit.spades, Values.getValue(pickedCardValue));
			break;
		case 2://club
			this.cardpicked = new Card(Suit.clubs, Values.getValue(pickedCardValue));
			break;
		case 3://diamons
			this.cardpicked = new Card(Suit.diamods, Values.getValue(pickedCardValue));
			break;
		case 4://heart
			this.cardpicked = new Card(Suit.heart, Values.getValue(pickedCardValue));
			break;
		}
		
		return cardpicked;
		
	}

}
