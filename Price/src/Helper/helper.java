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
			msg="Lütfen geçerli alanlarý doldurunuz.";
			break;
		case "succes": 
			msg="Ýþlem Baþarýlý";
			break;
		case "error":
			msg="iþlemi gerçekleþtirirken hata oluþtu";
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
		
	

	
		
	


