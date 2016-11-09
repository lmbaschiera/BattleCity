package Game;

import javax.swing.*;

import PU.Frenar;
import PU.PowerUp;
import Tanque.Jugador;

import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class GUI extends JFrame implements InterfazGui{
	private JPanel panelObstaculos;
	private Jugador player;
	private InterfazMapa mapa;
	private static final int h=40;
	private static final int w=40;
	
	public GUI(Juego juego){
		player=juego.getJugador();
		player.setGui(this);
		
		
		setSize(new Dimension(w*14, h*14)); // 1024 768
		getContentPane().setLayout(null);
		this.setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		panelObstaculos=new JPanel();
		panelObstaculos.setLayout(null);
		panelObstaculos.setBackground(Color.BLACK);
		
		

		
		
		
		setContentPane(panelObstaculos);
		
		
		panelObstaculos.setVisible(true);
		
		player.getGrafico().getGrafico().setBounds((int)player.getX(), (int)player.getY(),32,32);
		
		player.getGrafico().getGrafico().setOpaque(false);
		panelObstaculos.add(player.getGrafico().getGrafico());
		this.setVisible(true);
		addKeyListener(new KeyAdapter() {
			@Override
			
			public void keyPressed(KeyEvent arg0) {
				 
				if ((arg0.getKeyCode()>36 && arg0.getKeyCode()<41)){
						player.mover(arg0.getKeyCode());
				}
				else{
					
						
					
					switch(arg0.getKeyChar()){
					

					case 'u':
						PowerUp p = new Frenar(juego, 0, 0);
						p.afectar(player);
						break;
					
					case'p':
						player.subirNivel().getVelocidadM();
						
						break;
					
					case KeyEvent.VK_SPACE:
						player.efectuarDisparo();
						break;
					}
					
			}
		}
	});
}	
	public void moverEntidad(EntidadGrafica move, int x, int y){
		move.getGrafico().setBounds(x, y, move.getW(), move.getH());
		this.revalidate();
		this.repaint();
	}
	public void levantarMapa(InterfazMapa map){
		this.mapa=map;
		EntidadGrafica aux=new EntidadGrafica("/imagenes/suelo.png", 0, 0);
		aux.getGrafico().setBounds(0, 0, 1024, 1024);
		panelObstaculos.add(aux.getGrafico());
		for(int i=0;i<mapa.getTamaño();i++){
			for(int j=0;j<mapa.getTamaño();j++){
				if(mapa.getCelda(i, j)!=null && mapa.getCelda(i, j).getGrafico().getImagen()!="/imagenes/marron.png"){
					panelObstaculos.add(mapa.getCelda(i, j).getEntidadGrafica().getGrafico());
					panelObstaculos.setComponentZOrder(mapa.getCelda(i, j).getEntidadGrafica().getGrafico(), 0);
					mapa.getCelda(i, j).getEntidadGrafica().getGrafico().setOpaque(false);
					mapa.getCelda(i, j).getEntidadGrafica().getGrafico().setBounds(i*w, j*h, w, h);
				}
			}
		}
		getContentPane().setComponentZOrder(player.getGrafico().getGrafico(), 0);
		this.repaint();
		this.revalidate();
	}

	
	public void levantarEntidad(GameObject go){
		JLabel l=go.getGrafico().getGrafico();
		this.panelObstaculos.add(l);
		this.panelObstaculos.setComponentZOrder(l, 1);
		l.setBounds((int)go.getPosX()*40,(int) go.getPosY()*40, go.getGrafico().getW(), go.getGrafico().getH());
	}
	
	public void eliminarEntidad(EntidadGrafica e) {
		panelObstaculos.remove(e.getGrafico());
		panelObstaculos.revalidate();
		panelObstaculos.repaint();
	}
	@Override
	public int getMaxX() {
		return this.getWidth();
	}
	@Override
	public int getMaxY() {
		return this.getHeight();
	}
	
	public InterfazMapa getMapa(){
		return mapa;
	}
	
	
}