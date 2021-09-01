package application;

import utility.ImageLoader;
import controller.GameImpl;
import view.View;
import view.ViewImpl;

public class Main {


    public static void main(final String[] args) {
        //new Game();
    	
    	ImageLoader image = new ImageLoader();
    	image.findImages();
        final GameImpl game = new GameImpl();
        final View view = new ViewImpl(game,image);
        game.setView(view);

    }
}