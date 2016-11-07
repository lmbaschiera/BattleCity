package PU;

import Game.Juego;
import Tanque.Jugador;

public class Granada extends PowerUp{
	public Granada(Juego j){
		this.juego = j;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Jugador j) {
		System.out.println("POWER UP ACTIVADO");
		int i = 1;
		while(i<this.juego.cantEnemigosON()){
			System.out.println("ahora quedan "+this.juego.cantEnemigosON());
			this.juego.eliminarMalo(this.juego.getEnemigo(i));
		}
			
	}

}
