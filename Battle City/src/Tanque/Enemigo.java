package Tanque;

import java.awt.event.KeyEvent;
import java.util.Random;

import Game.EntidadGrafica;
import Game.Juego;

public class Enemigo extends Tanque implements Runnable{
	boolean execute;
	boolean choque;
	public Enemigo(float x, float y, Juego juego){
		
		level= new Nivel1();
		disparosDisponibles=level.getDisparosSimultaneos();
		posX= x;
		posY= y;
		this.grafico = new EntidadGrafica("/imagenes/enemy37.png",32,32);
		super.juego=juego;
		
		
	}
	

	

	

	public void mover(int dir){
		switch(dir){
		case 1 :
				if(juego.TanquePuedeEstarAca(posX,posY-(2*level.getVelocidadM())) && juego.TanquePuedeEstarAca(posX+32, posY-(2*level.getVelocidadM()))){
					System.out.println(posX+"<- asd ->"+(posY));
					posY-=2*level.getVelocidadM();
					choque = false;
				}else
					choque = true;
			break;
		case 3 :
			if(juego.TanquePuedeEstarAca(posX,(posY+32)+(2*level.getVelocidadM()))&& juego.TanquePuedeEstarAca(posX+32, posY+32+(2*level.getVelocidadM()))){
				System.out.println(posX+"<- asd ->"+(posY));
				posY+=2*level.getVelocidadM();
				choque = false;
			}else
				choque = true;
			break;
		case 2 :
			if(juego.TanquePuedeEstarAca(posX+32+(2*level.getVelocidadM()),posY) && juego.TanquePuedeEstarAca(posX+32+(2*level.getVelocidadM()), posY+32)){	
				System.out.println((posX)+"<- asd ->"+posY);
				posX+=2*level.getVelocidadM();
				choque = false;
			}
			else
				choque = true;
			break;
		case 0 :
			if(juego.TanquePuedeEstarAca(posX-(2*level.getVelocidadM()),posY)&& juego.TanquePuedeEstarAca(posX-(2*level.getVelocidadM()), posY+32)){
				System.out.println((posX)+"<- asd ->"+(posY));
				posX-=2*level.getVelocidadM();
				choque = false;
			}
			else
				choque = true;
			break;
		}
		lastMovement=dir;
		juego.getGui().cambiarImagen(this,dir);
		juego.getGui().moverEntidad(grafico,(int) posX,(int) posY);
	}
	
	public void terminate(){
		this.execute = false;
	}
	
	public void run(){
		this.execute=true;
		Random r = new Random();
		int direccion;
		direccion = r.nextInt(3);
		while (execute){
			if (choque){
				direccion = r.nextInt(4);
				mover(direccion);
				choque = false;}
		
			else
				mover(direccion);
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}}
