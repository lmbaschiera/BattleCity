package Tanque;

import javax.swing.ImageIcon;

import Game.EntidadGrafica;

public class Nivel3 extends Nivel{
	public Nivel3(){
		this.DisparosSimultaneos=2;
		this.GolpesQueResiste=2;
		this.VelocidadD=2;
		this.VelocidadM=2;
		this.img=new EntidadGrafica[4];
		this.img[0]=new EntidadGrafica("/imagenes/lvl3-37.png", 32, 32);
		this.img[1]=new EntidadGrafica("/imagenes/lvl3-38.png", 32, 32);
		this.img[2]=new EntidadGrafica("/imagenes/lvl3-39.png", 32, 32);
		this.img[3]=new EntidadGrafica("/imagenes/lvl3-40.png", 32, 32);
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel4();
	}
	public boolean getdestruyeMetal(){
		return false;
	}
}
