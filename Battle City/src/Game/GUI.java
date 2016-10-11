package Game;

import javax.swing.*;

import Pisos.Agua;
import Pisos.Arbol;
import Pisos.Celda;
import Pisos.Ladrillo;
import Pisos.Metal;
import Tanque.Jugador;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GUI extends JFrame{
	private JPanel panel,panelObstaculos,panelFondo;
	private JLabel label, aux;
	private ImageIcon[] jugadorGrafico;
	private ImageIcon[] enemigosGrafico;
	private Jugador player;
	private Mapa mapa;
	private Juego juego;
	private JButton boton;
	private static final int h=40;
	private static final int w=40;
	private boolean creado;
	
	
	public GUI(){
		super();
		aux=null;
		juego=new Juego(this);
	
		
		creado=false;
		
		this.player = juego.getJugador();
		this.mapa= juego.getMapa();
		
		setSize(new Dimension(w*14, h*14)); // 1024 768
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panelFondo=new JPanel();
		
		
		panelObstaculos=new JPanel();
		panelObstaculos.setLayout(null);
		panelObstaculos.setBackground(Color.BLACK);
		
		
		inicializarImagenes();
		armarMapa("mapa1.txt");
		
		
		setContentPane(panelObstaculos);
		
		
		panelObstaculos.setVisible(true);
		
		label = new JLabel();
		label.setBounds(0, 0,32,32);
		
		label.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/37.png")));
		label.setOpaque(false);
		panelObstaculos.add(label);
		
		getContentPane().setComponentZOrder(label, 0);
		this.setVisible(true);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//arg0.getKeyChar()=='t' || arg0.getKeyChar()=='g' || 
				if ((arg0.getKeyCode()>36 && arg0.getKeyCode()<41)){
						mover(arg0.getKeyCode());
				}
				else{
					switch(arg0.getKeyChar()){
					case 't':
						if(!creado){
							aux=new JLabel();
							creado=true;
							juego.crearMalo();
							aux.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/Enemy1.png")));
							panelObstaculos.add(aux);
							aux.setBounds(50,60,h,w);
							panelObstaculos.setComponentZOrder(aux,0);
						}
						else{
							creado=false;
							juego.eliminarMalo();
							System.out.println(juego.getPuntaje());
							//Container cont=aux.getParent();
							panelObstaculos.remove(aux);
							panelObstaculos.revalidate();
							panelObstaculos.repaint();
						}
					break;
					case'p':
						
						System.out.println(player.subirNivel().getVelocidadM());
						
						break;
					case'g':panelObstaculos.remove(mapa.getCelda(11,2).getGraficos().getGrafico());
					mapa.setCelda(null,11,2);
					
					panelObstaculos.revalidate();
					panelObstaculos.repaint();
					break;
					case KeyEvent.VK_SPACE:
						System.out.println("dispare ");	
						player.efectuarDisparo(null);
						break;
					}
					
			}
		}
	});
}	
	public void moverLabel(JLabel move, int x, int y){
		move.setBounds(x, y,3, 3);
	}
	private void mover(int k){
		player.mover(k);//Movemos el jugador
		label.setBounds((int)player.getX(),(int)player.getY(),h,w);//Repainteamos
		label.setIcon(jugadorGrafico[k-37]);

		//System.out.println(player.getX() +" y = "+ player.getY());
	}

	private void armarMapa(String str){
		BufferedReader br = null;
		String file = str;
		String sCurrent;
		try {
			br = new BufferedReader(new FileReader(file));
			Celda celda;
			int columna=0;
			EntidadGrafica eg;
			while((sCurrent = br.readLine())!=null){
				for(int i=0;i<sCurrent.length();i++){
					char ch=sCurrent.charAt(i);
					switch(ch){
					case'1': 	
						celda=new Ladrillo(mapa,i,columna);
						mapa.setCelda(celda,i,columna);	
						eg=new EntidadGrafica(crearLabel(celda.getImg(),i,columna));
						celda.setGraficos(eg);
						break; 
					case '2':	
						celda=new Arbol(mapa,i,columna);
						mapa.setCelda(celda,i,columna);	
						eg=new EntidadGrafica(crearLabel(celda.getImg(),i,columna));
						celda.setGraficos(eg);
						break;
					case '3':	
						celda=new Agua(mapa,i,columna);
						mapa.setCelda(celda,i,columna);	
						eg=new EntidadGrafica(crearLabel(celda.getImg(),i,columna));
						celda.setGraficos(eg);
						break;
					case '4': 	
						celda=new Metal(mapa,i,columna);
						mapa.setCelda(celda,i,columna);	
						eg=new EntidadGrafica(crearLabel(celda.getImg(),i,columna));
						celda.setGraficos(eg);
						break;
					}
				}
				columna+=1;
			}

			System.out.println("checkpoint");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private void inicializarImagenes(){
		jugadorGrafico=new ImageIcon[4];
		jugadorGrafico[0]=new ImageIcon(this.getClass().getResource("/imagenes/37.png"));
		jugadorGrafico[1]=new ImageIcon(this.getClass().getResource("/imagenes/38.png"));
		jugadorGrafico[2]=new ImageIcon(this.getClass().getResource("/imagenes/39.png"));
		jugadorGrafico[3]=new ImageIcon(this.getClass().getResource("/imagenes/40.png"));
	}
	public JLabel crearLabel(String str,int i,int c){
		JLabel aux;
		aux=new JLabel();
		aux.setBounds(i*h,c*w,h,w);
		aux.setIcon(new ImageIcon(this.getClass().getResource(str)));
		aux.setOpaque(true);
		
		panelObstaculos.add(aux); 
		return aux;
		//getContentPane().setComponentZOrder(aux, 2);
	}
	private class oyente implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	}


