package Game;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import PU.*;
import Pisos.*;
import Tanque.*;

public class Juego{
	private Jugador player;
	private LinkedList<Enemigo> enemigos;
	private InterfazGui gui;
	private InterfazMapa mapa;
	private int puntaje;
	private static int h=40;
	private static int w=40;
	private int activadorPU;
	public Juego(){
		puntaje=0;
		this.activadorPU=0;
		enemigos= new LinkedList();
		player=new Jugador(this,0,0);
		gui=new GUI(this);
		mapa=new Mapa(13);
		mapa.armarMapa("mapa1.txt");
		gui.levantarMapa(mapa);
		mapa.setGui(gui);
	}
	public int getPuntaje(){
		return puntaje;
	}
	
	public void disparar(Disparo d){
		Thread t=new Thread(d);
		t.start();
	}
	public Enemigo crearMalo(){
		Enemigo e=new Enemigo(0,0,this);
		gui.levantarEntidad(e);
		enemigos.add(e);
		Thread t1 = new Thread(e);
		t1.start();
		return e;
	}
	public void eliminarMalo(){
		
		puntaje+=100;
	}
	public Jugador getJugador(){
		return player;
	}
	public InterfazGui getGui(){
		return gui;
	}
	
	
	public boolean TanquePuedeEstarAca(float x, float y){
		if(y<0 || x<0 || y>484+32|| x>484+32){
			return false;
		} 
		if(mapa.getCelda((int)(x/h),(int) (y/w))!=null)
			return mapa.getCelda((int)(x/h),(int) (y/w)).PuedePasarTanque();
		else
			return true;
	}
	public boolean DisparoPuedeEstarAca(float x, float y,int direccion){
		if(y<0 || x<0 || y>484+32|| x>484+32){
			return false;
		}
		boolean puede;
		if(mapa.getCelda((int)(x/h),(int) (y/w))!=null)
			puede= mapa.getCelda((int)(x/h),(int) (y/w)).PuedePasarDisparo();
		else
			puede=true;
		Iterator<Enemigo> it=enemigos.iterator();
		while(it.hasNext()&& puede){
			Enemigo ene=it.next();
			switch(direccion){
			case KeyEvent.VK_UP :		 // direccion representa la direccion CON LA QUE SALIO EL disparo
				puede=!((ene.getPosX()<=x && ene.getPosX()+ene.getLado()>=x) && (ene.getPosY()<= y));
				break;
			case KeyEvent.VK_DOWN :
				puede=!((ene.getPosX()<=x && ene.getPosX()+ene.getLado()>=x) && (ene.getPosY()<= (y+7)));
				break;
			case KeyEvent.VK_RIGHT :
				puede=!((ene.getPosY()<=y && ene.getPosY()+ene.getLado()>=y) && (ene.getPosX()<=x+7));
				System.out.println("Estoy aca con ene x="+ene.getPosX()+" eney= "+ene.getPosY()+" x ="+x+" y= "+y);
				break;
			case KeyEvent.VK_LEFT :
				puede=!((ene.getPosY()<=y && ene.getPosY()+ene.getLado()>=y) && ((ene.getPosX()+ene.getLado())>= x));
				
				break;
			}
			if(!puede){ /// Si no puede pasar en este punto quiere decir que colisiono con el ultimo enemigo checkeado
				ene.terminate();
				gui.eliminarEntidad(ene.getGrafico());
				this.puntaje+=100;
				System.out.println("El puntaje es: "+puntaje);
				enemigos.remove(ene); // lo eliminamos
				this.activadorPU++;
				if(this.activadorPU==4){
					this.activadorPU=0;
					this.crearPU();
				}
			}
		}
		return puede;
		
	}
	public void crearPU(){
		
	}
}