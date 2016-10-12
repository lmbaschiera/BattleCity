package Pisos;

import Game.Mapa;
import Tanque.Disparo;

public class Aguila extends Celda {
	public Aguila(Mapa mapa,int x, int y){
		this.mapa=mapa;
		this.posX=x;
		this.posY=y;
		this.vida=1;
	}/*
	@Override
	public void afectar() {
		//destruir
	}

	@Override
	public String getImg() {
		return "/imagenes/Aguila.png";
	}*/

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
		
	}

	@Override
	public void vida(boolean p) {
		vida--;//terminar juego
	}
}
