package Pisos;

import Game.EntidadGrafica;
import Game.InterfazMapa;
import Game.Juego;
import Game.Sonido;
import Tanque.Disparo;

public class Metal extends Celda {
	public Metal(InterfazMapa mapa,int x, int y){
		this.grafico=new EntidadGrafica("/imagenes/blanco.png", 40,40);
		this.mapa=mapa;
		this.posX=x;
		this.posY=y;
		this.vida=4;
	}

	@Override
	public boolean PuedePasarTanque() {
		return false;
	}

	
	public boolean PuedePasarDisparo() {
		return false;
	}
	public String setImg(){
		switch(vida){
		case(4):
			return "/imagenes/blanco.png";
		case(3):
			return "/imagenes/blanco2.png";
		case(2):
			return "/imagenes/blanco3.png";
		case(1):
			return "/imagenes/blanco4.png";
		}
		return null;
	}

	@Override
	public void serAfectado(Disparo d,Juego j) {
		if (d.canI()){
			vida--;
			if (vida>0)
				grafico.cambiarImagen(this.setImg());
			else{
				Sonido s = new Sonido("Break");
				s.play();
				mapa.eliminarCelda(this);
		}
		}
	}
}

