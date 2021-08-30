package controller;

public class Bet {
	
	private Game game;
	private int bet;
	
	public Bet(Game game) {
		this.game = game;
	}
	
	public void setBet(int bet) {
		this.bet += bet;
	}
	
	public void overbet() {
		this.game.setBet(this.bet);
	}
	
}
