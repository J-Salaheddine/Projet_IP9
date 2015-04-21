package com.projet.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.projet.outiles.StaticValues;
import com.projet.outiles.Utiles;


public class Main {

	public static void main(String[] args) {

		TestApp test = new TestApp();
		
		/**
		 * Test De chargement d'image a la BD (dossier)
		 */
//		String cheminImage = "C:\\Users\\Nile\\Pictures\\salahImage.jpg";
//		test.chargerImage(cheminImage);
		
		
		
		/**
		 * Test de charement repértoire d'image a la BD
		 */
//		String cheminDossier = "C:\\Users\\Public\\Pictures\\Sample Pictures";
//		test.chargerRepertoire(cheminDossier);
		
		
		
		/**
		 * Test de callcule de cimilarité
		 */
		String cheminImageATester = "C:\\Users\\Nile\\Pictures\\salahImage.jpg";
		test.rechercheImageSimlaire(cheminImageATester, 0.6f);
		
		//Utiles.emptyDirectory(StaticValues.BDD_SIGANTURE);

	}

}
