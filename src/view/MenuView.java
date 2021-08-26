package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Game;

public class MenuView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	JButton start,exit;
	JLabel title,label;
	private final View view;
	private Game game;
	private GameView gameV;
	
	public MenuView(final View view, Game game,GameView gameV) {

		super();
		this.gameV = gameV;
		this.game = game;
		this.view = view;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//this.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		//this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setOpaque(false);
		
		this.title = new JLabel("BlackJack");
		this.title.setFont(new Font("Book Antiqua", Font.PLAIN,90));
		this.title.setForeground(Color.YELLOW);
		this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(title);
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("res/view/menu_image1_preview_rev_1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    this.label = new JLabel(new ImageIcon(image));
	    this.label.setAlignmentX(Component.CENTER_ALIGNMENT);
	    this.add(label);
	    
		this.start = new JButton("START");
		this.start.setBounds(500,750,200,50);
		//this.start.setBorder(null);
		this.start.setBackground(null);
		this.start.setFocusPainted(false);
		this.start.setForeground(Color.white);
		this.start.setFont(new Font("Book Antiqua", Font.PLAIN,36));
		this.start.setVisible(true);
		//this.start.addActionListener(game.aHandler);
		this.start.setActionCommand("start");
		this.start.setContentAreaFilled(false);
		this.start.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(this.start);
		this.start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newPlay();
				
			}
		});
		
		
		this.exit = new JButton("EXIT");
		this.exit.setBounds(500,750,200,50);
		//this.exit.setBorder(null);
		this.exit.setBackground(null);
		this.exit.setFocusPainted(false);
		this.exit.setForeground(Color.white);
		this.exit.setFont(new Font("Book Antiqua", Font.PLAIN,36));
		this.exit.setVisible(true);
		//this.exit.addActionListener(game.aHandler);
		this.exit.setActionCommand("exit");
		this.exit.setContentAreaFilled(false);
		this.exit.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(this.exit);
		
		this.exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
	}
	void newPlay() {
		this.view.switchPanel(gameV);
		this.game.newGame();
	}
}
