package Tanque;

import Game.EntidadGrafica;
import Game.Juego;

public class Disparo extends Thread {
	protected int velocidad;
	protected float X;
	protected float Y;
	protected boolean romperMetal;
	protected EntidadGrafica grafico;
	protected Tanque MiTanque;
	private volatile boolean execute;
	public Disparo(Tanque tanque,int velocidad, boolean romperMetal, EntidadGrafica grafico, float x, float y){
		MiTanque=tanque;
		this.X=x;
		this.Y=y;
		this.velocidad=velocidad;
		this.romperMetal=romperMetal;
		this.grafico=grafico;
	}
	public void run(Juego game,int x,int y){
		System.out.println("X: "+X+" Y: "+Y);
		try{
			while(game.DisparoPuedeEstarAca(X+(x*velocidad), Y+(y*velocidad))){
				X+=x*velocidad;
				Y+=y*velocidad;
				Thread.sleep(100);
				System.out.println("X: "+X+" Y: "+Y);
			}
			MiTanque.aumentarDisparosDisponibles();
		}catch(InterruptedException e1){}
	}
}