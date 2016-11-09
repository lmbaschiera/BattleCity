package PU;

import Game.EntidadGrafica;
import Game.Juego;
import Tanque.Jugador;

public class TanquePU extends PowerUp{
	public TanquePU(Juego j, int x, int y){
		e=new EntidadGrafica("/imagenes/pu6.gif",32,32);
		this.juego = j;
		this.posX=x;
		this.posY=y;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Jugador j) {
		System.out.println("POWER UP ACTIVADO");
		j.aumentarVida();
	}

}
