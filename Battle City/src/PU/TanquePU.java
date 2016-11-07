package PU;

import Game.Juego;
import Tanque.Jugador;

public class TanquePU extends PowerUp{
	public TanquePU(Juego j){
		this.juego = j;
		
		
		
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
