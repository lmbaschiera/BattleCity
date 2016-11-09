package Pisos;

import Game.EntidadGrafica;
import Game.InterfazMapa;
import Game.Juego;
import Game.Mapa;
import Tanque.Disparo;

public class Aguila extends Celda {
	public Aguila(InterfazMapa mapa,int x, int y){
		this.grafico=new EntidadGrafica("/imagenes/aguila.png", 40,40);
		this.mapa=mapa;
		this.posX=x;
		this.posY=y;
		this.vida=1;
		this.obj=null;
	}
	
	@Override
	public boolean PuedePasarTanque() {
		return false;
	}

	@Override
	public boolean PuedePasarDisparo() {
		return false;
	}

	@Override
	public void serAfectado(Disparo d, Juego j) {
		j.gameOver();
	}
}
