package PU;

import Game.EntidadGrafica;
import Game.Juego;
import Game.Mapa;
import Pisos.Metal;
import Tanque.Jugador;

public class Pala extends PowerUp{

	public Pala(Juego j, int x, int y){
		e=new EntidadGrafica("/imagenes/pu3.gif",32,32);
		this.juego = j;
		this.posX=x;
		this.posY=y;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Jugador j) {
		System.out.println("POWER UP ACTIVADO");
		//Este anda medio medio
		this.juego.getGui().getMapa().eliminarCelda(this.juego.getGui().getMapa().getCelda(5, 12));
		this.juego.getGui().getMapa().eliminarCelda(this.juego.getGui().getMapa().getCelda(5, 11));
		this.juego.getGui().getMapa().eliminarCelda(this.juego.getGui().getMapa().getCelda(6, 11));
		this.juego.getGui().getMapa().eliminarCelda(this.juego.getGui().getMapa().getCelda(7, 11));
		this.juego.getGui().getMapa().eliminarCelda(this.juego.getGui().getMapa().getCelda(7, 12));
		
		Metal m1 = new Metal((Mapa) this.juego.getGui().getMapa() , 5, 12);
		Metal m2 = new Metal((Mapa) this.juego.getGui().getMapa() , 5, 11);
		Metal m3 = new Metal((Mapa) this.juego.getGui().getMapa() , 6, 11);
		Metal m4 = new Metal((Mapa) this.juego.getGui().getMapa() , 7, 11);
		Metal m5 = new Metal((Mapa) this.juego.getGui().getMapa() , 7, 12);
		
		this.juego.getGui().getMapa().setCelda(m1,5,12);
		this.juego.getGui().getMapa().setCelda(m2,5,11);
		this.juego.getGui().getMapa().setCelda(m3,6,11);
		this.juego.getGui().getMapa().setCelda(m4,7,11);
		this.juego.getGui().getMapa().setCelda(m5,7,12);
		
		this.juego.getGui().levantarEntidad(m1);
		this.juego.getGui().levantarEntidad(m2);
		this.juego.getGui().levantarEntidad(m3);
		this.juego.getGui().levantarEntidad(m4);
		this.juego.getGui().levantarEntidad(m5);
		
				
	}

}
