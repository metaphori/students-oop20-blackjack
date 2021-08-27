package controller;

public class DealerTurn {

	private DealerDraw dealerDraw;
	private Game game;
	public DealerTurn() {		
	}


	public void newTurnDealer(DealerDraw dealerDraw, Game game) {
		this.dealerDraw = dealerDraw;
		this.game = game;
		boolean turndealerfinish = true;
		
		while(turndealerfinish) {
			if(this.dealerDraw.getPointDealer() <17) {
				this.dealerDraw.DrawCard();
				
				if(this.dealerDraw.getDealerHand().size() == 5 || this.dealerDraw.getPointDealer() >= 17) {
					turndealerfinish = false;
				}
			}else {
				turndealerfinish = false;
			}
		}
		
		if(!turndealerfinish) {
			this.game.CheckResult();
		}
	}
}
