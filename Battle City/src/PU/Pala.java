package PU;

import Game.EntidadGrafica;
import Game.Juego;
import Game.Mapa;
import Pisos.Ladrillo;
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
		for(int i=5;i<=7;i++){
			for(int c=11;c<=12;c++){
				this.juego.getGui().getMapa().eliminarCelda(this.juego.getGui().getMapa().getCelda(i, c));
				Metal m1 = new Metal(this.juego.getGui().getMapa() , i, c);
				this.juego.getGui().getMapa().setCelda(m1,i,c);
				this.juego.getGui().levantarEntidad(m1);
			}
		}
		try {
			Thread.sleep(20000); // 20 seg la base con metal
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=5;i<=7;i++){
			for(int c=11;c<=12;c++){
				this.juego.getGui().getMapa().eliminarCelda(this.juego.getGui().getMapa().getCelda(i, c));
				Ladrillo m1 = new Ladrillo( this.juego.getGui().getMapa() , i, c);
				this.juego.getGui().getMapa().setCelda(m1,i,c);
				this.juego.getGui().levantarEntidad(m1);
			}
		}		
	}

}
