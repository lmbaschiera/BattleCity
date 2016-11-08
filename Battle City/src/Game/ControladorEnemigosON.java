package Game;

public class ControladorEnemigosON extends Thread {
	protected Juego j;
	volatile boolean execute;
	public ControladorEnemigosON(Juego j){
		this.j=j;
	}
	public void terminate(){
		execute=false;
	}
	public void run(){
		this.execute=true;
		while(execute){
			try {
				if(j.cantEnemigosON()<4){
					j.crearMalo();
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
