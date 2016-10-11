package Pisos;

import Game.Mapa;

public class Arbol extends Celda{
	public Arbol(Mapa mapa,int x, int y){
		this.mapa=mapa;
		this.posX=x;
		this.posY=y;
	}

	public boolean PuedePasarTanque	() {
		
		return true;
	}

	@Override
	public String getImg() {
		return "/imagenes/Arbol.png";
	}
	public boolean PuedePasarDisparo() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void afectar() {}
}
