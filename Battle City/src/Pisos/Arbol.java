package Pisos;

import javax.swing.JLabel;

public class Arbol extends Celda{
	public Arbol(int x, int y){
		this.posX=x;
		this.posY=y;
	}

	public boolean PuedePasarTanque	() {
		
		return true;
	}

	@Override
	public String getImg() {
		return "/imagenes/Arbol2.png";
	}
}
