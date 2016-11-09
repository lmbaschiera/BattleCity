package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Tanque.Jugador;

public class preGUI extends JFrame{
	private Juego j;
	private JLabel option, background, howto;
	private boolean opt,empiezaJuego;
	public preGUI(){
		this.setVisible(true);
		background=new JLabel();
		background.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/startscreen.png")));
		background.setBounds(0, 0, 640, 560);
		option=new JLabel();
		option.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/pointer.gif")));
		option.setBounds(45, 244, 100, 48); // 244 304
		setSize(640, 560);
		this.getContentPane().add(background);
		this.getContentPane().add(option);
		this.setComponentZOrder(option, 0);
		this.setComponentZOrder(background, 1);
		this.setVisible(true);
		boolean empiezaJuego=false;
		opt=true;
		this.addKeyListener(new kAdapter());
	}
	private void ejecutar() {
		if (opt){
			empiezaJuego=true;
		}
		else
			showHowTo();
	}
	public boolean empiezaJuego(){
		return empiezaJuego;
	}
	private void showHowTo() {
		
	}
	private final class kAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent arg){
			switch(arg.getKeyCode()){
			case KeyEvent.VK_UP :
				opt=!opt;
				System.out.println(opt);
				break;
			case KeyEvent.VK_DOWN :
				opt=!opt;
				System.out.println(opt);
				break;
			case KeyEvent.VK_ENTER :
				ejecutar();
				break;
			default : {};
			}
			if (opt)
				option.setBounds(45, 244, 100, 48);
			else
				option.setBounds(45, 304, 100, 48);
		}
	}
}
		
	

