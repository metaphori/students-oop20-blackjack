package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton start,exit;
	JLabel title;
	private final View view;
	
	public MenuView(final View view) {

		super();
		this.view = view;
		
		this.setBounds(0, 0, 1200, 600);
		this.setOpaque(false);
		
		this.title = new JLabel("BlackJack");
		this.add(title);
		this.start = new JButton("START");
		this.start.setBounds(500,700,200,50);
		//this.start.setBorder(null);
		this.start.setBackground(null);
		this.start.setFocusPainted(false);
		this.start.setForeground(Color.white);
		this.start.setFont(new Font("Book Antiqua", Font.PLAIN,36));
		this.start.setVisible(true);
		//this.start.addActionListener(game.aHandler);
		this.start.setActionCommand("start");
		this.start.setContentAreaFilled(false);
		this.add(this.start);
		
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
		this.add(this.exit);
		//this.view.switchPanel(this);
		
	}
	
}
