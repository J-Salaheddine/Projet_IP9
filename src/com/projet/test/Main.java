package com.projet.test;

import com.projet.image.ObjetImage;
import com.projet.image.Utiles;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ObjetImage oi1 = new ObjetImage("C:\\image2.jpg");
		ObjetImage oi2 = new ObjetImage("C:\\image.jpg");
//		oi1.setVisible(true);
//		oi2.setVisible(true);
		System.out.println(Utiles.calculerDistance(oi1, oi2));
		System.out.println(Utiles.deffinirIntervalRG(10));
	}

}
