package Game;

import Tanque.Enemigo;

public interface InterfazGui {
	public void moverEntidad(EntidadGrafica e, int x, int y);
	public void eliminarEntidad(EntidadGrafica e);
	public void levantarEntidad(GameObject g);
	public void levantarMapa(InterfazMapa mapa);
	public int getMaxX();
	public int getMaxY();
	public InterfazMapa getMapa();
	//public void cambiarImagen(Enemigo enemigo, int dir);
}
