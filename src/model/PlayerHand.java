package model;

import java.util.ArrayList;
import java.util.List;

public class PlayerHand {
	
	private List<Card> playerhand = new ArrayList<>(6);
	
	public PlayerHand() {
		
	}

	public List<Card> getPlayerhand() {
		return playerhand;
	}

	public void setPlayerhand(Card playercard) {
		this.playerhand.add(playercard);
	}
	
	public void RemoveCardPlayer(Card playercard) {
		this.playerhand.remove(playercard);
	}
	
	public void NewHandPlayer() {
		this.playerhand.clear();
	}
	
	
}
