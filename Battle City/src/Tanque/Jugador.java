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
		this.grafico=new EntidadGrafica("/imagenes/lvl1-37.png", 32,32);
		level= new Nivel1();
		disparosDisponibles=level.getDisparosSimultaneos();
		this.golpesQueResiste=level.getGolpesQueResiste();
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
	public int getVida() {
		return vida;
	}
	public void setInvulnerable(){
		invulnerable=(!invulnerable);
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
		juego.getGui().armarHits();
		return level;
	}
	
	public void serAfectado(PowerUp p){
		p.afectar(this);
	}
	private void resetearJugador(){
		float[] posIniciales=juego.getPosXInicialTanque();
		posX=posIniciales[0];
		posY=posIniciales[1];
		level=new Nivel1();
		this.getGrafico().cambiarImagen(this.getNivel().getImg(this.lastMovement));
		disparosDisponibles=level.getDisparosSimultaneos();
		golpesQueResiste=level.GolpesQueResiste;
		juego.getGui().armarHits();
		gui.moverEntidad(this.getGrafico(), (int)posX, (int)posY);
	}
	private void meHitearon(){
		--golpesQueResiste;
		juego.getGui().armarHits();
		if(golpesQueResiste==0){
			resetearJugador();
			this.reducirVida();
			juego.getGui().armarVida();
			if(this.vida==0){
				 juego.gameOver();
			}
		}
	}
	private int reducirVida(){
		this.vida--;
		this.juego.getGui().armarVida();
		return this.vida;
	}
	public void aumentarVida(){
		this.vida++;
		this.juego.getGui().armarVida();
	}
	public void serAfectado(Disparo d) {
		if(!invulnerable){
			this.meHitearon();
		}
	}
	
}
