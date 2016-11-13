package Game;

import java.applet.AudioClip;

public class Sonido {
	protected AudioClip sonido;
	
	public Sonido(String s){
		sonido = java.applet.Applet.newAudioClip(this.getClass().getResource("/Sonidos/"+s+".wav"));
	}
	
	public void play(){
		sonido.play();
		
	}
	
	public void loop(){
		sonido.loop();
	}
	
	
	
	public void frenar(){
		sonido.stop();
	}
}
