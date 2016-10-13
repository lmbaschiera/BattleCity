package Tanque;

public class NivelLento extends Nivel{
	public NivelLento(){
		this.DisparosSimultaneos=1;
		this.GolpesQueResiste=1;
		this.VelocidadD=1;
		this.VelocidadM=1;  ///// aca tiene que ir 2
		this.img=new String[4];
		this.img[0]="/imagenes/enemy1-37.png";
		this.img[1]="/imagenes/enemy1-38.png";
		this.img[2]="/imagenes/enemy1-39.png";
		this.img[3]="/imagenes/enemy1-40.png";
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel2();
	}
	public boolean getdestruyeMetal(){
		return false;
	}
}
