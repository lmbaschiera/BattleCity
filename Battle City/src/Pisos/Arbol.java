package Pisos;

import Game.EntidadGrafica;
import Game.Mapa;
import Tanque.Disparo;

import javax.swing.JLabel;

public class Arbol extends Celda{
	public Arbol(Mapa mapa,int x, int y){
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
	public void serAfectado(Disparo d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vida(boolean p) {
		
	}
}
