package com.projet.model;

import java.io.File;

import com.projet.outils.Signature;

public class ChargerRepertoire {

	/**
	 * Cette classe permet de charger tout les images d'un dossier dans la base de donnée
	 * @param cheminDuDossier
	 */
	public ChargerRepertoire(String cheminDuDossier){
		super();
		listerRepertoire(cheminDuDossier);
	}
	
	public void listerRepertoire(String cheminDuDossier) {
		File repertoire = new File(cheminDuDossier);
		String[] listefichiers;

		int i;
		listefichiers = repertoire.list();
		for (i = 0; i < listefichiers.length; i++) {
			if (listefichiers[i].endsWith(".jpg") == true || listefichiers[i].endsWith(".png") == true) {
				Signature objetImage = new Signature(cheminDuDossier+"\\"+listefichiers[i]);
				new ChargerImage(objetImage);
			}
		}
	}
}
