package prolabsmurf;

import java.awt.Image;

import javax.swing.ImageIcon;

public class TembelŞirin extends Oyuncu{
	private Image tembelsirin;
	
	public TembelŞirin(int id, String ad, String tür, Lokasyon konum, int skor) {
		super(id, ad, tür, konum, skor);
		tembelsirin=new ImageIcon("tembelsirin.png").getImage();
	}

	@Override
	public Image getPlayer1() {
		return tembelsirin;
	}
	@Override
	public void ilerle(int dx, int dy) {
	super.ilerle(dx, dy);
	}

	public Image getTembelsirin() {
		return tembelsirin;
	}

	public void setTembelsirin(Image tembelsirin) {
		this.tembelsirin = tembelsirin;
	}
}
