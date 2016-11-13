package Tanque;



public abstract class Nivel {
	protected int GolpesQueResiste;
	protected int VelocidadM,VelocidadD;
	protected int DisparosSimultaneos;
	protected boolean destruyeMetal;
	protected String[] img;
	protected String state="";
	
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
		return img[i-37];
	}
	public int getPuntaje(){
		return 0;
	}
	public int getEnemigoRandom(){
		return 0;
	}
	public abstract void refreshImg();
}
