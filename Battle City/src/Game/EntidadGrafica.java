package Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGrafica {
	protected JLabel grafico;
	protected String src;
	protected int H,W;
	public EntidadGrafica(String str, int h, int w){
		H=h;
		W=w;
		src=str;
		JLabel aux=new JLabel();
		aux.setIcon(new ImageIcon(this.getClass().getResource(str)));
		aux.setVisible(true);
		this.grafico=aux;
	}
	public JLabel getGrafico(){
		return grafico;
	}
	public int getH(){
		return H;
	}
	public int getW(){
		return W;
	}
	public void cambiarImagen(String str){
		grafico.setIcon(new ImageIcon(this.getClass().getResource(str)));
	}
	public String getImagen(){
		return src;
	}
}
