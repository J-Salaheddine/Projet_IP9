package com.projet.test;

public class Main {

	public static void main(String[] args) {

		TestApp test = new TestApp();
		
		/**
		 * Test De chargement d'image a la BD (dossier)
		 */
		//String cheminImage = "C:\\Users\\Nile\\Pictures\\salahImage.jpg";
		//test.chargerImage(cheminImage);
		
		
		
		/**
		 * Test de charement repértoire d'image a la BD
		 */
//		String cheminDossier = "C:\\Users\\Nile\\Google Drive\\DESIGN\\Wallpapers HD\\N";
//		test.chargerRepertoire(cheminDossier);
		

		
		/**
		 * Test de callcule de cimilarité
		 */
		String cheminImageATester = "C:\\Users\\Nile\\Pictures\\salahImage.jpg";
		test.rechercheImageSimlaire(cheminImageATester, 0.8f);
		
	}

}
