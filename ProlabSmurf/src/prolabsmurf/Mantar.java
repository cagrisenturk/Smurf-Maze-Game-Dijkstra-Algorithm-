package prolabsmurf;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Mantar extends Obje {
	private Image Mantar;
	public Image getMantar() {
		return Mantar;
	}
	public Mantar(int puan, String ad, Lokasyon konum) {
		super(puan, ad, konum);
		Mantar=new ImageIcon("mantar.png").getImage();
	}
	
	

	

	

	
}
