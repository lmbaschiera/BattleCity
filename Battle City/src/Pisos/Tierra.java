package Pisos;

import Game.Mapa;

public class Tierra extends Celda {

	public Tierra(Mapa mapa,int x, int y){
		this.mapa=mapa;
		this.posX=x;
		this.posY=y;
	}
	@Override
	public void afectar() {
	}

	@Override
	public String getImg() {
		return "/imagenes/marron.png";
	}

	@Override
	public boolean PuedePasarTanque() {
		return true;
	}

	@Override
	public boolean PuedePasarDisparo() {
		return true;
	}

}
