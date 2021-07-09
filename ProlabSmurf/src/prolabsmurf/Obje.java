package prolabsmurf;

public class Obje {
private int puan;
private String ad;
private Lokasyon konum;
public Obje(int puan, String ad, Lokasyon konum) {
	super();
	this.puan = puan;
	this.ad = ad;
	this.konum = konum;
}

public Lokasyon getKonum() {
	return konum;
}

public void setKonum(Lokasyon konum) {
	this.konum = konum;
}


public int getPuan() {
	return puan;
}
public void setPuan(int puan) {
	this.puan = puan;
}
public String getAd() {
	return ad;
}
public void setAd(String ad) {
	this.ad = ad;
}




}
