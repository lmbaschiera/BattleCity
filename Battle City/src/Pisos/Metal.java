package Pisos;

import Game.Mapa;

public class Metal extends Celda {
	public Metal(Mapa mapa,int x, int y){
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
		return "/imagenes/Pared.png";
	}
	public boolean PuedePasarDisparo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afectar() {
		// TODO Auto-generated method stub
		
	}
}
