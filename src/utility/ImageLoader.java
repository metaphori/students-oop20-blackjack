package utility;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import model.Card;
import model.Suit;
import model.Values;

public class ImageLoader {
	
	private static final ImageLoader IMAGE = new ImageLoader();
	
	ImageIcon front = new ImageIcon();
	//ImageIcon spade[] = new ImageIcon[14];
	ImageIcon heart[] = new ImageIcon[14];
	ImageIcon club[] = new ImageIcon[14];
	ImageIcon diamond[] = new ImageIcon[14];
	
	private final Map<Card,ImageIcon> spade = new HashMap<>();
	
	public void findImages() {
		URL imgURL = ImageLoader.class.getResource("/backk.png");
		this.front = loadImage(imgURL);
		
		imgURL = ImageLoader.class.getResource("/1_spades_s.png");
		this.spade.put(new Card(Suit.spades,Values.one),loadImage(imgURL));
		
		imgURL = ImageLoader.class.getResource("/2_spades.png");
		this.spade.put(new Card(Suit.spades,Values.two),loadImage(imgURL));
		
	}
	private ImageIcon loadImage(final URL url){
        return new ImageIcon(url);
    }
	public Map<Card,ImageIcon> GetSpades(){
		return this.spade;
	}
	public ImageIcon getFront() {
		return this.front;
	}
	public static ImageLoader getImageLoader() {
        return ImageLoader.IMAGE;
    }
}
