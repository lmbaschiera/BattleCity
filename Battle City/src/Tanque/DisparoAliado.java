package Tanque;

public class DisparoAliado {
	
	
	
	
	public void afectar(Jugador j){}
	
	public void afectar(Enemigo e){
		if(e.getNivel().GolpesQueResiste == 1){
			
			
			
		}else{
			e.getNivel().GolpesQueResiste-=1;
		
		}
	}
}
