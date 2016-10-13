package Tanque;

public class NivelPoder extends Nivel{
	public NivelPoder(){
		this.DisparosSimultaneos=1;
		this.GolpesQueResiste=1;
		this.VelocidadD=3;
		this.VelocidadM=2;
		this.img=new String[4];
		this.img[0]="/imagenes/enemy2-37.png";
		this.img[1]="/imagenes/enemy2-38.png";
		this.img[2]="/imagenes/enemy2-39.png";
		this.img[3]="/imagenes/enemy2-40.png";
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel2();
	}
	public boolean getdestruyeMetal(){
		return false;
	}
}
