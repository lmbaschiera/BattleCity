package Tanque;

import java.util.Random;

public class Nivel3 extends Nivel{
	public Nivel3(){
		this.DisparosSimultaneos=2;
		this.GolpesQueResiste=2;
		this.VelocidadD=2;
		this.VelocidadM=2;
		this.img=new String[4];
		this.img[0]="/imagenes/lvl3-37"+state+".png";
		this.img[1]="/imagenes/lvl3-38"+state+".png";
		this.img[2]="/imagenes/lvl3-39"+state+".png";
		this.img[3]="/imagenes/lvl3-40"+state+".png";
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel4();
	}
	public boolean getdestruyeMetal(){
		return false;
	}
	public int getEnemigoRandom(){
		Random rnd=new Random();
		int  i=rnd.nextInt(10);
		if(i<=3)
			return 2;
		else{
			if(i<=6){
				return 3;
			}else{
				if(i<=8)
					return 0;
				else
					return 1;
			}
		}				
	}
	public void refreshImg() {
		this.img[0]="/imagenes/lvl3-37"+state+".png";
		this.img[1]="/imagenes/lvl3-38"+state+".png";
		this.img[2]="/imagenes/lvl3-39"+state+".png";
		this.img[3]="/imagenes/lvl3-40"+state+".png";
	}
}
