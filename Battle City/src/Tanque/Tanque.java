package Tanque;

import Game.GameObject;
import PU.PowerUp;

public abstract class Tanque extends GameObject {
	
	protected int disparosDisponibles, golpesQueResiste;
	protected Nivel level;
	protected int lastMovement;
	
	public Nivel getNivel(){
		return level;
	}
	public void aumentarDisparosDisponibles(){
		if(this.getNivel().getDisparosSimultaneos()!=this.disparosDisponibles)
		disparosDisponibles++;
	}
// capaz hay que sacarlo
	
	public void disminuirDisparosDisponibles(){
		disparosDisponibles--;
	}
	public int getHits() {
		return golpesQueResiste;
	}
	public int getLado(){
		return this.grafico.getH();
	}
	public int getLastMovement(){
		return this.lastMovement;
	}
	public abstract void  serAfectado(Disparo d);
	public abstract void serAfectado(PowerUp pu);
}
