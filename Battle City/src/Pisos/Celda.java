package Pisos;

import Game.EntidadGrafica;
import Game.GameObject;
import Game.Mapa;

public abstract class Celda implements GameObject {
	protected float posX,posY;
	protected String img;
	protected GameObject obj;
	protected EntidadGrafica grafico;
	protected Mapa mapa;
	public void setX(float x){
		posX= x;
	}
	
	public void setY(float y){
		posY= y;
	}
	
	public float getX() {
		return posX;
		
	}
	public void setGraficos(EntidadGrafica jl){
		this.grafico=jl;
	}
	public EntidadGrafica getGraficos(){
		return grafico;
	}
	public float getY() {
		return posY;
	}
	public void setGObject(GameObject obj){
		this.obj=obj;
	}
	public abstract String getImg();
	public abstract boolean PuedePasarTanque();
	public abstract boolean PuedePasarDisparo();
}
