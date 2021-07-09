package prolabsmurf;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Gargamel extends Düşman {
	private Image gargamel;
	private Lokasyon ilkLokasyon;
	public Gargamel(int id, String ad, String tür, Lokasyon konum,Lokasyon ilkLokasyon) {
		super(id, ad, tür, konum);
		gargamel=new ImageIcon("gargamel.png").getImage();
		this.ilkLokasyon=ilkLokasyon;
	}
	@Override
	public Image getPlayer1() {
		return gargamel;
	}
	@Override
	public void ilerle(int dx, int dy) {
		super.ilerle(dx, dy);
	}
	public Image getGargamel() {
		return gargamel;
	}
	public void setGargamel(Image gargamel) {
		this.gargamel = gargamel;
	}
	public Lokasyon getIlkLokasyon() {
		return ilkLokasyon;
	}
	public void setIlkLokasyon(Lokasyon ilkLokasyon) {
		this.ilkLokasyon = ilkLokasyon;
	}
	

	

}
