package Tanque;

public class NivelRapido extends Nivel{
	public NivelRapido(){
		this.DisparosSimultaneos=1;
		this.GolpesQueResiste=1;
		this.VelocidadD=2;
		this.VelocidadM=2;  ///// aca tiene que ir 2
		this.img=new String[4];
		this.img[0]="/imagenes/enemy3-37.png";
		this.img[1]="/imagenes/enemy3-38.png";
		this.img[2]="/imagenes/enemy3-39.png";
		this.img[3]="/imagenes/enemy3-40.png";
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel2();
	}
	public boolean getdestruyeMetal(){
		return false;
	}
	public int getPuntaje(){
		return 200;
	}
}
