package Pisos;

import Game.EntidadGrafica;
import Game.Mapa;
import Tanque.Disparo;

public class Aguila extends Celda {
	public Aguila(Mapa mapa,int x, int y){
		this.grafico=new EntidadGrafica("/imagenes/aguila.png", 40,40);
		this.mapa=mapa;
		this.posX=x;
		this.posY=y;
		this.vida=1;
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
	public void serAfectado(Disparo d) {
		vida(d.canI());
		
	}

	@Override
	public void vida(boolean p) {
		vida--;
	}
}
