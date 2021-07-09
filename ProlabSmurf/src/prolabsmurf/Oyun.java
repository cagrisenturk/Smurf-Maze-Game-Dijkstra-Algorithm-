package prolabsmurf;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;




public class Oyun extends JPanel implements ActionListener {
	private javax.swing.Timer timer;
	private Harita harita;
	private Oyuncu oyuncu;
	private Image arkaplan;
	private ArrayList<Altın> altınlar;
	private int altıneklesüre=0,altınsilsüre=0,mantareklesüre=0,mantarsilsüre=0;
	private ArrayList<Mantar> mantarlar;
	private Lokasyon oyunculok,altınlok,mantarlok;
	public Oyun() {
		harita= new Harita();
		if (Secim.kontrol) {
			oyunculok=new Lokasyon(5, 6);
			oyuncu=new TembelŞirin(0, "tembel sirin", "player", oyunculok, 20);
		}
		
		else {
			oyunculok=new Lokasyon(5, 6);
			oyuncu=new GözlüklüŞirin(0, "gozluklu sirin", "player", oyunculok, 20);
		}
		altınlar=new ArrayList<>();
		mantarlar=new ArrayList<>();
		addKeyListener(new Al());
		setFocusable(true);
		timer = new javax.swing.Timer(25, this);
		timer.start();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		arkaplan = new ImageIcon("smurf_mavisi.png").getImage();
		g.drawImage(arkaplan, 0, 0, null);
		for(int x=0;x<11;x++) {
			for(int y=0;y<13;y++) {
				if(harita.getMap(x, y)==0) {
					g.drawImage(harita.getDuvar(),y*64,64+x*64,null);
				}
				if(harita.getMap(x, y)==1 ) {
					g.drawImage(harita.getYol(),y*64,64+x*64,null);
				
				}
				if (x==7 && y==12) {
					g.drawImage(harita.getSirine(),y*64,64+x*64,null);
				}
				if(harita.getAzmanlar().isEmpty()==false) {
					for (int j = 0; j <harita.getAzmanlar().size(); j++) {
						for (int i = 1; i < harita.getAzmanlar().get(j).getMesafe(); i++) {
                    if (harita.getAzmanlar().get(j).getYol()[i][0] == x && harita.getAzmanlar().get(j).getYol()[i][1] == y) {
                        g.setColor(Color.ORANGE);
                        g.fillRect(64 * y, 64+64 * x, 64, 64);
                    }  
					}
				
                }
				}
				if (harita.getGargameller().isEmpty()==false) {
					for (int j = 0; j <harita.getGargameller().size(); j++) {
						for (int i = 1; i < harita.getGargameller().get(j).getMesafe(); i++) {
                    if (harita.getGargameller().get(j).getYol()[i][0] == x && harita.getGargameller().get(j).getYol()[i][1] == y) {
                        g.setColor(Color.RED);
                        g.fillRect(64 * y, 64+64 * x, 64, 64);
                    }  
					}
				
                }
		}
			}
		}
		altıneklesüre++;
		altınsilsüre++;
		if ((altınsilsüre==200)&&(altıneklesüre!=200)) {
			altınlar.clear();
			altıneklesüre=0;
		}
		if(altıneklesüre==400) {
                    	altınsilsüre=0;
			     for (int i = 0; i < 5; i++) {
                			int x = (int)(1+Math.random()*9);
                			int y = (int)(1+Math.random()*11);
                			if (harita.getMap(x, y)==1) {
                				altınlok=new Lokasyon(x, y);
                				Altın altın=new Altın(5, "altın", altınlok);
                				
                				altınlar.add(altın);
                			}
                			else {
                				i--;
                			}
                    	}
                    	}
		mantareklesüre++;
		mantarsilsüre++;
		if ((mantarsilsüre==280)&&(mantareklesüre!=280)) {
			mantarlar.clear();
			mantareklesüre=0;
		}
		if (mantareklesüre==800) {
			mantarsilsüre=0;
			for (int i = 0; i < 1; i++) {
    			int x = (int)(1+Math.random()*9);
    			int y = (int)(1+Math.random()*11);
    			if (harita.getMap(x, y)==1) {
    				mantarlok=new Lokasyon(x, y);
    			Mantar	mantar= new Mantar(50, "mantar", mantarlok);
    				mantarlar.add(mantar);
    			}
    			else {
    				i--;
    			}
		}
			}
                		
		for (int i = 0; i <altınlar.size() ; i++) {
			g.drawImage(altınlar.get(i).getAltın(),altınlar.get(i).getKonum().getY()*64 , 64+altınlar.get(i).getKonum().getX()*64,null);
			
		}
		if (mantarlar.isEmpty()==false) {
			g.drawImage(mantarlar.get(0).getMantar(), mantarlar.get(0).getKonum().getY()*64, 64+mantarlar.get(0).getKonum().getX()*64,null);
			if ((mantarlar.get(0).getKonum().getX()==oyuncu.getKonum().getX())&&(mantarlar.get(0).getKonum().getY()==oyuncu.getKonum().getY())) {
				oyuncu.setSkor(mantarlar.get(0).getPuan());
				mantarlar.remove(0);
			}
		}
		
		g.drawImage(oyuncu.getPlayer1(),oyuncu.getKonum().getY()*64,64+oyuncu.getKonum().getX()*64,null);
		
		
		if (altınlar.isEmpty()==false) {
			for (int i = 0; i < altınlar.size(); i++) {
				if ((altınlar.get(i).getKonum().getX()==oyuncu.getKonum().getX())&&(altınlar.get(i).getKonum().getY()==oyuncu.getKonum().getY())) {
					oyuncu.setSkor(altınlar.get(i).getPuan());
					altınlar.remove(i);
				}
			}	
		}
		
		
		if (harita.getAzmanlar().isEmpty()==false) {
			for (int i = 0; i < harita.getAzmanlar().size(); i++) {
			if ((oyuncu.getKonum().getX()==harita.getAzmanlar().get(i).getKonum().getX()) && (oyuncu.getKonum().getY()==harita.getAzmanlar().get(i).getKonum().getY())) {
			oyuncu.setSkor(-15);
			harita.getAzmanlar().get(i).getKonum().setX(harita.getAzmanlar().get(i).getIlkLokasyon().getX());
			harita.getAzmanlar().get(i).getKonum().setY(harita.getAzmanlar().get(i).getIlkLokasyon().getY());
			
			skorKontrol();
		}
			g.drawImage(harita.getAzmanlar().get(i).getPlayer1(),harita.getAzmanlar().get(i).getKonum().getY()*64,64+harita.getAzmanlar().get(i).getKonum().getX()*64,null);
		}
		}
		if (harita.getGargameller().isEmpty()==false) {
			for (int i = 0; i < harita.getGargameller().size(); i++) {
				if ((oyuncu.getKonum().getX()==harita.getGargameller().get(i).getKonum().getX()) && (oyuncu.getKonum().getY()==harita.getGargameller().get(i).getKonum().getY())) {
				oyuncu.setSkor(-5);
				//gargamel.getKonum().setX(harita.getGargamelx());
				//gargamel.getKonum().setY(harita.getGargaemly());
				harita.getGargameller().get(i).setKonum(harita.getGargameller().get(i).getIlkLokasyon());
				//harita.getGargameller().get(i).setKonum().setY(harita.getGargameller().get(i).getIlkLokasyon());
				skorKontrol();
			}
				g.drawImage(harita.getGargameller().get(i).getPlayer1(),harita.getGargameller().get(i).getKonum().getY()*64,64+harita.getGargameller().get(i).getKonum().getX()*64,null);
			}
		}
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Stencil", Font.PLAIN, 17));
		g.drawString("Skor="+oyuncu.PuaniGoster(), 30, 30);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Stencil", Font.PLAIN, 17));
		g.drawString("Seçilen Karakter : "+oyuncu.getAd(), 250, 30);
		g.drawImage(oyuncu.getPlayer1(), 570, 0, null);
		
		
		
		
	}

	public class Al extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			int keycode = e.getKeyCode(); 
			if (keycode==KeyEvent.VK_UP) {
				if(oyuncu.getAd()=="tembel sirin" && (harita.getMap(oyuncu.getKonum().getX() - 1,oyuncu.getKonum().getY())!=0)) {
					oyuncu.ilerle(-1, 0);
					if (harita.getAzmanlar().isEmpty()==false) {
						for (int i = 0; i < harita.getAzmanlar().size(); i++) {
							harita.getAzmanlar().get(i).sirinTakip(2,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);	
						}
					
					}
					if (harita.getGargameller().isEmpty()==false) {
						for (int i = 0; i < harita.getGargameller().size(); i++) {
							harita.getGargameller().get(i).sirinTakip(1,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);
						}
						
					}
					
					
				}
				if(oyuncu.getAd()=="gozluklu sirin" && (harita.getMap(oyuncu.getKonum().getX() - 1,oyuncu.getKonum().getY())!=0)&&(!(oyuncu.getKonum().getX()==1&&oyuncu.getKonum().getY()==10)) &&(harita.getMap(oyuncu.getKonum().getX() - 2,oyuncu.getKonum().getY())!=0)) {
					oyuncu.ilerle(-1, 0);
					if (harita.getAzmanlar().isEmpty()==false) {
						for (int i = 0; i < harita.getAzmanlar().size(); i++) {
							harita.getAzmanlar().get(i).sirinTakip(2,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);	
						}
					
					}
					if (harita.getGargameller().isEmpty()==false) {
						for (int i = 0; i < harita.getGargameller().size(); i++) {
							harita.getGargameller().get(i).sirinTakip(1,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);
						}
						
					}
					
					
				}
			}
			if (keycode==KeyEvent.VK_DOWN) {
				if(oyuncu.getAd()=="tembel sirin"&&(harita.getMap(oyuncu.getKonum().getX() + 1,oyuncu.getKonum().getY())!=0)) {
					oyuncu.ilerle( 1, 0);
					if (harita.getAzmanlar().isEmpty()==false) {
						for (int i = 0; i < harita.getAzmanlar().size(); i++) {
							harita.getAzmanlar().get(i).sirinTakip(2,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);	
						}
					
					}
					if (harita.getGargameller().isEmpty()==false) {
						for (int i = 0; i < harita.getGargameller().size(); i++) {
							harita.getGargameller().get(i).sirinTakip(1,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);
						}
						
					}
					
					
				}
				if(oyuncu.getAd()=="gozluklu sirin"&&(harita.getMap(oyuncu.getKonum().getX() + 1,oyuncu.getKonum().getY())!=0)&&(harita.getMap(oyuncu.getKonum().getX() +2 ,oyuncu.getKonum().getY())!=0)) {
					oyuncu.ilerle( 1, 0);
					if (harita.getAzmanlar().isEmpty()==false) {
						for (int i = 0; i < harita.getAzmanlar().size(); i++) {
							harita.getAzmanlar().get(i).sirinTakip(2,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);	
						}
					
					}
					if (harita.getGargameller().isEmpty()==false) {
						for (int i = 0; i < harita.getGargameller().size(); i++) {
							harita.getGargameller().get(i).sirinTakip(1,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);
						}
						
					}
					
					
				}
				
			}
			if (keycode==KeyEvent.VK_LEFT) {
				if(oyuncu.getAd()=="tembel sirin"&&(harita.getMap(oyuncu.getKonum().getX() ,oyuncu.getKonum().getY()-1)!=0)) {
					oyuncu.ilerle( 0, -1);
					if (harita.getAzmanlar().isEmpty()==false) {
						for (int i = 0; i < harita.getAzmanlar().size(); i++) {
							harita.getAzmanlar().get(i).sirinTakip(2,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);	
						}
					
					}
					if (harita.getGargameller().isEmpty()==false) {
						for (int i = 0; i < harita.getGargameller().size(); i++) {
							harita.getGargameller().get(i).sirinTakip(1,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);
						}
						
					}
					
					
				}
				if(oyuncu.getAd()=="gozluklu sirin"&&(harita.getMap(oyuncu.getKonum().getX() ,oyuncu.getKonum().getY()-2)!=0)&&(harita.getMap(oyuncu.getKonum().getX() ,oyuncu.getKonum().getY()-1)!=0)) {
					oyuncu.ilerle( 0, -1);
					if (harita.getAzmanlar().isEmpty()==false) {
						for (int i = 0; i < harita.getAzmanlar().size(); i++) {
							harita.getAzmanlar().get(i).sirinTakip(2,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);	
						}
					
					}
					if (harita.getGargameller().isEmpty()==false) {
						for (int i = 0; i < harita.getGargameller().size(); i++) {
							harita.getGargameller().get(i).sirinTakip(1,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);
						}
						
					}
					
					
				}
				
			}
			if (keycode==KeyEvent.VK_RIGHT) {
				if(oyuncu.getAd()=="tembel sirin"&&(harita.getMap(oyuncu.getKonum().getX() ,oyuncu.getKonum().getY()+1)!=0)) {
					oyuncu.ilerle(0, 1);
					if ((!((oyuncu.getKonum().getX()==7)&&(oyuncu.getKonum().getY()==12)))) {
						if (harita.getAzmanlar().isEmpty()==false) {
							for (int i = 0; i < harita.getAzmanlar().size(); i++) {
								harita.getAzmanlar().get(i).sirinTakip(2,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);	
							}
						
						}
						if (harita.getGargameller().isEmpty()==false) {
							for (int i = 0; i < harita.getGargameller().size(); i++) {
								harita.getGargameller().get(i).sirinTakip(1,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);
							}
							
						}
					}
					
					
					
					
				}
				if(oyuncu.getAd()=="gozluklu sirin"&&(harita.getMap(oyuncu.getKonum().getX() ,oyuncu.getKonum().getY()+2)!=0)&&(harita.getMap(oyuncu.getKonum().getX() ,oyuncu.getKonum().getY()+1)!=0)) {
					oyuncu.ilerle(0, 1);
					if ((!((oyuncu.getKonum().getX()==7)&&(oyuncu.getKonum().getY()==12)))) {
						if (harita.getAzmanlar().isEmpty()==false) {
							for (int i = 0; i < harita.getAzmanlar().size(); i++) {
								harita.getAzmanlar().get(i).sirinTakip(2,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);	
							}
						
						}
						if (harita.getGargameller().isEmpty()==false) {
							for (int i = 0; i < harita.getGargameller().size(); i++) {
								harita.getGargameller().get(i).sirinTakip(1,oyuncu.getKonum().getX(), oyuncu.getKonum().getY(), harita);
							}
							
						}
					}
					
				}
				
			}
			bitişKontrol();
		}
		
		
		
        public void keyRelased(KeyEvent e) {
			
		}
        public void keyTyped(KeyEvent e) {
			
		}
		
	}
	public void bitişKontrol(){
		if ((oyuncu.getKonum().getX()==7)&&(oyuncu.getKonum().getY()==12)) {
			 JOptionPane.showMessageDialog(null, "İyi Oyundu Tebrikler"+ "\nSKORUNUZ: "+oyuncu.getSkor(), "OYUN BİTTİ!", 1);
			 System.exit(0);
		}
		
		}
	public void skorKontrol(){
		if (oyuncu.getSkor()<=0) {
			 JOptionPane.showMessageDialog(null, "Kaybettiniz :(", "OYUN BİTTİ!", 1);
			 System.exit(0);
		}
		
		
		
	}
	
	
}
