package Game;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import PU.*;
import Pisos.*;
import Tanque.*;

public class Juego{
	private Jugador player;
	private Enemigo[] enemigos;
	private InterfazGui gui;
	private InterfazMapa mapa;
	private int puntaje;
	private static int h=40;
	private static int w=40;
	public Juego(){
		puntaje=0;
		enemigos= new Enemigo[15];
		player=new Jugador(this,0,0);
		gui=new gui(this);
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
		enemigos[0]=e;
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
	
	public InterfazMapa getMapa(){
		return mapa;
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
	public boolean DisparoPuedeEstarAca(float x, float y){
		if(y<0 || x<0 || y>484+32|| x>484+32){
			return false;
		}
		if(mapa.getCelda((int)(x/h),(int) (y/w))!=null)
			if(!mapa.getCelda((int)(x/h),(int) (y/w)).PuedePasarDisparo()){
				return false;
			}
			else{
				return true;
			}
		else
			return true;
	}
}
