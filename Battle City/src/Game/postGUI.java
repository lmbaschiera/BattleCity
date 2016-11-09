package Game;

import javax.swing.*;

import java.awt.Color;

@SuppressWarnings("serial")
public class postGUI extends JFrame{
	private JLabel background;
	private EntidadGrafica[] scorelabel;
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
		scorelabel=new EntidadGrafica[5];
		for (int i=4; i>-1; i--){
			scorelabel[i]=new EntidadGrafica("/imagenes/numeros2/"+score%10+".png", 18, 17);
			scorelabel[i].getGrafico().setBounds(270+i*23, 120, 18, 17);
			this.getContentPane().add(scorelabel[i].getGrafico());
			this.getContentPane().setComponentZOrder(scorelabel[i].getGrafico(), 0);
			score/=10;
		}
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}
}
