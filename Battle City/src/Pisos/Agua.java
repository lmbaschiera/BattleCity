package Pisos;

import Game.Mapa;

public class Agua extends Celda{
	public Agua(Mapa mapa,int x, int y){
		this.mapa=mapa;
		this.posX=x;
		this.posY=y;
	}

	@Override
	public boolean PuedePasarTanque() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getImg() {
		// TODO Auto-generated method stub
		return "/imagenes/azul.png";
	}
	
	@Override
	public boolean PuedePasarDisparo() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void afectar() {}
}
