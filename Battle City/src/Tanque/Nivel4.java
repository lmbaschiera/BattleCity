package Tanque;

import java.util.Random;

public class Nivel4 extends Nivel {
	public Nivel4(){
		this.DisparosSimultaneos=3;
		this.GolpesQueResiste=4;
		this.VelocidadD=3;
		this.VelocidadM=2;
		this.img=new String[4];
		/*this.img[0]="/imagenes/alternativo37.png";
		this.img[1]="/imagenes/alternativo38.png";
		this.img[2]="/imagenes/alternativo39.png";
		this.img[3]="/imagenes/alternativo40.png";*/
		this.img[0]="/imagenes/lvl4-37"+state+".png";
		this.img[1]="/imagenes/lvl4-38"+state+".png";
		this.img[2]="/imagenes/lvl4-39"+state+".png";
		this.img[3]="/imagenes/lvl4-40"+state+".png";
	}

	@Override
	public Nivel getSiguiente() {
		return this;
	}
	public boolean getdestruyeMetal(){
		return true;
	}
	public int getEnemigoRandom(){
		Random rnd=new Random();
		int  i=rnd.nextInt(10);
		if(i<=3)
			return 3;
		else{
			if(i<=6){
				return 2;
			}else{
				if(i<=8)
					return 1;
				else
					return 0;
			}
		}				
	}
	public void refreshImg() {
		this.img[0]="/imagenes/lvl4-37"+state+".png";
		this.img[1]="/imagenes/lvl4-38"+state+".png";
		this.img[2]="/imagenes/lvl4-39"+state+".png";
		this.img[3]="/imagenes/lvl4-40"+state+".png";
	}
}
