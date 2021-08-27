package utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.DealerDraw;
import controller.DealerTurn;
import controller.Game;
import controller.PlayerDraw;
import controller.PlayerTurn;
import view.MenuView;
import view.View;

public class ActionHandler implements ActionListener{

	private Game game;
	private PlayerTurn playerTurn;
	private DealerTurn dealerTurn;
	private PlayerDraw playerDraw;
	private DealerDraw dealerDraw;

	
	public ActionHandler(Game game, DealerDraw dealerDraw, PlayerDraw playerDraw, DealerTurn dealerTurn, PlayerTurn playerTurn) {
		// TODO Auto-generated constructor stub
		this.game = game;
		this.playerTurn = playerTurn;
		this.playerDraw = playerDraw;
		this.dealerTurn = dealerTurn;
		this.dealerDraw = dealerDraw;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		switch (command) {
		case "1"://pesca
				this.playerTurn.newTurnPlayer(this.playerDraw,this.game);
			break;
		case "2"://stai
				this.dealerTurn.newTurnDealer(this.dealerDraw,this.game);
			break;
		case "0"://rigioca
				this.game.ResetAll();
			break;
		case "4":
			break;
		case "5":
			break;
		case "6":
			break;
		}
	}

}
