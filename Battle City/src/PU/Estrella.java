package PU;

import Game.EntidadGrafica;
import Game.Juego;
import Tanque.Jugador;

public class Estrella extends PowerUp{

	public Estrella(Juego j, int x, int y){
		e=new EntidadGrafica("/imagenes/pu4.gif",32,32);
		this.juego = j;
		this.posX=x;
		this.posY=y;
	}
	
	
	@Override
	public void run() {
	}

	@Override
	public void afectar(Jugador j) {
		j.subirNivel();
	}

}
