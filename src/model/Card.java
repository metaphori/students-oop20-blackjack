package model;

public class Card {
	
	private Suit suit;
	private Values values;
	
	public Card(Suit suit,Values values) {
		this.suit = suit;
		this.values = values;
	}

	public Suit getSuit() {
		return suit;
	}

	public Values getValues() {
		return values;
	}
	
	

}
