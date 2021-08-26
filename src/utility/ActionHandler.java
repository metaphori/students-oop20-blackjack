package utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.DealerTurn;
import controller.Game;
import controller.PlayerTurn;
import view.MenuView;
import view.View;

public class ActionHandler implements ActionListener{

	private Game game;
	private PlayerTurn playerTurn;
	private DealerTurn dealerTurn;

	
	public ActionHandler(Game game) {
		// TODO Auto-generated constructor stub
		this.game = game;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		switch (command) {
		case "1"://pesca
				this.playerTurn = new PlayerTurn();
			break;
		case "2"://stai
			break;
		case "3":
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
