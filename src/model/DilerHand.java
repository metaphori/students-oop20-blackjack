package model;

import java.util.ArrayList;
import java.util.List;

public class DilerHand {
	
	private List<Card> dilerhand = new ArrayList<Card>(6);
	
	public DilerHand() {
		
	}

	public List<Card> getDilerhand() {
		return dilerhand;
	}

	public void setDilerhand(Card dilercard) {
		this.dilerhand.add(dilercard);
	}
	
	public void RemoveCardDiler(Card dilercard) {
		this.dilerhand.remove(dilercard);
	}
	
	public void NewHandDiler() {
		this.dilerhand.clear();
	}

}
