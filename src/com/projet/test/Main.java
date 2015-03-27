package com.projet.test;

import com.projet.model.ChargerRepertoire;

public class Main {

	public static void main(String[] args) {
		
		/*ObjetImage oi1 = new ObjetImage("C:\\fgfg.jpg");
		ObjetImage oi2 = new ObjetImage("C:\\image.jpg");
//		oi1.setVisible(true);
//		oi2.setVisible(true);
		CalculSimilarite.getTauxSimlarite(oi1, oi2);
		
		GestionnaireSignature gs = new GestionnaireSignature(oi1);
		
		Utiles.getFileName("C:\\Users\\Nile\\Pictures\\image2.jpg");*/
		
		//File file = new File("C:\\Users\\Public\\Pictures\\Sample Pictures");
		
		//ChargerBDD maj = new ChargerBDD("C:\\Users\\Public\\Pictures\\Sample Pictures");
		
		//Utiles.listerRepertoire(file);
		
		//Utiles.copierFichier();
//		ObjetImage oi1 = new ObjetImage("C:\\fgfg.jpg");
//		ChargerImage ci = new ChargerImage(oi1);
		ChargerRepertoire cr = new ChargerRepertoire("C:\\Users\\Public\\Pictures\\Sample Pictures");
		
	}

}
