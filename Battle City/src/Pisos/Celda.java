package Pisos;

import javax.swing.JLabel;

import Game.GameObject;

public abstract class Celda {
	protected float posX,posY;
	protected String img;
	protected GameObject obj;
	protected JLabel label;//protected EntidadGrafica grafico;
	public void setX(float x){
		posX= x;
	}
	
	public void setY(float y){
		posY= y;
	}
	
	public float getX() {
		return posX;
		
	}
	public void setGraficos(JLabel jl){
		this.label=jl;
	}
	public JLabel getGraficos(){
		return label;
	}
	public float getY() {
		return posY;
	}
	public void setGObject(GameObject obj){
		this.obj=obj;
	}
	public abstract String getImg();
	public abstract boolean PuedePasarTanque();
}
