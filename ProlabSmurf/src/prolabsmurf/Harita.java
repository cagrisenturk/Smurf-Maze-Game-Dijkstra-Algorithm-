package prolabsmurf;


import java.io.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;


import java.awt.*;

public class Harita {
	
	private BufferedReader oku;
	private int Map[][]= new int[11][13];
	private Image duvar,yol,sirine;
	private ArrayList<Azman> azmanlar;
	private ArrayList<Gargamel> gargameller;
	private Lokasyon azmanlok,gargamellok;
	private Lokasyon azmanilklok,gargamelilklok;
	
	
	public Harita() {
		yol = new ImageIcon("yol.png").getImage();
		duvar = new ImageIcon("duvar.png").getImage();
		sirine= new ImageIcon("sirine.png").getImage();
		azmanlar=new ArrayList<>();
		gargameller=new ArrayList<>();
		readFile();
		
	}
	
	public Image getSirine() {
		return sirine;
	}

	public void readFile() {
		try
        {
            BufferedReader br = new BufferedReader(new FileReader("harita.txt"));
            int i=0;
            for(String line ; (line = br.readLine()) != null; )
            {
                if(line.startsWith("K"))
                {
                    String[] integerStrings = line.split(":");
                    if (integerStrings.length>=3) {
                       
                    }

                    if (integerStrings[1].startsWith("Azman"))
                    {
                    	
                    	 if (integerStrings[2].startsWith("A")) {
                              azmanlok=new Lokasyon(0,3 );
                              azmanilklok=new Lokasyon(0, 3);
                         } else if (integerStrings[2].startsWith("B")) {
                        	  azmanlok=new Lokasyon(0,10 );
                        	  azmanilklok=new Lokasyon(0,10 );
                         } else if (integerStrings[2].startsWith("C")) {
                        	  azmanlok=new Lokasyon(5,0);
                        	  azmanilklok=new Lokasyon(5,0);
                         } else if (integerStrings[2].startsWith("D")) {
                        	  azmanlok=new Lokasyon(10,3 );
                        	  azmanilklok=new Lokasyon(10,3 );
                         } 
                    	 Azman azman=new Azman(0, "azman", "düşman", azmanlok,azmanilklok);
                    	azmanlar.add(azman);
                    }
                    else if (integerStrings[1].startsWith("Gargamel"))
                    {
                    	
                    	 if (integerStrings[2].startsWith("A")) {
                             gargamellok=new Lokasyon(0,3 );
                             gargamelilklok=new Lokasyon(0,3 );
                        } else if (integerStrings[2].startsWith("B")) {
                       	  gargamellok=new Lokasyon(0,10);
                       	  gargamelilklok=new Lokasyon(0,10 );
                        } else if (integerStrings[2].startsWith("C")) {
                       	  gargamellok=new Lokasyon(5,0);
                       	  gargamelilklok=new Lokasyon(5,0);
                        } else if (integerStrings[2].startsWith("D")) {
                       	  gargamellok=new Lokasyon(10,3 );
                       	  gargamelilklok=new Lokasyon(10,3 );
                        } 
                   	 Gargamel gargamel=new Gargamel(0, "gargamel", "düşman", gargamellok,gargamelilklok);
                   	gargameller.add(gargamel);
                    }
                  

                }
                else
                {
                    String[] integerStrings = line.split("\\s+");
                    for (int j = 0; j < integerStrings.length; j++)
                    {
                        Map[i][j] = Integer.parseInt(integerStrings[j]);
                        
                    }
                    i++;
                    
                }
            }
           br.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
	  
	
	
}
	
	public ArrayList<Azman> getAzmanlar() {
		return azmanlar;
	}

	public void setAzmanlar(ArrayList<Azman> azmanlar) {
		this.azmanlar = azmanlar;
	}

	public ArrayList<Gargamel> getGargameller() {
		return gargameller;
	}

	public void setGargameller(ArrayList<Gargamel> gargameller) {
		this.gargameller = gargameller;
	}

	public Image getDuvar() {
		return duvar;
	}
	
	public Image getYol() {
		return yol;
	}
	
	public int getMap(int x, int y) {
		int index=Map[x][y];
		return index;
	}
}
