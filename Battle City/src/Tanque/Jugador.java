package Tanque;

import java.awt.event.KeyEvent;

import Game.EntidadGrafica;
import Game.InterfazGui;
import Game.Juego;
import PU.PowerUp;
public class Jugador extends Tanque {
	private boolean PuedoMoverme;
	
	
	public Jugador(Juego juego,float x, float y ){
		this.juego=juego;
		this.grafico=new EntidadGrafica("/imagenes/37.png", 32,32);
		level= new Nivel4();
		disparosDisponibles=level.getDisparosSimultaneos();
		posX= x;
		posY= y;
		
	}
	public void setGui(InterfazGui gui){
		this.gui=gui;
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
			gui.moverEntidad(this.getGrafico(), (int)posX, (int)posY);
			lastMovement=k;
	}
	public void efectuarDisparo(){
		if(disparosDisponibles>0){
			
			int corrimiento_x=0,corrimiento_y=0;
			switch(lastMovement){
			case KeyEvent.VK_UP :
				corrimiento_y=-1;
				break;
			case KeyEvent.VK_DOWN :
				corrimiento_y=1;
				break;
			case KeyEvent.VK_RIGHT :
				corrimiento_x=1;
				break;
			case KeyEvent.VK_LEFT :
				corrimiento_x=-1;
				break;
			}
			Disparo disparo=new Disparo(this.juego,gui,this,level.VelocidadD,level.getdestruyeMetal(),(int)posX+16,(int)posY+16,corrimiento_x,corrimiento_y);
		//	System.out.println(""+this.disparosDisponibles);
			disparosDisponibles--;
			gui.levantarEntidad(disparo);
			juego.disparar(disparo);
			System.out.println(""+this.disparosDisponibles);
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
		level=level.getSiguiente();
		disparosDisponibles=level.getDisparosSimultaneos();
		golpesQueResiste=level.GolpesQueResiste;
		return level;
	}
	public boolean a(){
		return PuedoMoverme;
	}
	
	public void serAfectado(PowerUp p){
		//p.afectar(this);
	}
	public void reducirVida(){}
	public void serAfectado(Disparo d){
		//d.afectar(this);
	}
	
}
