package Pisos;

public class Ladrillo extends Celda{
	public int vida=4;
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
		return "/imagenes/rojo.png";
	}
	
	public String setImg(){
		switch(vida){
		case(4):
			return "/imagenes/rojo.png";
		case(3):
			return "/imagenes/amarillo.png";
		case(2):
			return "/imagenes/azul.png";
		case(1):
			return "/imagenes/verde.png";
		case(0):
			return null;
		}
		return null;
	}
	public void vida(){
		vida--;
	}
}
