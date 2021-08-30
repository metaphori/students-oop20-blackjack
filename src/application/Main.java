package application;

import utility.ImageLoader;
import controller.Bet;
import controller.Game;
import view.View;
import view.ViewImpl;

public class Main {


    public static void main(final String[] args) {
        //new Game();
    	
    	ImageLoader image = new ImageLoader();
    	image.findImages();
        //ImageLoader.getImageLoader().findImages();
        final Game game = new Game();
        final View view = new ViewImpl(game,image);
        game.setView(view);

    }
}