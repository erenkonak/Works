package Helper;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import GUI.AnaMenuGUI;

public class helper extends AnaMenuGUI {
	
	public static void showmsg(String message) {
		String msg = null;
		
		switch(message) {
		case "fill":
			msg="L�tfen ge�erli alanlar� doldurunuz.";
			break;
		case "succes": 
			msg="��lem Ba�ar�l�";
			break;
		case "error":
			msg="i�lemi ger�ekle�tirirken hata olu�tu";
		default:
			msg=message;
		}
		JOptionPane.showMessageDialog(null, msg,"Mesaj", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public static boolean confirm(String str) {
		String msg;
		
		switch (str) {
		case "sure" :
			msg="bu i�lemi ger�ekle�tirmek istiyor musun ?";
			break;
		default:
			msg=str;
			break;
		}
	int res=JOptionPane.showConfirmDialog(null, msg,"Dikkat",JOptionPane.YES_NO_OPTION);
	if(res==0) {
		return true;
	}else {
		return false;}
	}
		public  void background(Graphics g) {
			super.paintComponents(g);
			
			Image image=new ImageIcon(this.getClass().getResource("/eren.png")).getImage();
			int baslangicX=0;
			int baslangicY=0;
			int bitisx=0;
			int bitisy=0;
			g.drawImage(image, baslangicX, baslangicY,bitisx,bitisy, null);
		}
	}
		
	

	
		
	


