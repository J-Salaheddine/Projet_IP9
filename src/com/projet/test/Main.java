package com.projet.test;

import com.projet.controleur.Controleur;

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
		
//		LectureSignature lf = new LectureSignature("C:\\Users\\Nile\\Documents\\GitHub\\Projet_IP9\\BDD\\Signature\\Chrysanthemum.txt");
//		lf.affiche();
		
		Controleur controleur = new Controleur();
		controleur.rechercheImageSimlaire("C:\\Users\\Nile\\Pictures\\image2.jpg", 0.6f);
		
	}

}
