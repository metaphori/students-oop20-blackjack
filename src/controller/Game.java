package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Card;
import model.State;
import utility.ActionHandler;
import view.View;;



public class Game {
	
	//int pickedcard;
//	private int playerNumberCard = 0;
//	private int dealerNumberCard = 0;
//	private List<Card> playerHand = new ArrayList<Card>();
//	private List<Card> dealerHand = new ArrayList<Card>();
//	private int valueplayerhand;
//	private int valuedealerhand;
//	public ActionHandler actionHandler = new ActionHandler(this);
	private DealerDraw dealerDraw = new DealerDraw();
	private PlayerDraw playerDraw = new PlayerDraw();
	private PlayerTurn playerTurn = new PlayerTurn();
	private DealerTurn dealerTurn = new DealerTurn();
	public ActionHandler actionHandler = new ActionHandler(this,dealerDraw,playerDraw,dealerTurn,playerTurn);
	private State currentState;
	private View view;
	
	
	public Game() {}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public void newGame() {
		this.dealerDraw.DrawCard();
		this.playerDraw.DrawCard();
		this.dealerDraw.DrawCard();
		this.playerDraw.DrawCard();
		
		
		if(this.playerDraw.getPlayerHand().size() == 2 && this.playerDraw.getPointPlayer() == 21) { //&& this.dealerDraw.getDealerHand().get(0).getValues().getV() != 10) {
			this.currentState = State.natural;			
		}else if(this.playerDraw.getPointPlayer() < 22) {
			this.currentState = State.playerTurn;
		}

		this.UpdateView();
	}

	public void UpdateView() {		
		this.view.draw(this.dealerDraw.getPointDealer(), this.playerDraw.getPointPlayer(),
				this.playerDraw.getPlayerHand(), this.dealerDraw.getDealerHand(), this.currentState);
	}
	
	public State getState() {
		return this.currentState;
	}
	
	public void setState(State state) {
		this.currentState = state;
	}
	
	public void CheckResult() {
		if(this.dealerDraw.getPointDealer() > this.playerDraw.getPointPlayer() && this.dealerDraw.getPointDealer() < 22 || this.playerDraw.getPointPlayer() > 21) {
			this.setState(State.lose);
		}else if(this.dealerDraw.getPointDealer() < this.playerDraw.getPointPlayer()) {
			this.setState(State.win);
		}else if(this.dealerDraw.getPointDealer() == this.playerDraw.getPointPlayer() && this.playerDraw.getPointPlayer() < 21 && this.dealerDraw.getPointDealer() < 21) {
			this.setState(State.drow);
		}else if(this.dealerDraw.getPointDealer() > 21) {
			this.setState(State.win);
		}
		
		this.UpdateView();
	}
	
	public void ResetAll() {
		this.playerDraw.ResetPlayer();
		this.dealerDraw.ResetDealer();
		this.newGame();
	}
}
