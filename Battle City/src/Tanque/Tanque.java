package Tanque;

import Game.EntidadGrafica;
import Game.GameObject;
import Game.Juego;

public abstract class Tanque extends GameObject {
	
	protected int disparosDisponibles, golpesQueResiste;
	protected Nivel level;
	protected int lastMovement;
	
	public Nivel getNivel(){
		return level;
	}
	public void aumentarDisparosDisponibles(){
		disparosDisponibles++;
	}
// capaz hay que sacarlo
	
	public void disminuirDisparosDisponibles(){
		disparosDisponibles--;
	}
	public int getLado(){
		return this.grafico.getH();
	}
	public int getLastMovement(){
		return this.lastMovement;
	}
	public abstract void  serAfectado(Disparo d);
}
