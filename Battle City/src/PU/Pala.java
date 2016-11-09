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
		for(int i=5;i<=7;i++){
			for(int c=11;c<=12;c++){
				if(!(i==6 && c==12)){
					this.juego.getGui().getMapa().eliminarCelda(this.juego.getGui().getMapa().getCelda(i, c));
					Metal m1 = new Metal(this.juego.getGui().getMapa() , i, c);
					this.juego.getGui().getMapa().setCelda(m1,i,c);
					this.juego.getGui().levantarEntidad(m1);
				}
			}
		}
		int tiempo =20000;
		int actual = 0;
		while (tiempo>actual){
			actual+=100;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		for(int i=5;i<=7;i++){
			for(int c=11;c<=12;c++){
				if(!(i==6 && c==12)){
					this.juego.getGui().getMapa().eliminarCelda(this.juego.getGui().getMapa().getCelda(i, c));
					Ladrillo m1 = new Ladrillo( this.juego.getGui().getMapa() , i, c);
					this.juego.getGui().getMapa().setCelda(m1,i,c);
					this.juego.getGui().levantarEntidad(m1);
				}
			}
		}		
		
	}

	@Override
	public void afectar(Jugador j) {
			Thread t1 = new Thread(this);
			t1.start();
	}

}
