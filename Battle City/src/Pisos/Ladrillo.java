package Pisos;

public class Ladrillo extends Celda{
	public Ladrillo(int x, int y){
		this.posX=x;
		this.posY=y;
	}

	@Override
	public boolean PuedePasarTanque() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getImg() {
		// TODO Auto-generated method stub
		return "/imagenes/Ladrillo.png";
	}
}
