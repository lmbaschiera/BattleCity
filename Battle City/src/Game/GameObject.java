package Game;

public abstract class GameObject {
	protected float posX,posY;
	protected EntidadGrafica grafico;
	protected InterfazGui gui;
	protected Juego juego;
	public EntidadGrafica getGrafico(){
		return grafico;
	}
	public float getPosX(){
		return posX;
	}
	public float getPosY(){
		return posY;
	}
}
