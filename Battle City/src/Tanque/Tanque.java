package Tanque;

import Game.EntidadGrafica;
import Game.GameObject;
import Game.Juego;

public abstract class Tanque implements GameObject {
	protected float posX;
	protected float posY;
	protected int disparosDisponibles;
	protected Nivel level;
	protected EntidadGrafica grafico;
	protected int lastMovement;
	
	public EntidadGrafica getGrafico(){
		return grafico;
	}
	public void setGrafico(EntidadGrafica grafico){
		this.grafico=grafico;
	}
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
}
