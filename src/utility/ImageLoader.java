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
	private static final int NCard = 15;
	private static final int NCHIPS = 3;
	private ImageIcon front = new ImageIcon();
	private ImageIcon menu = new ImageIcon();
	private ImageIcon chip[] = new ImageIcon[3];
	
	private final Map<Card,ImageIcon> spades = new HashMap<>();
	private final Map<Card,ImageIcon> diamonds = new HashMap<>();
	private final Map<Card,ImageIcon> clubs = new HashMap<>();
	private final Map<Card,ImageIcon> hearts = new HashMap<>();
	
	public void findImages() {
		URL imgURL = ImageLoader.class.getResource("/back.png");
		this.front = loadImage(imgURL);
		
		imgURL = ImageLoader.class.getResource("/menuImage.png");
		this.menu = loadImage(imgURL);
		
		for(int i = 0; i< NCHIPS;i++) {
			imgURL = ImageLoader.class.getResource("/"+i+"_chip.png");
			this.chip[i] = loadImage(imgURL);
		}
		
		for(int i = 1; i<NCard;i++) {
			imgURL = ImageLoader.class.getResource("/"+i+"_spades.png");
			this.spades.put(new Card(Suit.spades,Values.getValue(i)),loadImage(imgURL));
		}
		for(int i = 1; i<NCard;i++) {
			imgURL = ImageLoader.class.getResource("/"+i+"_diamonds.png");
			this.diamonds.put(new Card(Suit.diamods,Values.getValue(i)),loadImage(imgURL));
		}
		for(int i = 1; i<NCard;i++) {
			imgURL = ImageLoader.class.getResource("/"+i+"_plub.png");
			this.clubs.put(new Card(Suit.clubs,Values.getValue(i)),loadImage(imgURL));
		}
		for(int i = 1; i<NCard;i++) {
			imgURL = ImageLoader.class.getResource("/"+i+"_heart.png");
			this.hearts.put(new Card(Suit.heart,Values.getValue(i)),loadImage(imgURL));
		}
	}
	private ImageIcon loadImage(final URL url){
        return new ImageIcon(url);
    }
	public Map<Card,ImageIcon> getSpades(){
		return this.spades;
	}
	public ImageIcon getMenuImage() {
		return this.menu;
	}
	public ImageIcon[] getChipImage() {
		return this.chip;
	}
	public Map<Card,ImageIcon> getHeart(){
		return this.hearts;
	}
	public Map<Card,ImageIcon> getClubs(){
		return this.clubs;
	}
	public Map<Card,ImageIcon> getDiamonds(){
		return this.diamonds;
	}
	public ImageIcon getFront() {
		return this.front;
	}
	public static ImageLoader getImageLoader() {
        return ImageLoader.IMAGE;
    }
}
