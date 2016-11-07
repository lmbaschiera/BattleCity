package Pisos;

import Game.EntidadGrafica;
import Game.Mapa;
import Tanque.Disparo;

public class Metal extends Celda {
	public Metal(Mapa mapa,int x, int y){
		this.grafico=new EntidadGrafica("/imagenes/blanco.png", 40,40);
		this.mapa=mapa;
		this.posX=x;
		this.posY=y;
		this.vida=4;
	}

	@Override
	public boolean PuedePasarTanque() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean PuedePasarDisparo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void serAfectado(Disparo d) {
		if (d.canI()){
			d.afectarCelda(this);
		}
	}

	public void vida(boolean p){
		System.out.println(""+this.vida);
		if (p){
			vida--;
			if(vida==0)
				mapa.eliminarCelda(this);
		}
	}

}

