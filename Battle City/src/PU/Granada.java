package PU;

import Game.EntidadGrafica;
import Game.Juego;
import Tanque.Jugador;

public class Granada extends PowerUp{
	public Granada(Juego j, int x, int y){
		e=new EntidadGrafica("/imagenes/pu5.gif",32,32);
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
		int i = 1;
		while(i<=this.juego.cantEnemigosON()){
			this.juego.eliminarMalo(this.juego.getEnemigo(i));
		}
			
	}

}
