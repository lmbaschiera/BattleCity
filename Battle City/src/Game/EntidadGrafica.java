package Game;

import javax.swing.JLabel;

public class EntidadGrafica {
	protected JLabel grafico;
	public EntidadGrafica(JLabel grafico){
		this.grafico=grafico;
	}
	public JLabel getGrafico(){
		return grafico;
	}
	public int getH(){
		return grafico.getHeight();
	}
	public int getW(){
		return grafico.getWidth();
	}
}
