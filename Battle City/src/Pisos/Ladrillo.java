package Pisos;

import Game.EntidadGrafica;
import Game.Mapa;
import Tanque.Disparo;

public class Ladrillo extends Celda{
	public Ladrillo(Mapa mapa,int x, int y){
		this.grafico=new EntidadGrafica("/imagenes/rojo.png", 40,40);
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
	public void vida(boolean p){
		vida--;
		if(vida>0)
			grafico.cambiarImagen(this.setImg());
		else{
			mapa.eliminarCelda(this);
		}
	}
	public boolean PuedePasarDisparo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void serAfectado(Disparo d) {
		d.afectar(this);
		
	}

	
}
