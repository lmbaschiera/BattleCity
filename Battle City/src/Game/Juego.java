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
	private PowerUp powerUpActivo;
	private GUI gui;
	private Mapa mapa;
	private int puntaje;
	private static int h=40;
	private static int w=40;
	public Juego(GUI gui){
		puntaje=0;
		enemigos= new Enemigo[15];
		player=new Jugador(0,0,this);
		mapa=new Mapa(13);
		
	}
	public int getPuntaje(){
		return puntaje;
	}
	public void crearMalo(){
		Enemigo e=new Enemigo();
		enemigos[0]=e;
		
	}
	public void eliminarMalo(){
		
		puntaje+=100;
	}
	public Jugador getJugador(){
		return player;
	}
	
	public Mapa getMapa(){
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
				mapa.getCelda((int)(x/h),(int) (y/w)).afectar();
				return false;
			}
			else{
				return true;
			}
		else
			return true;
	}
}

