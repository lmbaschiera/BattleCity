package Tanque;

import javax.swing.ImageIcon;

import Game.EntidadGrafica;

public class Nivel2 extends Nivel {
	public Nivel2(){
		this.DisparosSimultaneos=1;
		this.GolpesQueResiste=1;
		this.VelocidadD=2;
		this.VelocidadM=3;
		this.img=new EntidadGrafica[4];
		this.img[0]=new EntidadGrafica("/imagenes/lvl2-37.png", 32, 32);
		this.img[1]=new EntidadGrafica("/imagenes/lvl2-38.png", 32, 32);
		this.img[2]=new EntidadGrafica("/imagenes/lvl2-39.png", 32, 32);
		this.img[3]=new EntidadGrafica("/imagenes/lvl2-40.png", 32, 32);
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel3();
	}
	public boolean getdestruyeMetal(){
		return false;
	}
}
