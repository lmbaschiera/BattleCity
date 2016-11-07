package PU;

import Game.GameObject;
import Game.Juego;
import Tanque.Jugador;

public abstract class PowerUp extends GameObject implements Runnable {
	protected Juego juego;
	
	
	
	public abstract void afectar(Jugador j);
}
