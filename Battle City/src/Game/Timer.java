package Game;

public class Timer extends Thread {
	volatile private boolean execute;
	private Juego j;
	int t;
	public Timer(Juego j){
		this.j=j;
		t=0;
	}
	public void start(){
		execute=true;
		run();
	}
	public void run(){
		try{
			while (execute){
				sleep(1000);
				t++;
				j.setTimer(t);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void terminate() {
		execute=false;		
	}
}
