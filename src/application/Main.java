package application;

import controller.Game;
import view.View;
import view.ViewImpl;

public class Main {
	

	public static void main(final String[] args) {
		//new Game();
		final View view = new ViewImpl();
		final Game game = new Game();
	}	
}
