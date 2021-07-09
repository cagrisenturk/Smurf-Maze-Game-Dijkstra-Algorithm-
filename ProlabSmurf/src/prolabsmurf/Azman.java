package prolabsmurf;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Azman extends Düşman {
	private Image azman;
	private Lokasyon ilkLokasyon;
	public Azman(int id, String ad, String tür, Lokasyon konum,Lokasyon ilkLokasyon) {
		super(id, ad, tür, konum);
		azman=new ImageIcon("azman.png").getImage();
		this.ilkLokasyon=ilkLokasyon;
	}

	@Override
	public Image getPlayer1() {
		return azman;
	}
	@Override
	public void ilerle(int dx, int dy) {
		
		super.ilerle(dx,dy);
	}

	public Lokasyon getIlkLokasyon() {
		return ilkLokasyon;
	}

	public void setIlkLokasyon(Lokasyon ilkLokasyon) {
		this.ilkLokasyon = ilkLokasyon;
	}

	public Image getAzman() {
		return azman;
	}

	public void setAzman(Image azman) {
		this.azman = azman;
	}
	 
	
}
	 
	 


