package Pisos;

import Game.EntidadGrafica;
import Game.InterfazMapa;
import Game.Juego;
import Tanque.Disparo;

public class Ladrillo extends Celda{
	public Ladrillo(InterfazMapa mapa,int x, int y){
		this.grafico=new EntidadGrafica("/imagenes/rojo.png", 40,40);
		this.mapa=mapa;
		this.posX=x;
		this.posY=y;
		this.vida=4;
	}

	@Override
	public boolean PuedePasarTanque() {
		return false;
	}

	public String setImg(){
		switch(vida){
		case(4):
			return "/imagenes/rojo.png";
		case(3):
			return "/imagenes/amarillo.png";
		case(2):
			return "/imagenes/azul.png";
		case(1):
			return "/imagenes/verde.png";
		}
		return null;
	}
	public boolean PuedePasarDisparo() {
		return false;
	}

	@Override
	public void serAfectado(Disparo d,Juego j) {
		vida--;
		if(vida>0)
			grafico.cambiarImagen(this.setImg());
		else{
			mapa.eliminarCelda(this);
		}
	}

	
}
