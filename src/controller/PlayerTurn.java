package controller;

public class PlayerTurn {
	
	private PlayerDraw playerDraw = new PlayerDraw();
	
	public PlayerTurn() {
	}

	public void PlayerDoTurn() {
	
		this.playerDraw.DrawCard();
		
		//controllare i valori nella mano del player	
	}

}
