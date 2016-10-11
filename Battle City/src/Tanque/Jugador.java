package Tanque;

import java.awt.event.KeyEvent; 

import Game.Juego;
public class Jugador extends Tanque {
	private float posX;
	private float posY;
	private boolean PuedoMoverme;
	private Nivel level;
	private Juego juego;
	public Jugador(float x, float y, Juego juego){
		level= new Nivel1();
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
					if(juego.PuedoEstarAca(posX,posY-(2*level.getVelocidadM())) && juego.PuedoEstarAca(posX+32, posY-(2*level.getVelocidadM()))){
						System.out.println(posX+"<- asd ->"+(posY));
						posY-=2*level.getVelocidadM();
					}
				break;
			case KeyEvent.VK_DOWN :
				if(juego.PuedoEstarAca(posX,(posY+32)+(2*level.getVelocidadM()))&& juego.PuedoEstarAca(posX+32, posY+32+(2*level.getVelocidadM()))){
					System.out.println(posX+"<- asd ->"+(posY));
					posY+=2*level.getVelocidadM();
				}
				break;
			case KeyEvent.VK_RIGHT :
				if(juego.PuedoEstarAca(posX+32+(2*level.getVelocidadM()),posY) && juego.PuedoEstarAca(posX+32+(2*level.getVelocidadM()), posY+32)){	
					System.out.println((posX)+"<- asd ->"+posY);
					posX+=2*level.getVelocidadM();
				}
				break;
			case KeyEvent.VK_LEFT :
				if(juego.PuedoEstarAca(posX-(2*level.getVelocidadM()),posY)&& juego.PuedoEstarAca(posX-(2*level.getVelocidadM()), posY+32)){
					System.out.println((posX)+"<- asd ->"+(posY));
					posX-=2*level.getVelocidadM();
				}
				break;
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
