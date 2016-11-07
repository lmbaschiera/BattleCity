package Game;

import javax.swing.*;

import PU.Frenar;
import PU.PowerUp;
import Pisos.Agua;
import Pisos.Arbol;
import Pisos.Celda;
import Pisos.Ladrillo;
import Pisos.Metal;
import Tanque.Enemigo;
import Tanque.Jugador;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GUI extends JFrame implements InterfazGui{
	private JPanel panel,panelObstaculos,panelFondo;
	private EntidadGrafica[] jugadorGrafico;
	private EntidadGrafica[] enemigoGrafico;
	private Jugador player;
	private InterfazMapa mapa;
	private Juego juego;
	private static final int h=40;
	private static final int w=40;
	private boolean creado;
	
	
	public GUI(Juego juego){
		super();
		this.juego=juego;
		
		player=juego.getJugador();
		player.setGui(this);
		
		
		creado=false;
		
		setSize(new Dimension(w*14, h*14)); // 1024 768
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panelFondo=new JPanel();
		
		
		panelObstaculos=new JPanel();
		panelObstaculos.setLayout(null);
		panelObstaculos.setBackground(Color.BLACK);
		
		
		inicializarImagenes();
		
		
		
		setContentPane(panelObstaculos);
		
		
		panelObstaculos.setVisible(true);
		
		player.getGrafico().getGrafico().setBounds((int)player.getX(), (int)player.getY(),32,32);
		
		player.getGrafico().getGrafico().setOpaque(false);
		panelObstaculos.add(player.getGrafico().getGrafico());
		
		getContentPane().setComponentZOrder(player.getGrafico().getGrafico(), 0);
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
						PowerUp p = new Frenar(juego);
						p.afectar(player);
						break;
					
					case 't':
						if(!creado){
							
							creado=true;
							juego.crearMalo();
							
							
						}
						else{
							creado=false;
							
							panelObstaculos.revalidate();
							panelObstaculos.repaint();
						}
					break;
					case'p':
						player.subirNivel().getVelocidadM();
						
						break;
					case'g':panelObstaculos.remove(mapa.getCelda(11,2).getEntidadGrafica().getGrafico());
					mapa.setCelda(null,11,2);
					
					panelObstaculos.revalidate();
					panelObstaculos.repaint();
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
		for(int i=0;i<mapa.getTamaño();i++){
			for(int j=0;j<mapa.getTamaño();j++){
				if(mapa.getCelda(i, j)!=null){
					panelObstaculos.add(mapa.getCelda(i, j).getEntidadGrafica().getGrafico());
					mapa.getCelda(i, j).getEntidadGrafica().getGrafico().setOpaque(false);
					mapa.getCelda(i, j).getEntidadGrafica().getGrafico().setBounds(i*w, j*h, w, h);
				}
			}
		}
	}
	private void inicializarImagenes(){
		/*jugadorGrafico=new EntidadGrafica[4];
		jugadorGrafico=player.getNivel().getImg();
		enemigoGrafico=new EntidadGrafica[4];
		enemigoGrafico[0]=new EntidadGrafica("/imagenes/enemy1-37.png", 32, 32);
		enemigoGrafico[1]=new EntidadGrafica("/imagenes/enemy1-38.png", 32, 32);
		enemigoGrafico[2]=new EntidadGrafica("/imagenes/enemy1-39.png", 32, 32);
		enemigoGrafico[3]=new EntidadGrafica("/imagenes/enemy1-40.png", 32, 32);
		jugadorGrafico=new ImageIcon[4];
		jugadorGrafico[0]=new ImageIcon(this.getClass().getResource("/imagenes/37.png"));
		jugadorGrafico[1]=new ImageIcon(this.getClass().getResource("/imagenes/38.png"));
		jugadorGrafico[2]=new ImageIcon(this.getClass().getResource("/imagenes/39.png"));
		jugadorGrafico[3]=new ImageIcon(this.getClass().getResource("/imagenes/40.png"));
		enemigoGrafico = new ImageIcon[4];
		enemigoGrafico[0] = new ImageIcon(this.getClass().getResource("/imagenes/enemy37.png"));
		enemigoGrafico[1] = new ImageIcon(this.getClass().getResource("/imagenes/enemy38.png"));
		enemigoGrafico[2] = new ImageIcon(this.getClass().getResource("/imagenes/enemy39.png"));
		enemigoGrafico[3] = new ImageIcon(this.getClass().getResource("/imagenes/enemy40.png"));*/
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