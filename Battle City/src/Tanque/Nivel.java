package Tanque;

import Game.EntidadGrafica;

public abstract class Nivel {
	protected int GolpesQueResiste;
	protected int VelocidadM,VelocidadD;
	protected int DisparosSimultaneos;
	protected boolean destruyeMetal;
	protected String[] img;
	
	public int getGolpesQueResiste(){
		return this.GolpesQueResiste;
	}
	public int getVelocidadM(){
		return this.VelocidadM;
	}
	public int getVelocidadD(){
		return this.VelocidadD;
	}
	public int getDisparosSimultaneos(){
		return this.DisparosSimultaneos;
	}
	public abstract boolean getdestruyeMetal();
	public abstract Nivel getSiguiente();
	public String getImg(int i){
		return img[i];
	}
}
