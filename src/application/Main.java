package application;


import utility.ImageLoader;
import controller.Game;
import view.View;
import view.ViewImpl;

public class Main {
	

	public static void main(final String[] args) {
		//new Game();
		
		final View view = new ViewImpl();
		ImageLoader.getImageLoader().findImages();
		final Game game = new Game();

	}	
}
