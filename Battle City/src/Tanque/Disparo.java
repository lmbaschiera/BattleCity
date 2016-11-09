package Tanque;

import java.awt.event.KeyEvent;

import Game.EntidadGrafica;
import Game.GameObject;
import Game.InterfazGui;
import Game.Juego;


public abstract class Disparo extends GameObject implements Runnable {
	protected int velocidad;
	protected boolean romperMetal;
	protected Tanque MiTanque;
	protected int corrimiento_x,corrimiento_y;
	protected int direccion;
	protected volatile boolean execute;
	protected Disparo(Juego juego,InterfazGui gui, Tanque tanque,int velocidad, boolean romperMetal, float x, float y,int lastMovement){
		MiTanque=tanque;
		this.juego=juego;
		this.posX=x;
		this.posY=y;
		this.velocidad=velocidad;
		this.romperMetal=romperMetal;
		this.direccion=lastMovement;
		switch(lastMovement){
		case KeyEvent.VK_UP :
			this.corrimiento_y=-1;
			break;
		case KeyEvent.VK_DOWN :
			this.corrimiento_y=1;
			break;
		case KeyEvent.VK_RIGHT :
			this.corrimiento_x=1;
			break;
		case KeyEvent.VK_LEFT :
			this.corrimiento_x=-1;
			break;
		}

		this.grafico=new EntidadGrafica("/imagenes/disparo.png", 7, 7);
		this.gui=gui;
	}
	

	public boolean canI(){
		return romperMetal;
	}

	
}