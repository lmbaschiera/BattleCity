package Tanque;

public class Nivel1 extends Nivel{
	public Nivel1(){
		this.DisparosSimultaneos=1;
		this.GolpesQueResiste=1;
		this.VelocidadD=1;
		this.VelocidadM=1;  ///// aca tiene que ir 2
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel2();
	}
}
