package Game;

import java.awt.Font;

import javax.swing.*;
import java.awt.Color;

@SuppressWarnings("serial")
public class postGUI extends JFrame{
	private JLabel background, scorelabel;
	public postGUI(int score){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(640, 560);
		this.setVisible(true);
		getContentPane().setLayout(null);
		background=new JLabel();
		background.setBackground(Color.BLACK);
		background.setForeground(Color.BLACK);
		background.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/postscreen.gif")));
		background.setBounds(0, 0, 640, 560);
		this.getContentPane().add(background);
		scorelabel=new JLabel();
		scorelabel.setFont(new Font("Pixel Emulator", Font.PLAIN, 26));
		scorelabel.setText(""+score);
		this.getContentPane().add(scorelabel);
		scorelabel.setBounds(290, -130, 624, 521);
		this.getContentPane().setComponentZOrder(scorelabel, 0);
	}
}
