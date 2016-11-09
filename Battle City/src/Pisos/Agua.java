package Pisos;

import Game.EntidadGrafica;
import Game.InterfazMapa;
import Game.Juego;
import Game.Mapa;
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
		// TODO Auto-generated method stub
		return false;
	}

	
	
	@Override
	public boolean PuedePasarDisparo() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void serAfectado(Disparo d,Juego j) {}

}
