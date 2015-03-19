package com.projet.test;

import com.projet.image.ImageWindows2;
import com.projet.image.TraitementImages;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is a test !!");
		TraitementImages TI = new TraitementImages();
		
		ImageWindows2 iw = new ImageWindows2("C:\\image2.jpg");
		iw.setVisible(true);
	}

}
