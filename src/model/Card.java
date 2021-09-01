package model;

public interface Card {

	Suit getSuit();

	Values getValues();

	void setAceOrNot(Values values);

}