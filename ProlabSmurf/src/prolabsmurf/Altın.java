package prolabsmurf;

import java.awt.Image;


import javax.swing.ImageIcon;

public class Altın extends Obje {
	private Image Altın;

	public Altın(int puan, String ad, Lokasyon konum) {
		super(puan, ad, konum);
		Altın=new ImageIcon("altn.png").getImage();
	}



	public Image getAltın() {
		return Altın;
	}
	

}
