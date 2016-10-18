package Tanque;

public class Nivel4 extends Nivel {
	public Nivel4(){
		this.DisparosSimultaneos=3;
		this.GolpesQueResiste=4;
		this.VelocidadD=3;
		this.VelocidadM=2;
		this.img=new String[4];
		/*this.img[0]="/imagenes/alternativo37.png";
		this.img[1]="/imagenes/alternativo38.png";
		this.img[2]="/imagenes/alternativo39.png";
		this.img[3]="/imagenes/alternativo40.png";*/
		this.img[0]="/imagenes/lvl4-37.png";
		this.img[1]="/imagenes/lvl4-38.png";
		this.img[2]="/imagenes/lvl4-39.png";
		this.img[3]="/imagenes/lvl4-40.png";
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel1(); //return null;
	}
	public boolean getdestruyeMetal(){
		return true;
	}
}
