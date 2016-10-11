package Tanque;

public class Nivel2 extends Nivel {
	public Nivel2(){
		this.DisparosSimultaneos=1;
		this.GolpesQueResiste=1;
		this.VelocidadD=2;
		this.VelocidadM=3;
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel3();
	}
	public boolean getdestruyeMetal(){
		return false;
	}
}
