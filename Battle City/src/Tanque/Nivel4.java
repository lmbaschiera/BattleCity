package Tanque;

public class Nivel4 extends Nivel {
	public Nivel4(){
		this.DisparosSimultaneos=3;
		this.GolpesQueResiste=4;
		this.VelocidadD=3;
		this.VelocidadM=2;
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel1(); //return null;
	}
}
