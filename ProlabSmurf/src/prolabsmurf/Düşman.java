package prolabsmurf;

import java.awt.Image;

public class Düşman extends Karakter {
	private int dusmanID;
	private String dusmanAdi;
	private String dusmanTür;
	public Düşman(int id, String ad, String tür, Lokasyon konum) {
		super(id, ad, tür, konum);
		dusmanAdi=super.getAd();
		dusmanID=super.getId();
		dusmanTür=super.getTür();
	}
	public int getDusmanID() {
		return dusmanID;
	}
	public void setDusmanID(int dusmanID) {
		this.dusmanID = dusmanID;
	}
	public String getDusmanAdi() {
		return dusmanAdi;
	}
	public void setDusmanAdi(String dusmanAdi) {
		this.dusmanAdi = dusmanAdi;
	}
	public String getDusmanTür() {
		return dusmanTür;
	}
	public void setDusmanTür(String dusmanTür) {
		this.dusmanTür = dusmanTür;
	}
	
	

}
