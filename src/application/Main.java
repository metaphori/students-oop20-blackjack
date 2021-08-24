package application;

<<<<<<< HEAD
import utility.ImageLoader;
=======
import controller.Game;
>>>>>>> 75f43e235ed678708f3149d2a64c105ab2e2f06f
import view.View;
import view.ViewImpl;

public class Main {
	

	public static void main(final String[] args) {
		//new Game();
		
		final View view = new ViewImpl();
<<<<<<< HEAD
		ImageLoader.getImageLoader().findImages();
=======
		final Game game = new Game();
>>>>>>> 75f43e235ed678708f3149d2a64c105ab2e2f06f
	}	
}
