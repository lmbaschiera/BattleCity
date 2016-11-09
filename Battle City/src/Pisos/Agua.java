package Pisos;

import Game.EntidadGrafica;
import Game.InterfazMapa;
import Game.Juego;
import Tanque.Disparo;

public class Agua extends Celda{
	public Agua(InterfazMapa mapa,int x, int y){
		this.grafico=new EntidadGrafica("/imagenes/azul.png", 40,40);
		this.mapa=mapa;
		this.posX=x;
		this.posY=y;
		this.obj=null;
	}

	@Override
	public boolean PuedePasarTanque() {
		return false;
	}

	
	
	@Override
	public boolean PuedePasarDisparo() {
		return true;
	}

	@Override
	public void serAfectado(Disparo d,Juego j) {}

}
