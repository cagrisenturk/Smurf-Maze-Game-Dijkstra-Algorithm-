package prolabsmurf;

import java.awt.Image;

import javax.swing.ImageIcon;

public  class Karakter {
	private int Id;
	private String Ad;
	private String tür;
	private Image görsel;
	private Lokasyon konum;
	private int[][] harita = new int[11][13];
    private int[][] yol = new int[100][2];
    private int mesafe = 0;

public Karakter( int id, String ad, String tür, Lokasyon konum) {
	
	Id = id;
	Ad = ad;
	this.tür = tür;
	this.konum = konum;
}
public void sirinTakip(int AdimSayisi,int ŞirinX,int ŞirinY,Harita map) {
    for (int j = 0; j < AdimSayisi; j++) {

        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 13; y++) {
                harita[x][y] = 100;
            }
        }
        harita[getKonum().getX()][getKonum().getY()] = 0;
        rotaBul(getKonum().getX() - 1, getKonum().getY(), 1, map);
        rotaBul(getKonum().getX() + 1, getKonum().getY(), 1, map);
        rotaBul(getKonum().getX(), getKonum().getY() - 1, 1, map);
        rotaBul(getKonum().getX(), getKonum().getY() + 1, 1, map);
        

      

        mesafe = harita[ŞirinX][ŞirinY];
        yol[mesafe][0] = ŞirinX;
        yol[mesafe][1] = ŞirinY;
      /*  for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 13; y++) {
                System.out.print(harita[x][y]+" ");
            }
            System.out.println("\n");
        }
        */
        for (int i = mesafe - 1; i > -1; i--) {
        	
            if (harita[yol[i + 1][0] + 1][yol[i + 1][1]] == i) {
                yol[i][0] = yol[i + 1][0] + 1;
                
                yol[i][1] = yol[i + 1][1];
            } else if (harita[yol[i + 1][0] - 1][yol[i + 1][1]] == i) {
                yol[i][0] = yol[i + 1][0] - 1;
                yol[i][1] = yol[i + 1][1];
            } else if (harita[yol[i + 1][0]][yol[i + 1][1] + 1] == i) {
                yol[i][0] = yol[i + 1][0];
                yol[i][1] = yol[i + 1][1] + 1;
            } else if (harita[yol[i + 1][0]][yol[i + 1][1] - 1] == i) {
                yol[i][0] = yol[i + 1][0];
                yol[i][1] = yol[i + 1][1] - 1;
            }
            //System.out.println(yol[i][0]+" "+yol[i][1]+"\n");
        }

        ilerle(yol[1][0] - getKonum().getX(), yol[1][1] - getKonum().getY());
       

    }

}
public int[][] getHarita() {
	return harita;
}
public void setHarita(int[][] harita) {
	this.harita = harita;
}
public int[][] getYol() {
	return yol;
}
public void setYol(int[][] yol) {
	this.yol = yol;
}
public int getMesafe() {
	return mesafe;
}
public void setMesafe(int mesafe) {
	this.mesafe = mesafe;
}
public void rotaBul(int konumX, int konumY, int mesafe,  Harita m) {
    if ((konumX > -1) && (konumY > -1) && (konumX < 10) && (konumY < 12)) {
         
            if ((m.getMap(konumX, konumY)==1) && (harita[konumX][konumY] > mesafe)) {
                harita[konumX][konumY] = mesafe;
                rotaBul(konumX - 1, konumY, mesafe + 1, m);
                rotaBul(konumX + 1, konumY, mesafe + 1, m);
                rotaBul(konumX, konumY - 1, mesafe + 1, m);
                rotaBul(konumX, konumY + 1, mesafe + 1, m);
            

        }
    }
}
public Lokasyon getKonum() {
	return konum;
}
public void setKonum(Lokasyon konum) {
	this.konum = konum;
}
public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getAd() {
		return Ad;
	}

	public void setAd(String ad) {
		Ad = ad;
	}

	public String getTür() {
		return tür;
	}

	public void setTür(String tür) {
		this.tür = tür;
	}


	public void setPlayer1(Image player1) {
		this.görsel = player1;
	}
public Image getPlayer1() {
	return görsel;
}
public void ilerle(int dx,int dy) {
	konum.setX(konum.getX()+dx);
	konum.setY(konum.getY()+dy);;
}
}
