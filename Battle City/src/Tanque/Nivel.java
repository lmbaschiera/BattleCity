package Tanque;

public abstract class Nivel {
	protected int GolpesQueResiste;
	protected int VelocidadM,VelocidadD;
	protected int DisparosSimultaneos;
	
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
	public abstract Nivel getSiguiente();
}
