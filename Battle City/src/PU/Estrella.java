package PU;

import Game.Juego;
import Tanque.Jugador;

public class Estrella extends PowerUp{

	public Estrella(Juego j){
		this.juego = j;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Jugador j) {
		j.subirNivel();
		System.out.println("POWER UP ACTIVADO");
	}

}
