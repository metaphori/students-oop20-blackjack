package controller;

import model.State;

public class PlayerTurn {
	
	private PlayerDraw playerDraw;
	private Game game;
	
	public PlayerTurn() {
	}
	
	public void newTurnPlayer(PlayerDraw playerDraw2, Game game) {
		this.playerDraw = playerDraw2;
		this.game = game;
		this.playerDraw.DrawCard();
		
		if(this.playerDraw.getPointPlayer() > 21) {
			this.game.setState(State.dealerTurn);
			this.game.UpdateView();
		}else if (this.playerDraw.getPointPlayer() < 22) {
			if(this.playerDraw.getPlayerHand().size() > 1 && this.playerDraw.getPlayerHand().size() < 5) {
				this.game.setState(State.playerTurn);
				this.game.UpdateView();
			}else if(this.playerDraw.getPlayerHand().size() == 5) {
				this.game.setState(State.dealerTurn);
				this.game.UpdateView();
			}
		}
	}



}
