package Tanque;

import java.util.Random;

public class Nivel1 extends Nivel{
	public Nivel1(){
		this.DisparosSimultaneos=1;
		this.GolpesQueResiste=1;
		this.VelocidadD=1;
		this.VelocidadM=1;  ///// aca tiene que ir 2
		this.img=new String[4];
		this.img[0]="/imagenes/lvl1-37"+state+".png";
		this.img[1]="/imagenes/lvl1-38"+state+".png";
		this.img[2]="/imagenes/lvl1-39"+state+".png";
		this.img[3]="/imagenes/lvl1-40"+state+".png";
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel2();
	}
	public boolean getdestruyeMetal(){
		return false;
	}
	public int getEnemigoRandom(){
		Random rnd=new Random();
		int  i=rnd.nextInt(10);
		if(i<=3)
			return 0;
		else{
			if(i<=6){
				return 1;
			}else{
				if(i<=8)
					return 2;
				else
					return 3;
			}
		}				
	}

	@Override
	public void refreshImg() {
		this.img[0]="/imagenes/lvl1-37"+state+".png";
		this.img[1]="/imagenes/lvl1-38"+state+".png";
		this.img[2]="/imagenes/lvl1-39"+state+".png";
		this.img[3]="/imagenes/lvl1-40"+state+".png";
	}
}
