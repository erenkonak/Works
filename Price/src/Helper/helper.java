package Helper;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class helper  {
	
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
			msg="Do you want to do this operation??";
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
		
	}
		
	

	
		
	


