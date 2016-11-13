package Tanque;

import java.awt.event.KeyEvent;
import java.util.Random;

import Game.EntidadGrafica;
import Game.InterfazGui;
import Game.Juego;
import PU.PowerUp;

public class Enemigo extends Tanque implements Runnable{
	protected boolean execute;
	protected boolean choque;
	public Enemigo(float x, float y, Juego juego,InterfazGui gui,byte nivel){
		switch(nivel){
		case 0:
			level=new NivelLento();
			break;
		case 1:
			level=new NivelRapido();
			break;
		case 2:
			level=new NivelPoder();
			break;
		case 3:
			level=new NivelBlindado();
			break;
		}
		this.golpesQueResiste=level.getGolpesQueResiste();
		disparosDisponibles=level.getDisparosSimultaneos();
		posX= x;
		posY= y;
		this.grafico = new EntidadGrafica("/imagenes/enemy1-37.png",32,32);
		this.gui=gui;
		this.juego=juego;
	}

	public void mover(int dir){
		switch(dir){
		case KeyEvent.VK_UP  :
				if(juego.TanquePuedeEstarAca(posX,posY-(2*level.getVelocidadM()),this) && juego.TanquePuedeEstarAca(posX+32, posY-(2*level.getVelocidadM()),this)){
					posY-=2*level.getVelocidadM();
					choque = false;
				}else
					choque = true;
			break;
		case KeyEvent.VK_DOWN  :
			if(juego.TanquePuedeEstarAca(posX,(posY+32)+(2*level.getVelocidadM()),this)&& juego.TanquePuedeEstarAca(posX+32, posY+32+(2*level.getVelocidadM()),this)){
				posY+=2*level.getVelocidadM();
				choque = false;
			}else
				choque = true;
			break;
		case KeyEvent.VK_RIGHT :
			if(juego.TanquePuedeEstarAca(posX+32+(2*level.getVelocidadM()),posY,this) && juego.TanquePuedeEstarAca(posX+32+(2*level.getVelocidadM()), posY+32,this)){	
				posX+=2*level.getVelocidadM();
				choque = false;
			}
			else
				choque = true;
			break;
		case KeyEvent.VK_LEFT  :
			if(juego.TanquePuedeEstarAca(posX-(2*level.getVelocidadM()),posY,this)&& juego.TanquePuedeEstarAca(posX-(2*level.getVelocidadM()), posY+32,this)){
				posX-=2*level.getVelocidadM();
				choque = false;
			}
			else
				choque = true;
			break;
		}
		if(lastMovement!=dir){
			lastMovement=dir;
			getGrafico().cambiarImagen(getNivel().getImg(dir));
		}
		
		juego.getGui().moverEntidad(grafico,(int) posX,(int) posY);
	}
	
	public void terminate(){
		this.execute = false;
	}
	
	public void run(){
		this.execute=true;
		Random r = new Random();
		int direccion;
		direccion = 40;
	
		while (execute){
			if (choque){
				mover(direccion);
				direccion = (r.nextInt(97)%4)+37;
				
				choque = false;}
		
			else
				mover(direccion);
			
			try {
				
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void efectuarDisparo(){
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(disparosDisponibles>0){
			Disparo disparo=new DisparoEnemigo(this.juego,gui,this,level.VelocidadD,level.getdestruyeMetal(),(int)posX+13,(int)posY+13,this.lastMovement);
			disparosDisponibles--;
			gui.levantarEntidad(disparo);
			Thread t=new Thread(disparo);
			t.start();
		}
	}
	public int getPuntaje(){
		return level.getPuntaje();
	}
	public int reducirVida(){
		this.golpesQueResiste--;
		return golpesQueResiste;
	}
	
	public void serAfectado(Disparo d) {
		
		if(this.reducirVida()==0){
			juego.eliminarMalo(this);
		}
	}
	public void serAfectado(PowerUp pu){
		
	}
}
