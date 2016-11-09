package Pisos;

import Game.EntidadGrafica;
import Game.InterfazMapa;
import Game.Juego;
import Tanque.Disparo;

public class Arbol extends Celda{
	public Arbol(InterfazMapa mapa,int x, int y){
		this.grafico= new EntidadGrafica("/imagenes/Arbol2.png", 40,40);
		this.mapa=mapa;
		this.posX=x;
		this.posY=y;
	}

	public boolean PuedePasarTanque	() {
		
		return true;
	}

	public boolean PuedePasarDisparo() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void serAfectado(Disparo d,Juego j) {
		// TODO Auto-generated method stub
		
	}
}
