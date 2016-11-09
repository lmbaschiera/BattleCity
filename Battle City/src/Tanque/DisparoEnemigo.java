package Tanque;

import Game.InterfazGui;
import Game.Juego;

public class DisparoEnemigo extends Disparo {
	public DisparoEnemigo(Juego juego,InterfazGui gui, Tanque tanque,int velocidad, boolean romperMetal, float x, float y,int lastMovement){
		super(juego,gui,tanque,velocidad,romperMetal,x,y,lastMovement);
	}
	
	public void run(){
		try{
			execute = true;
			while (execute){
				if(juego.DisparoPuedeEstarAca(posX+(corrimiento_x*velocidad), posY+(corrimiento_y*velocidad),this.direccion,this)){
					posX+=corrimiento_x*velocidad;
					posY+=corrimiento_y*velocidad;
					gui.moverEntidad(this.grafico, (int)posX, (int)posY);
					Thread.sleep(10);
				}
				else{
					execute=false;
				}
			}
			MiTanque.aumentarDisparosDisponibles();
			if (gui.getMapa().getCelda((int)(posX+(corrimiento_x*velocidad))/40, (int)(posY+(corrimiento_y*velocidad))/40)!=null)
				gui.getMapa().getCelda((int)(posX+(corrimiento_x*velocidad))/40, (int)(posY+(corrimiento_y*velocidad))/40).serAfectado(this,this.juego);
			gui.eliminarEntidad(grafico);
	}
		catch(InterruptedException e1){}
}
}
