package Tanque;

import java.awt.event.KeyEvent;

import Game.EntidadGrafica;
import Game.Juego;
public class Jugador extends Tanque {
	private boolean PuedoMoverme;
	private Juego juego;
	
	
	public Jugador(float x, float y, Juego juego){
		level= new Nivel1();
		disparosDisponibles=level.getDisparosSimultaneos();
		posX= x;
		posY= y;
		this.juego=juego;
	}
	/*
	 * Actualiza la posicion del jugador en funcion de la tecla pasada por parametro
	 */
	public void mover(int k){
			switch(k){
			case KeyEvent.VK_UP :
					if(juego.TanquePuedeEstarAca(posX,posY-(2*level.getVelocidadM())) && juego.TanquePuedeEstarAca(posX+32, posY-(2*level.getVelocidadM()))){
						System.out.println(posX+"<- asd ->"+(posY));
						posY-=2*level.getVelocidadM();
					}
				break;
			case KeyEvent.VK_DOWN :
				if(juego.TanquePuedeEstarAca(posX,(posY+32)+(2*level.getVelocidadM()))&& juego.TanquePuedeEstarAca(posX+32, posY+32+(2*level.getVelocidadM()))){
					System.out.println(posX+"<- asd ->"+(posY));
					posY+=2*level.getVelocidadM();
				}
				break;
			case KeyEvent.VK_RIGHT :
				if(juego.TanquePuedeEstarAca(posX+32+(2*level.getVelocidadM()),posY) && juego.TanquePuedeEstarAca(posX+32+(2*level.getVelocidadM()), posY+32)){	
					System.out.println((posX)+"<- asd ->"+posY);
					posX+=2*level.getVelocidadM();
				}
				break;
			case KeyEvent.VK_LEFT :
				if(juego.TanquePuedeEstarAca(posX-(2*level.getVelocidadM()),posY)&& juego.TanquePuedeEstarAca(posX-(2*level.getVelocidadM()), posY+32)){
					System.out.println((posX)+"<- asd ->"+(posY));
					posX-=2*level.getVelocidadM();
				}
				break;
			}
			lastMovement=k;
	}
	public void efectuarDisparo(EntidadGrafica jl){
		if(disparosDisponibles>0){
			Disparo disparo=new Disparo(this,level.VelocidadD,level.destruyeMetal,jl,posX+16,posY+16);
			
			int corrimiento_x=0,corrimiento_y=0;
			switch(lastMovement){
			case KeyEvent.VK_UP :
				corrimiento_y=-5;
				break;
			case KeyEvent.VK_DOWN :
				corrimiento_y=5;
				break;
			case KeyEvent.VK_RIGHT :
				corrimiento_x=5;
				break;
			case KeyEvent.VK_LEFT :
				corrimiento_x=-5;
				break;
			}
			disminuirDisparosDisponibles();
			disparo.run(juego,corrimiento_x,corrimiento_y);
		}
	}
	
	public float getX(){
		return posX;
	}
	public float getY(){
		return posY;
	}
	public boolean PuedoMoverme(int k){
		
		return true;
	}
	public Nivel subirNivel(){
		return level=level.getSiguiente();
	}
	public boolean a(){
		return PuedoMoverme;
	}
	@Override
	public void afectar() {}
}
