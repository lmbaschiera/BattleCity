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
		this.grafico=new EntidadGrafica("/imagenes/lvl4-37.png", 32,32);
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
					if(juego.TanquePuedeEstarAca(posX,posY-(2*level.getVelocidadM()),this) && juego.TanquePuedeEstarAca(posX+32, posY-(2*level.getVelocidadM()),this)){
						posY-=2*level.getVelocidadM();
					}
				break;
			case KeyEvent.VK_DOWN :
				if(juego.TanquePuedeEstarAca(posX,(posY+32)+(2*level.getVelocidadM()),this)&& juego.TanquePuedeEstarAca(posX+32, posY+32+(2*level.getVelocidadM()),this)){
					posY+=2*level.getVelocidadM();
				}
				break;
			case KeyEvent.VK_RIGHT :
				if(juego.TanquePuedeEstarAca(posX+32+(2*level.getVelocidadM()),posY,this) && juego.TanquePuedeEstarAca(posX+32+(2*level.getVelocidadM()), posY+32,this)){	
					posX+=2*level.getVelocidadM();
				}
				break;
			case KeyEvent.VK_LEFT :
				if(juego.TanquePuedeEstarAca(posX-(2*level.getVelocidadM()),posY,this)&& juego.TanquePuedeEstarAca(posX-(2*level.getVelocidadM()), posY+32,this)){
					posX-=2*level.getVelocidadM();
				}
				break;
			}
			if(lastMovement!=k){
				lastMovement=k;
				getGrafico().cambiarImagen(getNivel().getImg(k));
			}
			gui.moverEntidad(this.getGrafico(), (int)posX, (int)posY);
			
	}
	public void efectuarDisparo(){
		if(disparosDisponibles>0){
			Disparo disparo=new DisparoAliado(this.juego,gui,this,level.VelocidadD,level.getdestruyeMetal(),(int)posX+13,(int)posY+13,lastMovement);
			disparosDisponibles--;
			gui.levantarEntidad(disparo);
			Thread t=new Thread(disparo);
			t.start();
		}
	}
	public float getX(){
		return posX;
	}
	public float getY(){
		return posY;
	}
	public Nivel subirNivel(){
		level=level.getSiguiente();
		this.getGrafico().cambiarImagen(this.getNivel().getImg(this.lastMovement-37));
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
	public void reducirVida(){
		if(level.reducirVida()==0){
			juego.gameOver();
		}
		
		float[] posIniciales=juego.getPosXInicialTanque();
		posX=posIniciales[0];
		posY=posIniciales[1];
		level=new Nivel1();
		gui.moverEntidad(this.getGrafico(), (int)posX, (int)posY);
	}
	
	public void serAfectado(Disparo d) {
		System.out.println("me han hitea2");
		this.reducirVida();
	}
	
}
