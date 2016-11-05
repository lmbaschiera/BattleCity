package Tanque;

import java.awt.event.KeyEvent;

import Game.EntidadGrafica;
import Game.GameObject;
import Game.InterfazGui;
import Game.Juego;
import Pisos.Celda;
import Pisos.Ladrillo;

public class Disparo extends GameObject implements Runnable {
	protected int velocidad;
	protected boolean romperMetal;
	protected Tanque MiTanque;
	protected int corrimiento_x,corrimiento_y;
	protected int direccion;
	private volatile boolean execute;
	public Disparo(Juego juego,InterfazGui gui, Tanque tanque,int velocidad, boolean romperMetal, float x, float y,int lastMovement){
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
	public void run(){
		try{
			
			execute = true;
			while (execute){
			if(juego.DisparoPuedeEstarAca(posX+(corrimiento_x*velocidad), posY+(corrimiento_y*velocidad),this.direccion)){
				posX+=corrimiento_x*velocidad;
				posY+=corrimiento_y*velocidad;
				gui.moverEntidad(this.grafico, (int)posX, (int)posY);
				Thread.sleep(10);
			}
			else{
				execute=false;
			}
		}
			MiTanque.aumentarDisparosDisponibles();
			if (gui.getMapa().getCelda((int)(posX+(corrimiento_x*velocidad))/40, (int)(posY+(corrimiento_y*velocidad))/40)!=null)
				gui.getMapa().getCelda((int)(posX+(corrimiento_x*velocidad))/40, (int)(posY+(corrimiento_y*velocidad))/40).serAfectado(this);
			gui.eliminarEntidad(grafico);
	}
		catch(InterruptedException e1){}

}

	public boolean canI(){
		return romperMetal;
	}

	public void afectar(Celda c) {
		c.vida(romperMetal);
	}

	
}