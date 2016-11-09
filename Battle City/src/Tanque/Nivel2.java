package Tanque;

import java.util.Random;

public class Nivel2 extends Nivel {
	public Nivel2(){
		this.DisparosSimultaneos=1;
		this.GolpesQueResiste=1;
		this.VelocidadD=2;
		this.VelocidadM=3;
		this.img=new String[4];
		this.img[0]="/imagenes/lvl2-37.png";
		this.img[1]="/imagenes/lvl2-38.png";
		this.img[2]="/imagenes/lvl2-39.png";
		this.img[3]="/imagenes/lvl2-40.png";
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel3();
	}
	public boolean getdestruyeMetal(){
		return false;
	}
	public int getEnemigoRandom(){
		Random rnd=new Random();
		int  i=rnd.nextInt(10);
		if(i<=3)
			return 1;
		else{
			if(i<=6){
				return 0;
			}else{
				if(i<=8)
					return 3;
				else
					return 2;
			}
		}				
	}
}
