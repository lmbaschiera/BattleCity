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
	private LinkedList<Tanque> tanques;
	private InterfazGui gui;
	private InterfazMapa mapa;
	private int puntaje;
	private static int h=40;
	private static int w=40;
	private int activadorPU;
	public Juego(){
		puntaje=0;
		this.activadorPU=0;
		tanques= new LinkedList();
		player=new Jugador(this,0,0);
		tanques.addLast(player);
		gui=new GUI(this);
		mapa=new Mapa(13);
		mapa.armarMapa("mapa1.txt");
		gui.levantarMapa(mapa);
		mapa.setGui(gui);
	}
	
	
	public Enemigo crearMalo(){
		Enemigo e=new Enemigo(0,0,this,gui,(byte)0);
		gui.levantarEntidad(e);
		tanques.add(e);
		Thread t1 = new Thread(e);
		t1.start();
		return e;
	}
	public void eliminarMalo(Enemigo e){
		this.puntaje+=e.getPuntaje();
		tanques.remove(e);
		e.terminate();
		this.activadorPU++;
		if((this.activadorPU%4)==0){
			this.crearPU();
		}
		for(int i=tanques.size();i<4;i++){
			this.crearMalo();
		}
	}
	public Jugador getJugador(){
		return player;
	}
	public InterfazGui getGui(){
		return gui;
	}
	
	
	public boolean TanquePuedeEstarAca(float x, float y, Tanque t){
		if(y<0 || x<0 || y>484+32|| x>484+32){
			return false;
		} 
		boolean puede;
		puede=mapa.getCelda((int)(x/h),(int) (y/w)).PuedePasarTanque();
		if(puede){
			Iterator<Tanque>it=tanques.iterator();
			while(it.hasNext() && puede){
				Tanque tanque=it.next();
				if(tanque!=t){
					switch(t.getLastMovement()){
					case KeyEvent.VK_UP :		 // direccion representa la direccion CON LA QUE SALIO EL disparo
						if(tanque.getPosY()< y)
						puede=!((tanque.getPosX()<=x && tanque.getPosX()+tanque.getLado()>=x) && (tanque.getPosY()+tanque.getLado()>= y));
						break;
					case KeyEvent.VK_DOWN :
						if(tanque.getPosY()> y)
							puede=!((tanque.getPosX()<=x && tanque.getPosX()+tanque.getLado()>=x) && (tanque.getPosY()<= (y+7)));
						break;
					case KeyEvent.VK_RIGHT :
						if(tanque.getPosX()> x)
						puede=!((tanque.getPosY()<=y && tanque.getPosY()+tanque.getLado()>=y) && (tanque.getPosX()<=x+7));
						break;
					case KeyEvent.VK_LEFT :
						if(tanque.getPosX()< x)
						puede=!((tanque.getPosY()<=y && tanque.getPosY()+tanque.getLado()>=y) && ((tanque.getPosX()+tanque.getLado())>= x));
						break;
					}
				}
			}
		}
	return puede;
	}
	public boolean DisparoPuedeEstarAca(float x, float y,int direccion,DisparoEnemigo d){
		if(y<0 || x<0 || y>484+32|| x>484+32){
			return false;
		}
		boolean puede=true;
		puede= mapa.getCelda((int)(x/h),(int) (y/w)).PuedePasarDisparo();
		if(puede){
			switch(direccion){
			case KeyEvent.VK_UP :		 // direccion representa la direccion CON LA QUE SALIO EL disparo
				if(player.getPosY()< y)
				puede=!((player.getPosX()<=x && player.getPosX()+player.getLado()>=x) && (player.getPosY()+player.getLado()>= y));
				break;
			case KeyEvent.VK_DOWN :
				if(player.getPosY()> y)
					puede=!((player.getPosX()<=x && player.getPosX()+player.getLado()>=x) && (player.getPosY()<= (y+7)));
				break;
			case KeyEvent.VK_RIGHT :
				if(player.getPosX()> x)
				puede=!((player.getPosY()<=y && player.getPosY()+player.getLado()>=y) && (player.getPosX()<=x+7));
				break;
			case KeyEvent.VK_LEFT :
				if(player.getPosX()< x)
				puede=!((player.getPosY()<=y && player.getPosY()+player.getLado()>=y) && ((player.getPosX()+player.getLado())>= x));
				break;
			}
			if(!puede){ /// Si no puede pasar en este punto quiere decir que colisiono con el ultimo enemigo checkeado
				player.serAfectado(d);
			}
		}
		
		return puede;
	}
	public boolean DisparoPuedeEstarAca(float x, float y,int direccion,DisparoAliado d){
		if(y<0 || x<0 || y>484+32|| x>484+32){
			return false;
		}
		boolean puede;
		if(mapa.getCelda((int)(x/h),(int) (y/w))!=null)
			puede= mapa.getCelda((int)(x/h),(int) (y/w)).PuedePasarDisparo();
		else
			puede=true;
		Iterator<Tanque> it=tanques.iterator();
		
		while(it.hasNext()&& puede){
			Tanque ene=it.next();
			switch(direccion){
			case KeyEvent.VK_UP :		 // direccion representa la direccion CON LA QUE SALIO EL disparo
				if(ene.getPosY()< y)
				puede=!((ene.getPosX()<=x && ene.getPosX()+ene.getLado()>=x) && (ene.getPosY()+ene.getLado()>= y));
				break;
			case KeyEvent.VK_DOWN :
				if(ene.getPosY()> y)
					puede=!((ene.getPosX()<=x && ene.getPosX()+ene.getLado()>=x) && (ene.getPosY()<= (y+7)));
				break;
			case KeyEvent.VK_RIGHT :
				if(ene.getPosX()> x)
				puede=!((ene.getPosY()<=y && ene.getPosY()+ene.getLado()>=y) && (ene.getPosX()<=x+7));
				break;
			case KeyEvent.VK_LEFT :
				if(ene.getPosX()< x)
				puede=!((ene.getPosY()<=y && ene.getPosY()+ene.getLado()>=y) && ((ene.getPosX()+ene.getLado())>= x));
				break;
			}
			if(!puede){ /// Si no puede pasar en este punto quiere decir que colisiono con el ultimo enemigo checkeado
				ene.serAfectado(d);
			}
		}
		return puede;	
	}
		
	public float[] getPosXInicialTanque(){
		//164 480
		float[] toRet={164,480};
		return toRet;
	}
	public void gameOver(){}
	public void crearPU(){
		
	}
}