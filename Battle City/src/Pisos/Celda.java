package Pisos;

import Game.EntidadGrafica;
import Game.GameObject;
import Game.InterfazMapa;
import Game.Juego;
import Game.Mapa;
import PU.PowerUp;
import Tanque.Disparo;

public abstract class Celda extends GameObject {
	
	protected PowerUp obj;
	protected int vida;
	protected InterfazMapa mapa;
	public void setX(float x){
		posX= x;
	}
	
	public void setY(float y){
		posY= y;
	}
	
	public float getX() {
		return posX;
	}
	
	public EntidadGrafica getEntidadGrafica(){
		return grafico;
	}
	public float getY() {
		return posY;
	}
	public void setPU(PowerUp obj){
		this.obj=obj;
	}
	public abstract boolean PuedePasarTanque();
	public abstract boolean PuedePasarDisparo();
	public abstract void serAfectado(Disparo d,Juego j);
	public PowerUp getPU(){
		return this.obj;
	}
}
