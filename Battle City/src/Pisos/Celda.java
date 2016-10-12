package Pisos;

import Game.EntidadGrafica;
import Game.GameObject;
import Game.InterfazMapa;
import Game.Mapa;
import Tanque.Disparo;

public abstract class Celda extends GameObject {
	
	protected GameObject obj;
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
	public void setGObject(GameObject obj){
		this.obj=obj;
	}
	public abstract boolean PuedePasarTanque();
	public abstract boolean PuedePasarDisparo();
	public abstract void serAfectado(Disparo d);
	public abstract void vida(boolean romperMetal);
}
