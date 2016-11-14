package PU;

import Game.EntidadGrafica;
import Game.Juego;
import Game.Sonido;
import Tanque.Jugador;

public class Casco extends PowerUp {
	public Casco(Juego j, int x, int y){
		e=new EntidadGrafica("/imagenes/pu1.gif",32,32);
		this.juego = j;
		this.posX=x;
		this.posY=y;
	}
	
	@Override
	public void run() {
		int tiempo =5000;
		this.juego.getJugador().setInvulnerable();
		this.juego.musica();
		Sonido s=new Sonido("starman");
		s.loop();
		int actual = 0;
		while (tiempo>actual){
			actual+=100;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
		this.juego.getJugador().setInvulnerable();
		s.frenar();
		this.juego.musica();
	}

	@Override
	public void afectar(Jugador j) {
		Thread t1 = new Thread(this);
		t1.start();
	}

}
