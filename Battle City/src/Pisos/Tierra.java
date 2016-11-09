package Pisos;

import Game.EntidadGrafica;
import Game.InterfazMapa;
import Game.Juego;
import Game.Mapa;
import Tanque.Disparo;

public class Tierra extends Celda {
	public Tierra(InterfazMapa mapa,int x, int y){
		this.grafico=new EntidadGrafica("/imagenes/marron.png", 40,40);
		this.mapa=mapa;
		this.posX=x;
		this.posY=y;
	}
	@Override
	public boolean PuedePasarTanque() {
		return true;
	}

	@Override
	public boolean PuedePasarDisparo() {
		return true;
	}

	@Override
	public void serAfectado(Disparo d,Juego j) {
		
	}

}
