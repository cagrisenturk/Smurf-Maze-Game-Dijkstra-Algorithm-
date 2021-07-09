package prolabsmurf;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GözlüklüŞirin extends Oyuncu{
	private Image gozluklusirin;
	
	public GözlüklüŞirin(int id, String ad, String tür, Lokasyon konum, int skor) {
		super(id, ad, tür, konum, skor);
		gozluklusirin=new ImageIcon("gozluklusirin.png").getImage();
	}

	@Override
	public Image getPlayer1() {
	return gozluklusirin;
	}
	public Image getGozluklusirin() {
		return gozluklusirin;
	}

	public void setGozluklusirin(Image gozluklusirin) {
		this.gozluklusirin = gozluklusirin;
	}

	@Override
	public void ilerle(int dx, int dy) {
	super.ilerle(2*dx, 2*dy);
	}
	
	

}
