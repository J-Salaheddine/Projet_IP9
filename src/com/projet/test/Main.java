package com.projet.test;

import com.projet.controleur.Controleur;
import com.projet.outiles.Signature;
import com.projet.outiles.Utiles;

public class Main {

	public static void main(String[] args) {
		
		/*ObjetImage oi1 = new ObjetImage("C:\\fgfg.jpg");
		ObjetImage oi2 = new ObjetImage("C:\\image.jpg");
//		oi1.setVisible(true);
//		oi2.setVisible(true);
		CalculSimilarite.getTauxSimlarite(oi1, oi2);
		
		GestionnaireSignature gs = new GestionnaireSignature(oi1);*/
		
		//System.out.println(Utiles.getFileName("C:\\Users\\Nile\\Pictures\\salahImage.jpg"));
		
		//File file = new File("C:\\Users\\Public\\Pictures\\Sample Pictures");
		
		//ChargerBDD maj = new ChargerBDD("C:\\Users\\Public\\Pictures\\Sample Pictures");
		
//		LectureSignature lf = new LectureSignature("C:\\Users\\Nile\\Documents\\GitHub\\Projet_IP9\\BDD\\Signature\\Chrysanthemum.txt");
//		lf.affiche();
		
		
//		String s1 = "[0,0,0,1,7065,88413,507265,183688]";
//		String s2 = "[0,0,0,0,302,291840,433540,60749,1,0,0,0,0,0,0,0]";
//		String s3 = "[0,0,0,0,0,0,0,0,34352,278695,217359,191068,64286,670,2,0]";
//		Controleur controleur = new Controleur();
//		//controleur.rechercheImageSimlaire("C:\\Users\\Nile\\Pictures\\image2.jpg", 0.6f);
//		Signature sig1 = new Signature("C:\\Users\\Nile\\Pictures\\image2.jpg");
//		//Signature sig2 = new Signature(s1,s2,s3);
	
		//System.out.println(	controleur.calculerDeSimilarite(sig1, sig2));
		
//		Utiles.getFileName("C:\\Users\\Nile\\Pictures\\image2.jpg");
//		System.out.println(Utiles.getFileName2("C:\\Users\\Nile\\Pictures\\image2.jpg"));
		
		/**
		 * getfile name
		 * get extancer
		 * image2
		 */
		//System.out.println(Utiles.getSignatureFromeTab("[12,25,63,25]"));
		
		
		TestApp test = new TestApp();
		test.chargerImage("C:\\Users\\Nile\\Pictures\\salahImage.jpg");
	}

}
