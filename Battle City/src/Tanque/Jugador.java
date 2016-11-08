package Tanque;

import java.awt.event.KeyEvent;

import Game.EntidadGrafica;
import Game.InterfazGui;
import Game.Juego;
import PU.PowerUp;
public class Jugador extends Tanque {
	protected int vida;
	protected boolean invulnerable;
	public Jugador(Juego juego,float x, float y ){
		this.juego=juego;
		this.grafico=new EntidadGrafica("/imagenes/lvl4-37.png", 32,32);
		level= new Nivel4();
		disparosDisponibles=level.getDisparosSimultaneos();
		posX= x;
		posY= y;
		this.vida=3;
		this.invulnerable=false;
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
			this.juego.jugadorActivaPw(posX,posY);
			if(lastMovement!=k){
				lastMovement=k;
				getGrafico().cambiarImagen(getNivel().getImg(k));
			}
			gui.moverEntidad(this.getGrafico(), (int)posX, (int)posY);
			
	}
	public void setInvulnerable(){
		invulnerable=!invulnerable;
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
		this.getGrafico().cambiarImagen(this.getNivel().getImg(this.lastMovement));
		disparosDisponibles=level.getDisparosSimultaneos();
		golpesQueResiste=level.getGolpesQueResiste();
		return level;
	}
	
	public void serAfectado(PowerUp p){
		p.afectar(this);
	}
	private void meHitearon(){
		if(--golpesQueResiste==0){
			if(this.reducirVida()!=0){
				float[] posIniciales=juego.getPosXInicialTanque();
				posX=posIniciales[0];
				posY=posIniciales[1];
				level=new Nivel1();
				disparosDisponibles=level.getDisparosSimultaneos();
				golpesQueResiste=level.GolpesQueResiste;
				gui.moverEntidad(this.getGrafico(), (int)posX, (int)posY);
			}
			else juego.gameOver();
		}
	}
	private int reducirVida(){
		this.vida--;
		return this.vida;
	}
	public void aumentarVida(){
		this.vida++;
	}
	public void serAfectado(Disparo d) {
		System.out.println("me han hitea2");
		if(!invulnerable)
			this.meHitearon();
	}
	
}
