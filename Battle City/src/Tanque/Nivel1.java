package Tanque;

import javax.swing.ImageIcon;

import Game.EntidadGrafica;

public class Nivel1 extends Nivel{
	public Nivel1(){
		this.DisparosSimultaneos=1;
		this.GolpesQueResiste=1;
		this.VelocidadD=1;
		this.VelocidadM=1;  ///// aca tiene que ir 2
		this.img=new String[4];
		this.img[0]="/imagenes/lvl1-37.png";
		this.img[1]="/imagenes/lvl1-38.png";
		this.img[2]="/imagenes/lvl1-39.png";
		this.img[3]="/imagenes/lvl1-40.png";
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel2();
	}
	public boolean getdestruyeMetal(){
		return false;
	}
}
