package Tanque;

import javax.swing.ImageIcon;

import Game.EntidadGrafica;

public class Nivel4 extends Nivel {
	public Nivel4(){
		this.DisparosSimultaneos=3;
		this.GolpesQueResiste=4;
		this.VelocidadD=3;
		this.VelocidadM=2;
		new EntidadGrafica("/imagenes/lvl4-37.png", 32, 32);
		this.img=new EntidadGrafica[4];
		this.img[0]=new EntidadGrafica("/imagenes/lvl4-37.png", 32, 32);
		this.img[1]=new EntidadGrafica("/imagenes/lvl4-38.png", 32, 32);
		this.img[2]=new EntidadGrafica("/imagenes/lvl4-39.png", 32, 32);
		this.img[3]=new EntidadGrafica("/imagenes/lvl4-40.png", 32, 32);
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel1(); //return null;
	}
	public boolean getdestruyeMetal(){
		return true;
	}
}
