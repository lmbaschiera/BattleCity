package PU;

import Game.EntidadGrafica;
import Game.GameObject;
import Game.Juego;
import Tanque.Jugador;

public abstract class PowerUp extends GameObject implements Runnable {
	protected Juego juego;
	protected EntidadGrafica e;
	
	
	public abstract void afectar(Jugador j);
	public EntidadGrafica getGrafico(){
		return e;
		
	}
}
