package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Pisos.Agua;
import Pisos.Aguila;
import Pisos.Arbol;
import Pisos.Celda;
import Pisos.Ladrillo;
import Pisos.Metal;
import Pisos.Tierra;

public class Mapa implements InterfazMapa {
	private Celda[][] map;
	private int h;
	private int w;
	private InterfazGui gui;
	private Juego j;
	public Mapa(int x,Juego j){
		this.h=x;
		this.w=x;
		map= new Celda[x][x];
	}
	public void setCelda(Celda celda, int x, int y){
		map[x][y]=celda;
	}
	public Celda getCelda(int x,int y){
		return map[x][y];
	}
	public void armarMapa(String str){
		BufferedReader br = null;
		String file = str;
		String sCurrent;
		try {
			br = new BufferedReader(new FileReader(file));
			Celda celda;
			int columna=0;
			while((sCurrent = br.readLine())!=null){
				for(int i=0;i<sCurrent.length();i++){
					char ch=sCurrent.charAt(i);
					switch(ch){	
					case'0': 	
						celda=new Tierra(this,i,columna);
						this.setCelda(celda,i,columna);	
						break; 
						
					case'1': 	
						celda=new Ladrillo(this,i,columna);
						this.setCelda(celda,i,columna);	
						break; 
					case '2':	
						celda=new Arbol(this,i,columna);
						this.setCelda(celda,i,columna);	
						break;
					case '3':	
						celda=new Agua(this,i,columna);
						this.setCelda(celda,i,columna);	
						break;
					case '4': 	
						celda=new Metal(this,i,columna);
						this.setCelda(celda,i,columna);	
						break;
					case '5':
						celda=new Aguila(this, i, columna);
						this.setCelda(celda, i, columna);
						break;
					}
				}
				columna+=1;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public int getTamaño(){
		return h;
	}
	@Override
	public void setGui(InterfazGui gui) {
		this.gui=gui;
	}
	@Override
	public void eliminarCelda(Celda c) {
		gui.eliminarEntidad(c.getEntidadGrafica());
		Celda cel=new Tierra(this,(int)c.getX(),(int)c.getY());
		cel.setPU(c.getPU());
		this.map[(int)c.getX()][(int)c.getY()]=null;
		
		this.map[(int)c.getX()][(int)c.getY()]=cel;
		this.setCelda(cel,(int)cel.getPosX(),(int)cel.getPosY());	
	}
}
