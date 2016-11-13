package Game;

import javax.swing.*;


import PU.*;
import Tanque.Jugador;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GUI extends JFrame implements InterfazGui{
	private JPanel panelObstaculos;
	private EntidadGrafica[] score;
	private EntidadGrafica vida, hits;
	private EntidadGrafica[] timer;
	private Jugador player;
	private InterfazMapa mapa;
	private Juego juego;
	private static final int h=40;
	private static final int w=40;
	public GUI(Juego juego){
		this.juego=juego;
		player=juego.getJugador();
		player.setGui(this);
		
		
		setSize(new Dimension(640, 560)); // 1024 768     +11
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		
		panelObstaculos=new JPanel();
		panelObstaculos.setLayout(null);
		panelObstaculos.setBackground(Color.BLACK);
		setContentPane(panelObstaculos);
		
		armarScore();
		armarVida();
		armarTimer();
		
		panelObstaculos.setVisible(true);
		panelObstaculos.add(player.getGrafico().getGrafico());
		panelObstaculos.setComponentZOrder(player.getGrafico().getGrafico(), 2);
		player.getGrafico().getGrafico().setBounds((int)player.getX(), (int)player.getY(),32,32);
		player.getGrafico().getGrafico().setOpaque(false);
	
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
	public void armarTimer() {
		timer=new EntidadGrafica[4];
		int t=juego.getTimer();
		timer[3]=new EntidadGrafica("/imagenes/numeros2/"+t%10+".png", 18,17);
		timer[2]=new EntidadGrafica("/imagenes/numeros2/"+(t/10)%6+".png", 18,17);
		timer[3].getGrafico().setBounds(536+3*22, 386, 18, 17);
		this.panelObstaculos.add(timer[3].getGrafico());
		this.panelObstaculos.setComponentZOrder(timer[3].getGrafico(), 0);
		t/=10;
		timer[2].getGrafico().setBounds(536+2*22, 386, 18, 17);
		this.panelObstaculos.add(timer[2].getGrafico());
		this.panelObstaculos.setComponentZOrder(timer[2].getGrafico(), 0);
		t/=6;
		timer[1]=new EntidadGrafica("/imagenes/numeros2/"+t%10+".png", 18,17);
		timer[0]=new EntidadGrafica("/imagenes/numeros2/"+(t/10)%10+".png", 18,17);
		timer[1].getGrafico().setBounds(532+1*22, 386, 18, 17);
		this.panelObstaculos.add(timer[1].getGrafico());
		this.panelObstaculos.setComponentZOrder(timer[1].getGrafico(), 0);
		t/=10;
		timer[0].getGrafico().setBounds(532+0*22, 386, 18, 17);
		this.panelObstaculos.add(timer[0].getGrafico());
		this.panelObstaculos.setComponentZOrder(timer[0].getGrafico(), 0);
		revalidate();
		repaint();
	}
	public void armarVida() {
		int v=juego.getJugador().getVida();
		vida=new EntidadGrafica("/imagenes/numeros/"+v%10+".png",25,24);
		this.panelObstaculos.add(vida.getGrafico());
		this.panelObstaculos.setComponentZOrder(vida.getGrafico(), 0);
		vida.getGrafico().setBounds(600, 30, 25, 24);
		revalidate();
		repaint();
	}
	public void armarScore() {
		score=new EntidadGrafica[5];
		int s=juego.getPuntaje();
		for (int i=4; i>-1; i--){
			score[i]=new EntidadGrafica("/imagenes/numeros2/"+s%10+".png", 18, 17);
			score[i].getGrafico().setBounds(522+i*23, 125, 18, 17);
			this.getContentPane().add(score[i].getGrafico());
			this.getContentPane().setComponentZOrder(score[i].getGrafico(), 0);
			s/=10;
		}
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}
	@Override
	public void armarHits() {
		int h=juego.getJugador().getHits();
		hits=new EntidadGrafica("/imagenes/numeros/"+h+".png",25,24);
		this.panelObstaculos.add(hits.getGrafico());
		this.panelObstaculos.setComponentZOrder(hits.getGrafico(), 0);
		hits.getGrafico().setBounds(565, 250, 25, 24);
		revalidate();
		repaint();
	}
	public void moverEntidad(EntidadGrafica move, int x, int y){
		move.getGrafico().setBounds(x, y, move.getW(), move.getH());
		this.getContentPane().repaint();
		this.getContentPane().revalidate();
	}
	public void levantarMapa(InterfazMapa map){
		this.mapa=map;
		EntidadGrafica aux = new EntidadGrafica("/imagenes/suelo.png", 0, 0);
		aux.getGrafico().setBounds(0, -233, 1024, 1024); // 272
		panelObstaculos.add(aux.getGrafico());
		aux.getGrafico().setOpaque(false);
		for(int i=0;i<mapa.getTamaño();i++){
			for(int j=0;j<mapa.getTamaño();j++){
				if(mapa.getCelda(i, j)!=null && mapa.getCelda(i, j).getGrafico().getImagen()!="/imagenes/marron.png"){
					panelObstaculos.add(mapa.getCelda(i, j).getEntidadGrafica().getGrafico());
					panelObstaculos.setComponentZOrder(mapa.getCelda(i, j).getEntidadGrafica().getGrafico(),mapa.getCelda(i, j).getZOrder() );
					mapa.getCelda(i, j).getEntidadGrafica().getGrafico().setBounds(i*w, j*h, w, h);
					mapa.getCelda(i, j).getEntidadGrafica().getGrafico().setOpaque(false);
				}
			}
		}
		this.getContentPane().repaint();
		this.getContentPane().revalidate();
	}

	
	public void levantarEntidad(GameObject go){
		JLabel l=go.getGrafico().getGrafico();
		this.panelObstaculos.add(l);
		this.panelObstaculos.setComponentZOrder(l, 1);
		l.setBounds((int)go.getPosX()*40,(int) go.getPosY()*40, go.getGrafico().getW(), go.getGrafico().getH());
		l.setOpaque(false);
		this.getContentPane().repaint();
		this.getContentPane().revalidate();
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