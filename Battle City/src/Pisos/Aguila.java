package Pisos;

import Game.Mapa;

public class Aguila extends Celda {
	public Aguila(Mapa mapa,int x, int y){
		this.mapa=mapa;
		this.posX=x;
		this.posY=y;
	}
	@Override
	public void afectar() {
		//destruir
	}

	@Override
	public String getImg() {
		return "/imagenes/Aguila.png";
	}

	@Override
	public boolean PuedePasarTanque() {
		return false;
	}

	@Override
	public boolean PuedePasarDisparo() {
		return false;
	}
}
