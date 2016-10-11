package Game;

import Pisos.Agua;
import Pisos.Celda;

public class Mapa {
	private Celda[][] map;
	private int h;
	private int w;
	public Mapa(int x){
		this.h=x;
		this.w=x;
		map= new Celda[x][x];
	}
	public int getH(){
		return h;
	}
	public int getW(){
		return w;
	}
	public void setCelda(Celda celda, int x, int y){
		map[x][y]=celda;
	}
	public Celda getCelda(int x,int y){
		return map[x][y];
	}
}
