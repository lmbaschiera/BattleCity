package Tanque;

public class NivelBlindado extends Nivel{
	public NivelBlindado(){
		this.DisparosSimultaneos=1;
		this.GolpesQueResiste=4;
		this.VelocidadD=2;
		this.VelocidadM=1;  ///// aca tiene que ir 2
		this.img=new String[4];
		this.img[0]="/imagenes/enemy4-37.png";
		this.img[1]="/imagenes/enemy4-38.png";
		this.img[2]="/imagenes/enemy4-39.png";
		this.img[3]="/imagenes/enemy4-40.png";
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel2();
	}
	public boolean getdestruyeMetal(){
		return false;
	}
}
