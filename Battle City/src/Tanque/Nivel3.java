package Tanque;

public class Nivel3 extends Nivel{
	public Nivel3(){
		this.DisparosSimultaneos=2;
		this.GolpesQueResiste=2;
		this.VelocidadD=2;
		this.VelocidadM=2;
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel4();
	}
	public boolean getdestruyeMetal(){
		return false;
	}
}
