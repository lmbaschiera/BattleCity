package Pisos;

import Game.Mapa;

public class Ladrillo extends Celda{
	private int vida=4;
	public Ladrillo(Mapa mapa,int x, int y){
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
		return "/imagenes/Ladrillo.png";
	}
	public boolean PuedePasarDisparo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afectar() {
		vida--;
		if(vida==0){
			
		}
	}
}
