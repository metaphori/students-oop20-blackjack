package controller;

import model.Chip;

public class Bet {
	
	private Game game;
	private int bet;
	
	public Bet(Game game) {
		this.game = game;
	}
	
	public void setBet(Chip chip) {
		this.bet += Chip.getChipValue(chip);
	}
	
	public void overbet() {
		this.game.setBet(this.bet);
	}
	public int getBet() {
		return this.bet;
	}
	
}
