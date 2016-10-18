package Tanque;

public class NivelPoder extends Nivel{
	public NivelPoder(){
		this.DisparosSimultaneos=1;
		this.GolpesQueResiste=1;
		this.VelocidadD=3;
		this.VelocidadM=2;
		this.img=new String[4];
		this.img[0]="/imagenes/helicoptero37.gif";
		this.img[1]="/imagenes/helicoptero38.gif";
		this.img[2]="/imagenes/helicoptero39.gif";
		this.img[3]="/imagenes/helicoptero40.gif";
	}

	@Override
	public Nivel getSiguiente() {
		return new Nivel2();
	}
	public boolean getdestruyeMetal(){
		return false;
	}
}
