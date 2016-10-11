package Pisos;

public class Metal extends Celda {
	public Metal(int x, int y){
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
		return "/imagenes/Pared.png";
	}
}
