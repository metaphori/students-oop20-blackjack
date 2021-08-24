package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Card;;



public class Game {
	
	//int pickedcard;
	private int playerNumberCard = 0;
	private int dealerNumberCard = 0;
	private List<Card> playerHand = new ArrayList<Card>();
	private List<Card> dealerHand = new ArrayList<Card>();
	private int valueplayerhand;
	private int dealerplayerhand;
	private DealerDraw dealerDraw = new DealerDraw();
	
	
	public Game() {
		this.dealerDraw.DrawCard();
		//new PlayerDraw();
		this.dealerDraw.DrawCard();
		//new PlayerTurn();
		this.dealerHand = this.dealerDraw.getDealer();
		
		System.out.println("prima carta: "+ this.dealerHand.get(0).getSuit()+this.dealerHand.get(0).getValues()
				+"seconda carta: " + this.dealerHand.get(1).getSuit()+this.dealerHand.get(1).getValues());
	}
	//stati di gioco
	//geme finished
	//check result 
	//reset
	//player Natural

	//stati della view
	//menu...
}
