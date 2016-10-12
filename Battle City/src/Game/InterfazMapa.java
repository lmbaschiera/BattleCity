package Game;

import Pisos.Celda;

public interface InterfazMapa {
	public void armarMapa(String str);
	public Celda getCelda(int x,int y);
	public void setCelda(Celda celda, int x, int y);
	public int getTamaño();
	public void setGui(InterfazGui gui);
	public void eliminarCelda(Celda c);
}
