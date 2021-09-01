package application;

import utility.ImageLoader;
import controller.Game;
import controller.GameImpl;
import view.View;
import view.ViewImpl;
/**
 * 
 * 
 *
 */

public class Main {

/**
 * 
 * @param args
 */
    public static void main(final String[] args) {
        //new Game();
    	
    	ImageLoader image = new ImageLoader();
    	image.findImages();
        final Game game = new GameImpl();
        final View view = new ViewImpl(game,image);
        game.setView(view);

    }
}