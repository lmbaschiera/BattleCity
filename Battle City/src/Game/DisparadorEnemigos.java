package Game;

public class DisparadorEnemigos extends Thread {
	volatile private boolean execute;
	protected Juego j;
	public DisparadorEnemigos(Juego j){
		this.j=j;
		
	}
	public void terminate(){
		execute=false;
	}
	public void run(){		
		try {
			sleep(1000);
			this.execute=true;
			while(execute){
				int i=1;
				while(i<=j.cantEnemigosON()){
					j.getEnemigo(i++).efectuarDisparo();
					Thread.sleep(150);
				}
				
			}
		}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

