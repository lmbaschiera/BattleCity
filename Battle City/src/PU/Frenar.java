package PU;

import Game.EntidadGrafica;
import Game.Juego;
import Tanque.Jugador;

public class Frenar extends PowerUp  {

	public Frenar(Juego j, int x, int y){
		e=new EntidadGrafica("/imagenes/pu2.gif",32,32);
		this.juego = j;
		this.posX=x;
		this.posY=y;
	}
	
	public void run() {
		Thread t1;
		int tiempo =1000;
		int actual = 0;
		for(int i = 1;i<=this.juego.cantEnemigosON();i++){
			this.juego.getEnemigo(i).terminate();
			
		}
		while (tiempo>actual){
			actual+=100;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 1; i<=this.juego.cantEnemigosON();i++){
				t1= new Thread(this.juego.getEnemigo(i));
				t1.start();
			}
	}

	@Override
	public void afectar(Jugador j) {
		Thread t1 = new Thread(this);
		System.out.println("POWER UP ACTIVADO");
		t1.start();
		
	}

}
