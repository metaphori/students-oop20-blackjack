package utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Game;

public class ActionHandler implements ActionListener{

	private Game game;
	
	public ActionHandler(Game game) {
		// TODO Auto-generated constructor stub
		this.game = game;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch (command) {
		case "hit":
			//richiamare la classe per pescare una carta del player
			//condizioni con if-else con lo status
			break;
		case "stand":
			
			break;

		default:
			break;
		}
	}

}
